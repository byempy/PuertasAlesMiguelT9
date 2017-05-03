package excepciones;

public class ElementNotAllowedException extends NullPointerException {

	public ElementNotAllowedException(){
		super("No se permite elementos nulos");
	}
}
