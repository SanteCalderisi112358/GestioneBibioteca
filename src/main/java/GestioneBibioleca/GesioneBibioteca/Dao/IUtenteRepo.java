package GestioneBibioleca.GesioneBibioteca.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import GestioneBibioleca.GesioneBibioteca.Entities.Libro;
import GestioneBibioleca.GesioneBibioteca.Entities.Utente;

@Repository
public interface IUtenteRepo extends JpaRepository<Utente, Integer> {

	@Query("SELECT libro FROM Libro libro JOIN libro.prestiti prestito WHERE prestito.utente.id = :utenteId AND prestito.dataRestituzioneEffettiva IS NULL")
	public List<Libro> libriScaduti(@Param("utenteId") int idUtente);
}
