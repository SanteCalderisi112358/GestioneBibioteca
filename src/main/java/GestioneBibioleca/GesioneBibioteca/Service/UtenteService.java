package GestioneBibioleca.GesioneBibioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestioneBibioleca.GesioneBibioteca.Dao.IUtenteRepo;
import GestioneBibioleca.GesioneBibioteca.Entities.ItemNotFoundException;
import GestioneBibioleca.GesioneBibioteca.Entities.Utente;


@Service
public class UtenteService {
	@Autowired
	IUtenteRepo utenteRepo;

	public void save(Utente utente) {
		utenteRepo.save(utente);
		System.err.println(utente.toString() + " salvato correttamente");
	}

	public Utente findById(int id) throws ItemNotFoundException {
		return utenteRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

	}
}
