package GestioneBibioleca.GesioneBibioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestioneBibioleca.GesioneBibioteca.Dao.ILibroRepo;
import GestioneBibioleca.GesioneBibioteca.Entities.ItemNotFoundException;
import GestioneBibioleca.GesioneBibioteca.Entities.Libro;

@Service
public class LibroService {
	@Autowired
	ILibroRepo libroRepo;
	@Autowired
	UtenteService utenteSrv;

	public void save(Libro libro) {
		libroRepo.save(libro);
		System.err.println(libro.toString() + " salvato correttamente");
	}

	public Libro findById(int id) throws ItemNotFoundException {
		return libroRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

	}

	public void searchForTitle(String titolo) {
		List<Libro> listaLibriPerTitolo = libroRepo.searchTitle(titolo);
		if (listaLibriPerTitolo.isEmpty()) {
			System.err.println("In catalogo non abbiamo nessun libro che contenga: '" + titolo + "' nel titolo");
		} else {
			System.err.println("Lista dei libri che contengono '" + titolo + "' nel proprio titolo:");
			listaLibriPerTitolo.forEach(libro -> System.err.println(libro));
		}
	}

	public void searchForAuthor(String autore) {
		List<Libro> listaPerAutore = libroRepo.searchAuthor(autore);
		if (listaPerAutore.isEmpty()) {
			System.err.println("In catalogo non abbiamo nessun libro di " + autore);
		} else {
			System.err.println("Lista dei libri di " + autore.toUpperCase() + ":");
			listaPerAutore.forEach(libro -> System.err.println(libro));
		}
	}



	public void availableBooks() {
		List<Libro> libriDisponibili = libroRepo.availableBooks();
		if (libriDisponibili.isEmpty()) {
			System.err.println("Non ci sono libri disponibili");
		} else {
			System.err.println("Lista dei libri disponibili: ");
			libriDisponibili.forEach(libroDisponibile -> System.err.println(libroDisponibile));
		}
	}

	public List<Libro> getBooksFromUser(int idUtente) throws ItemNotFoundException {
		List<Libro> libriPresiInPrestitoDaUtente = libroRepo.getBooksFromUser(idUtente);
		if (libriPresiInPrestitoDaUtente.isEmpty()) {

			return null;
		} else {
			return libriPresiInPrestitoDaUtente;
		}
	}

	public void searchForTitleAndAvailable(String titolo) {
		List<Libro> listaLibriPerTitolo = libroRepo.searchTitle(titolo);
		if (listaLibriPerTitolo.isEmpty()) {
			System.err.println("In catalogo non abbiamo nessun libro che contenga: '" + titolo + "' nel titolo");
		} else {
			System.err.println(
					"Lista dei libri che contengono '" + titolo + "' nel proprio titolo e loro disponibilità:");
			for (int i = 0; i < listaLibriPerTitolo.size(); i++) {
				String disponibilita = listaLibriPerTitolo.get(i).isInPrestito() ? "IN PRESTITO" : "DISPONIBILE";
				System.err.println((i + 1) + " - '" + listaLibriPerTitolo.get(i).getTitolo() + "' di "
						+ listaLibriPerTitolo.get(i).getAutore() + ". ID: " + listaLibriPerTitolo.get(i).getId() + " - "
						+ disponibilita);
			}
		}
	}



}
