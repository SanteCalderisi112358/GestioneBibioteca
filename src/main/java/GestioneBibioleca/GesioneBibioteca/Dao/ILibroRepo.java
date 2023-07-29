package GestioneBibioleca.GesioneBibioteca.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestioneBibioleca.GesioneBibioteca.Entities.Libro;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Integer> {

}
