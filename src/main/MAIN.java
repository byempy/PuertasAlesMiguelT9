package main;

import models.*;

import java.util.*;

public class MAIN {

	public static void main(String[] args) {
		//CREO UNA LISTA ORDENADA Y LE PASO EL COMPARADOR EN ORDEN DESCENDENTE
		ListaOrdenada<Integer> po = new ListaOrdenada<Integer>(new Comparator<Integer>(){
			@Override		
			public int compare(Integer o1, Integer o2){
						return o2-o1;
					}
				});
		
		//LISTA AUXILIAR PARA HACER LAS PRUEBAS CON REMOVEALL Y ADDALL
		ArrayList<Integer> Lista2 = new ArrayList<Integer>();
		
		Lista2.add(69);
		Lista2.add(-69);
		
		//AÑADO ELEMENTOS
		po.add(4);
		po.add(8);
		po.add(4,2);//AÑADO ELEMENTO INDICANDO EL INDICE
		po.add(-5);
		
		//INTENTO AÑADIR UN ELEMENTO NULL
		System.out.println("Intento añadir un elemento null: ");
		try{
			po.add(null);
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}
		
		
		//ELIMINO UN ELEMENTO DE LA LISTA
		po.remove(2);
		
		//MUESTRO LA LISTA
		System.out.println("Lista ordenada descendentemente: ");
		System.out.println(po); //SE MOSTRARIA EN ORDEN DESCENDENTE
		
		//MUESTRO LA LISTA CON EL METODO REVERSE
		System.out.println("Lista reverse(): ");
		System.out.println(po.reverse()); //SE MOSTRARIA AL REVES (EN ORDEN ASCENDENTE)
		
		//MUESTRO EL MIN Y EL MAX
		System.out.println("Valor minimo: " + po.min());
		System.out.println("Valor maximo: " + po.max());
		
		//MUESTRO LA LISTA AUXILIAR
		System.out.println("Muestro la lista auxiliar: ");
		System.out.println(Lista2);
		
		//AÑADO LA LISTA2
		System.out.println("Añado la lista auxiliar con addAll y muestro el resultado: ");
		po.addAll(Lista2);
		System.out.println(po);
		
		//QUITO LA LISTA2
		System.out.println("Quito la lista auxiliar con removeAll y muestro el resultado");
		po.removeAll(Lista2);
		System.out.println(po);
		
		//INTENTO METER UNA COLECCION NULL
		System.out.println("Intento meter una coleccion nueva a null");
		try{
			po.addAll(null);
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}
		
		//INTENTO BORRAR DE NUEVO LA COLECCION
		System.out.println("Intento borrar de nuevo la lista auxiliar y muestro");
		po.removeAll(Lista2);
		System.out.println(po);
		
		//INTENTO BORRAR UN ELEMENTO QUE NO ESTE EN LA LISTA
		System.out.println("Intento borrar un elemento que no este en la lista");
		po.remove(new Integer(5));
		System.out.println(po);
		
		//BORRO UN ELEMENTO DE LA LISTA
		System.out.println("Borro un elemento que si existe de la lista(4)");
		po.remove(new Integer(4));
		System.out.println(po);
	}

}
