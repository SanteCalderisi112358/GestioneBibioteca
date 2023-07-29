package GestioneBibioleca.GesioneBibioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestioneBibioleca.GesioneBibioteca.Dao.IPrestitoRepo;
import GestioneBibioleca.GesioneBibioteca.Entities.ItemNotFoundException;
import GestioneBibioleca.GesioneBibioteca.Entities.Libro;
import GestioneBibioleca.GesioneBibioteca.Entities.Prestito;

@Service
public class PrestitoService {
@Autowired
IPrestitoRepo prestitoRepo;
@Autowired
UtenteService utenteSrv;
@Autowired
LibroService libroServ;

public void save(Prestito prestito) throws ItemNotFoundException {
	int idLibro = prestito.getLibro().getId();
	System.err.println("Id Libro in prestito: " + idLibro);
	Libro libro = libroServ.findById(idLibro);
	System.err.println(libro.toString());
	if (!libro.isInPrestito()) {
		libro.setInPrestito(true);
		libroServ.save(libro);
		prestitoRepo.save(prestito);
		System.err.println(
				"Hai scelto il libro " + libro.getTitolo() + " in prestito fino al " + prestito.getDataRestituzione());
	} else {
		System.err.println("Il libro " + libro.getTitolo() + " è in prestito");
	}
	// prestitoRepo.save(prestito);
	// System.err.println(prestito.toString() + " salvato correttamente");
}
}
