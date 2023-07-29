package GestioneBibioleca.GesioneBibioteca.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String titolo;
	private String autore;
	private String genere;
	private boolean inPrestito;
	@OneToMany(mappedBy = "libro")
	private List<Prestito> prestiti;

	public Libro(String titolo, String autore, String genere, boolean inPrestito) {


		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.inPrestito = inPrestito;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", genere=" + genere + "]";
	}

}
