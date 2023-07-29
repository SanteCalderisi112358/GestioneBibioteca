package GestioneBibioleca.GesioneBibioteca.Entities;

import java.time.LocalDate;
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

		try {
			Utente utenteCheChiedePrestito = utenteSrv.findById(52);
			// System.err.println(utenteCheChiedePrestito);
			Libro libroInPrestito = libroSrv.findById(543);
			// System.err.println(libroInPrestito);
			Prestito prestito = new Prestito(LocalDate.of(2022, 5, 9), LocalDate.of(2022, 10, 11),
					utenteCheChiedePrestito, libroInPrestito);
			prestitoSrv.checkAndSave(prestito);
		} catch (ItemNotFoundException ex) {
			System.err.println(ex.getMessage());
		}



	}

}
