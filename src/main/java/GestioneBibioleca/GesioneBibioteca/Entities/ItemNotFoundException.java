package GestioneBibioleca.GesioneBibioteca.Entities;

public class ItemNotFoundException extends Exception {
	public ItemNotFoundException(int id) {
		super("Elemento con id: " + id + " non trovato");
	}
}
