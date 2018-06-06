package GenericsBounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Como java trata a los genericos como tipo Objects, se tiene la restricci�n de que los metodos
 * disponibles sean muy limitados, para solucionar eso existen los Bounds
 * 
 * Unbounded wildcard					List<?> l = new ArrayList<String>()
 * Wildcard with an upper bound			List<? extends Exception> l = new ArrayList<RunTimeException>();
 * Wildcard with an lower bound			List<? super Exception> l = new ArrayList<Object>();
 * 
 * 
 * */
public class BoundExample {
/*			UNBOUNDED				*/
	public static void unbounded(List<String/*Object*/> lista){
		for(Object x:lista)
			System.out.println(x);
	}
/*			UPPER BOUNDED				*/
	public static long total(List<? extends Number> list){ 
/*	Si Number fuera una interfaz (lo cual ser�a valido) tambien ser�a extends y no implements*/
		long count = 0;
		for(Number number:list){		/*Ver que cuando se itera, ya no se trata como un Object*/
			count += number.longValue();	/*Incluso se tienen acceso a sus metodos*/
		}
		return count;
	}
	
	
	public static void main(String [] args){
/*			UNBOUNDED				*/
		
		/*si en el metodo unbounded recibiera un List<Object> y se le esta pasando un 
		 * List<String> no suena logico hacer esa asignaci�n, por lo que por eso se pone el wildcard.
		 * Pero eso s�, se trata a cada elemento de la lista como un tipo Object*/
		List<String> lista = new ArrayList(Arrays.asList("uno","dos","tres"));
		unbounded(lista);
		
		
/*			UPPER BOUNDED				*/	
		List<Integer> listaEnteros = new ArrayList<>();
		listaEnteros.add(new Integer(15));
		listaEnteros.add(new Integer(12));
		listaEnteros.add(new Integer(11));
		System.out.println(total(listaEnteros));
		
/*			UPPER BOUNDED	(Consideraciones)			*/
		List<? extends Number> birds = new ArrayList<Integer>();
//		birds.add(new Integer(14));			/*Esta declaracion no se puede hacer porque 
		/*se puede violar la asignacion ya que Number es extendida por diferentes clases
		 * asi como Number extends Number, Integer extends Number, Double extends Number
		 * por lo que al definir "new ArrayList<Integer>();" Java se asegura que 
		 * no se pueda agregar un List<Double>*/
		
/*			LOWER BOUNDED	(Ver clase LowerBounded)			*/
		
	}

}

class Bird{
	
}

class Sparrow extends Bird{
	
}