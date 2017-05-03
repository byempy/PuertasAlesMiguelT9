package models;

import java.util.*;
import excepciones.*;

public class ListaOrdenada<E> extends ArrayList<E>{

	//VARIABLES PRIVADAS COMPARATOR Y UNA CONSTANTE PARA INDICAR EL TAMAÑO MAXIMO
	private Comparator comp;
	private final int max_size = 100;
	
	public ListaOrdenada(Comparator comp){
		super();
		this.comp = comp;
	}
	
	//AÑADO ELEMENTOS CON SU VALIDACION DE ERRORES CON EXCEPCIONES Y ORDENANDO AL FINAL
	@Override
	public boolean add(E element) throws ElementNotAllowedException, ListSizeOverflownException{
		boolean result = false;
		
		if(element != null){
			if(this.size() <= max_size){
				result = super.add(element);
			}else{
				throw new ListSizeOverflownException();
			}
		}else{
			throw new ElementNotAllowedException();
		}
		
		Collections.sort(this, comp);
		
		return result;
	}
	
	//Como la lista se va a acabar ordenando simplemente añado el elemento como si fuera un add normal
	@Override
	public void add(int i, E element){
		this.add(element);
	}
	
	//IGUAL QUE ADD PERO CON LAS MODIFICACIONES NECESARIAS PARA UNA COLECCION
	@Override
	public boolean addAll(Collection <? extends E> coll)throws ElementNotAllowedException, ListSizeOverflownException{
		boolean result = false;
		
		if(coll != null){
			if(coll.size()+this.size() <= max_size){
				result = super.addAll(coll);
			}else{
				throw new ListSizeOverflownException();
			}
		}else{
			throw new ElementNotAllowedException();
		}
		
		Collections.sort(this, comp);
		
		return result;
	}
	
	//Ya que se va a ordenar igualmente ignoro la posición y aprovecho el addAll normal de arriba.
	@Override
	public boolean addAll(int i, Collection <? extends E> coll){
		return this.addAll(coll);
	}
	
	//EN REMOVE NO HACE FALTA NINGUN TIPO DE VALIDACION DE EXCEPCIONES YA QUE AL NO PODER INTRODUCIR NULLS
	//AUNQUE SE MANDEN NULLS LO UNICO QUE PASARIA ES QUE LA CLASE PADRE NO LO ENCONTRARIA A LA HORA DE BORRAR
	//POR LO QUE ME DEDIQUE SIMPLEMENTE A HACER EL REMOVE Y ORDENAR
	@Override
	public boolean remove(Object element){
		boolean result = false;

		result = super.remove(element);

		Collections.sort(this, comp);
		
		return result;
	}
	
	//Aprovecho de nuevo una funcion ya hecha para hacer el codigo mas limpio..
	@Override
	public E remove(int i){
		E aux = this.get(i);
		this.remove(aux);
		return aux;
	}
	
	//EXACTAMENTE LO MISMO QUE CON REMOVE
	@Override
	public boolean removeAll(Collection <?> coll){
		boolean result = false;
		result = super.removeAll(coll);
		
		Collections.sort(this, comp);
		
		return result;
	}
	
	//IGUAL QUE REMOVE PERO BORRANDO POR RANGOS CON UNA PEQUEÑA VALIDACION
	@Override
	public void removeRange(int i, int f){
		try{
			super.removeRange(i, f);
		}
		catch(Exception e){
			System.err.println("Los indices estan fuera del intervalo..");
		}
		Collections.sort(this, comp);
	}
	
	//funcion que devuelve la lista al reves
	public List reverse(){
		List aux = this;
		Collections.reverse(aux);
		return aux;
	}
	
	public E min(){
		return (E) Collections.min(this, comp);
	}
	
	public E max(){
		return (E) Collections.max(this, comp);
	}
}
