package GestioneBibioleca.GesioneBibioteca.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestioneBibioleca.GesioneBibioteca.Dao.IPrestitoRepo;
import GestioneBibioleca.GesioneBibioteca.Entities.ItemNotFoundException;
import GestioneBibioleca.GesioneBibioteca.Entities.Libro;
import GestioneBibioleca.GesioneBibioteca.Entities.Prestito;
import GestioneBibioleca.GesioneBibioteca.Entities.Utente;

@Service
public class PrestitoService {
@Autowired
IPrestitoRepo prestitoRepo;
@Autowired
UtenteService utenteSrv;
@Autowired
LibroService libroServ;

public void checkAndSave(Prestito prestito) throws ItemNotFoundException {
	int idLibro = prestito.getLibro().getId();
	int idUtente = prestito.getUtente().getId();
	System.err.println("Id Libro in prestito: " + idLibro);
	System.err.println("Id Utente che vuole chiedere il prestito: " + idUtente);

	Libro libro = libroServ.findById(idLibro);
	System.err.println(libro.toString());
	if (!libro.isInPrestito()) {
		/* controllo se l'utente ha possibili libri in prestito scadute */
		List<Libro> libriScadutiPerUtente = utenteSrv.checkLibriScaduti(idUtente);
		if (libriScadutiPerUtente.isEmpty()) {
			/* da fare dopo il controllo su possibili scadenze dell'utente */
		libro.setInPrestito(true);
		libroServ.save(libro);
		prestitoRepo.save(prestito);
		System.err.println(
				"Hai scelto il libro " + libro.getTitolo() + " in prestito fino al " + prestito.getDataRestituzione());
	} else {
		System.err.println("Non puoi prendere in prestito altri libri perchè hai i seguenti libri ancora in prstito: ");
		libriScadutiPerUtente.forEach(libroScaduto -> System.err.println(libroScaduto));
	}
} else if (libro.isInPrestito() && (prestito.getDataRestituzioneEffettiva() != null)) {
		libro.setInPrestito(false);
		libroServ.save(libro);
		System.err.println(libro.getTitolo() + " è stato consegnato il " + prestito.getDataRestituzioneEffettiva());
	} else {
		System.err.println("Il libro " + libro.getTitolo() + " è in prestito");

	}

}

public Prestito findById(int idPrestito) throws ItemNotFoundException {
	return prestitoRepo.findById(idPrestito).orElseThrow(() -> new ItemNotFoundException(idPrestito));

}

public void justSave(Prestito prestito) {
	prestitoRepo.save(prestito);
}

public void returnBookFromUser(int idUtente, int idLibro) throws ItemNotFoundException {
	Utente utente = utenteSrv.findById(idUtente);
	Libro libro = libroServ.findById(idLibro);
	Prestito prestito = prestitoRepo.returnBookFromUser(idUtente, idLibro);
	if (prestito.getDataRestituzioneEffettiva() == null && libro.isInPrestito() == true) {
		prestito.setDataRestituzioneEffettiva(LocalDate.now());
	libro.setInPrestito(false);
	libroServ.save(libro);
	prestitoRepo.save(prestito);
	System.err.println(
			"Il libro " + libro.getTitolo() + " con id " + libro.getId() + " è stato consegnato da " + utente.getNome()
					+ " " + utente.getCognome() + "(id: " + utente.getId() + ") il giorno " + LocalDate.now());
} else {
	System.err.println("Impossibile! Dai nostri registri risulta che il libro è stato restituito il giorno "
			+ prestito.getDataRestituzioneEffettiva());
}

}
}
