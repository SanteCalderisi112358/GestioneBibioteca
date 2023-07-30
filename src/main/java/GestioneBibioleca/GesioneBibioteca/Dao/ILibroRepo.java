package GestioneBibioleca.GesioneBibioteca.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import GestioneBibioleca.GesioneBibioteca.Entities.Libro;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Integer> {

	@Query("SELECT libro FROM Libro libro WHERE UPPER(libro.titolo) LIKE UPPER(concat('%', :titolo, '%'))")
	public List<Libro> searchTitle(String titolo);

	@Query("SELECT libro FROM Libro libro WHERE UPPER(libro.autore) LIKE UPPER(concat('%', :autore, '%'))")
	public List<Libro> searchAuthor(String autore);

	@Query("SELECT libro FROM Libro libro WHERE libro.inPrestito = false")
	public List<Libro> availableBooks();

	@Query("SELECT libro FROM Libro libro JOIN libro.prestiti prestito WHERE prestito.utente.id = :idUtente")
	public List<Libro> getBooksFromUser(int idUtente);


}
