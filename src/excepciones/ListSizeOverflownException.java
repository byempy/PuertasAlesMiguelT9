package excepciones;

public class ListSizeOverflownException extends RuntimeException {

	public ListSizeOverflownException(){
		super("Te saliste del tama�o posible de la lista");
	}
}
