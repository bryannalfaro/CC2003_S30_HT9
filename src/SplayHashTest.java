import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Clase donde se realizan las pruebas para insercion
 * y busqueda de splay tree y hashmap
 * @author Bryann Alfaro
 * @author Diego de Jesus
 * @since April 26, 2020
 *
 */
public class SplayHashTest {
	
	MapInterface<String, String> mapaPrueba= new SplayTree<String,String>();
	MapInterface<String, String> mapaPrueba2= new HashMapImp<String,String>();
	
	/**
	 * Prueba de insercion para SplayTree
	 */
	@Test
	public void insertarSplaytest() {
		
		
		mapaPrueba.put("Horse", "Caballo");
		
	}
	/**
	 * Prueba de busqueda para SplayTree
	 */
	@Test
	public void verificadortest() {
		mapaPrueba.put("Horse", "Caballo");
		String palabra = "Horse";
		String mapa= mapaPrueba.get(palabra);
		assertEquals("Caballo",mapa);
	}
	
	/**
	 * Prueba de insercion para HashMap
	 */
	@Test
	public void insertarHashtest() {
		
		
		mapaPrueba2.put("Horse", "Caballo");
		
	}
	
	/**
	 * Prueba de busqueda para HashMap
	 */
	@Test
	public void verificadorHashtest() {
		mapaPrueba2.put("Horse", "Caballo");
		String palabra = "Horse";
		String mapa= mapaPrueba2.get(palabra);
		assertEquals("Caballo",mapa);
	}

}
