package GestioneBibioleca.GesioneBibioteca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import GestioneBibioleca.GesioneBibioteca.Entities.Prestito;

@Repository
public interface IPrestitoRepo extends JpaRepository<Prestito, Integer> {
	@Query("SELECT prestito FROM Prestito prestito WHERE utente.id = :idUtente AND prestito.libro.id =:idLibro")
	public Prestito returnBookFromUser(int idUtente, int idLibro);
}
