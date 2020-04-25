import java.util.HashMap;

public class HashMapImp<K,V> implements Map<K,V> {
	
	HashMap<K,V> mapa = new HashMap<K,V>();
	
	public void put (K key, V value) {
		mapa.put(key, value);
	}
	
	public V get(K key) {
		if(mapa.containsKey(key)) return mapa.get(key);
        else return null ;
	}
}
