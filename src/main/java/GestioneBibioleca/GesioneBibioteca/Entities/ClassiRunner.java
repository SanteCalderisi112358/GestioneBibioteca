package GestioneBibioleca.GesioneBibioteca.Entities;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import GestioneBibioleca.GesioneBibioteca.Service.LibroService;
import GestioneBibioleca.GesioneBibioteca.Service.PrestitoService;
import GestioneBibioleca.GesioneBibioteca.Service.UtenteService;

@Component
public class ClassiRunner implements CommandLineRunner {
	@Autowired
	UtenteService utenteSrv;
	@Autowired
	LibroService libroSrv;

	@Autowired
	PrestitoService prestitoSrv;
	@Override
	public void run(String... args) throws Exception {
		Faker f = new Faker(Locale.ITALIAN);
//		for (int i = 0; i < 100; i++) {
//			Utente utente = new Utente(f.name().firstName(), f.name().lastName(), f.address().fullAddress());
//			utenteSrv.save(utente);
//		}
//
//		for (int i = 0; i < 1000; i++) {
//			Libro libro = new Libro(f.book().title(), f.book().author(), f.book().genre(), false);
//			libroSrv.save(libro);
//		}
		
//		for (int i = 0; i < 100; i++) {
//			Libro libro = new Libro(f.book().title(), f.book().author(), f.book().genre(), true);
//			libroSrv.save(libro);
//		}

		/* PRESTITO */

//		try {
//			Utente utenteCheChiedePrestito = utenteSrv.findById(76);
//			// System.err.println(utenteCheChiedePrestito);
//			Libro libroInPrestito = libroSrv.findById(546);
//			// System.err.println(libroInPrestito);
//			Prestito prestito = new Prestito(LocalDate.of(2022, 5, 9), LocalDate.of(2022, 10, 11),
//					utenteCheChiedePrestito, libroInPrestito);
//			prestitoSrv.checkAndSave(prestito);
//		} catch (ItemNotFoundException ex) {
//			System.err.println(ex.getMessage());
//		}
		
		/*RICERCA PER TITOLO*/

		String titoloParziale = "way";
		// libroSrv.searchForTitle(titoloParziale);

			/* RICERCA PER AUTORE */
			String autoreparziale = "rizz";
			// libroSrv.searchForAuthor(autoreparziale);

			/* RICERCA LIBRI DISPONIBILI */

			// libroSrv.availableBooks();

			/* RICERCA LISTA LIBRI IN PRESTITO DA UN UTENTE */
//			try {
//				int idUtente = 52;
//				Utente utente = utenteSrv.findById(idUtente);
//
//				if (libroSrv.getBooksFromUser(idUtente) == null) {
//					System.err.println(utente.getNome() + " " + utente.getCognome() + " non ha in prestito nulla.");
//				} else {
//					List<Libro> listaInPrestitoDaUtente = libroSrv.getBooksFromUser(idUtente);
//					System.err.println("Lista dei libri presi in prestito da " + utente.getNome() + " "
//							+ utente.getCognome() + ":\n");
//					listaInPrestitoDaUtente.forEach(libro -> System.err.println(libro));
//				}
//			} catch (ItemNotFoundException ex) {
//				System.err.println(ex.getMessage());
//			}

			/* RESTITUZIONE LIBRO */

//			try {
//				int utenteRestituzione = 52;
//				int libroRestituzione = 7;
//			prestitoSrv.returnBookFromUser(utenteRestituzione, libroRestituzione);
//		} catch (ItemNotFoundException ex) {
//			System.err.println(ex.getMessage());
//		}

		/* RICERCA PER TITOLO E VISUALIZZAZIONE DISPONIBILITA' */
		String titoloRicercaDisponibilita = "movin";
		libroSrv.searchForTitleAndAvailable(titoloRicercaDisponibilita);



	}

}
