package GestioneBibioleca.GesioneBibioteca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestioneBibioleca.GesioneBibioteca.Entities.Utente;

@Repository
public interface IUtenteRepo extends JpaRepository<Utente, Integer> {

}
