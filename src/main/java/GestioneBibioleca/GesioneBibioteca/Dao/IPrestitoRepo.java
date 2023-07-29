package GestioneBibioleca.GesioneBibioteca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestioneBibioleca.GesioneBibioteca.Entities.Prestito;

@Repository
public interface IPrestitoRepo extends JpaRepository<Prestito, Integer> {

}
