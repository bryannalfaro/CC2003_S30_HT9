
public class FactoryTree<K extends Comparable<K>,V> {
	
	public MapInterface<K,V> getFactoryMap(int opcion){
		if(opcion==1) {
			return new HashMapImp<K, V>();
		}else {
			return new SplayTree<K, V>();
		}
	}

}
