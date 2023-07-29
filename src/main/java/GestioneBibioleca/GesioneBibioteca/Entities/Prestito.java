package GestioneBibioleca.GesioneBibioteca.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Prestito {
	@Id
	@GeneratedValue
	private int id;
	private LocalDate dataPrenotazione;
	private LocalDate dataRestituzione;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Libro libro;

	public Prestito(LocalDate dataPrenotazione, Utente utente, Libro libro) {

		this.dataPrenotazione = dataPrenotazione;
		this.dataRestituzione = dataPrenotazione.plusMonths(2);
		this.utente = utente;
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", Data Inizio=" + dataPrenotazione + ", Data Restituzione=" + dataRestituzione
				+ ", " + utente + ", " + libro + "]";
	}

}
