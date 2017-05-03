package excepciones;

public class ListSizeOverflownException extends RuntimeException {

	public ListSizeOverflownException(){
		super("Te saliste del tamaño posible de la lista");
	}
}
