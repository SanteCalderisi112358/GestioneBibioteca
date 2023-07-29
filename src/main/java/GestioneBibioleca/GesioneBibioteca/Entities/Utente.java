package GestioneBibioleca.GesioneBibioteca.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Utente {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String cognome;
	private String indirizzo;
	@OneToMany(mappedBy = "utente")
	private List<Prestito> prestito;
	public Utente(String nome, String cognome, String indirizzo) {

		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + "]";
	}

}
