
public class FactoryTree {
	
	public static <K extends Comparable<K>,V> Map<K,V> getFactoryMap(int opcion){
		if(opcion==1) {
			return new HashMapImp();
		}else {
			return new SplayTree();
		}
	}

}
