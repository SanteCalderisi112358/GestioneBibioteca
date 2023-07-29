package GestioneBibioleca.GesioneBibioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestioneBibioleca.GesioneBibioteca.Dao.ILibroRepo;
import GestioneBibioleca.GesioneBibioteca.Entities.ItemNotFoundException;
import GestioneBibioleca.GesioneBibioteca.Entities.Libro;

@Service
public class LibroService {
	@Autowired
	ILibroRepo libroRepo;

	public void save(Libro libro) {
		libroRepo.save(libro);
		System.err.println(libro.toString() + " salvato correttamente");
	}

	public Libro findById(int id) throws ItemNotFoundException {
		return libroRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

	}
}
