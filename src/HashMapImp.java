import java.util.HashMap;

/**
 * @author Bryann Alfaro 
 * @author Diego de Jesus
 * @since April 26, 2020
 * 
 * Clase donde se encuentra la implementacion de HashMap
 **/
public class HashMapImp<K,V> implements MapInterface<K,V> {
	
	HashMap<K,V> mapa = new HashMap<K,V>();
	
	public void put (K key, V value) {
		mapa.put(key, value);
	}
	
	public V get(K key) {
		if(mapa.containsKey(key)) return mapa.get(key);
        else return null ;
	}
}
