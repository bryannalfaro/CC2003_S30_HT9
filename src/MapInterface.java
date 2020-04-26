/**
 * Clase donde se encuentra la interface de Map
 * 
 * @author Bryann Alfaro
 * @author Diego de Jesus
 * @since April 26, 2020
 * */
public interface MapInterface<K, V> {
	
	public void put (K key, V value);

    public V get (K key);
    
    public int size ();

}
