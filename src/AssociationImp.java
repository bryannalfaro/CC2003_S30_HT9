/**
 * @author Bryann Alfaro 
 * @author Diego de Jesus
 * @since April 26, 2020
 * 
 * Clase donde se encuentra el Association
 **/
public class AssociationImp <K,V> {
		
		//Variables
		private K llave;
		private V valor;
		
		//Constructor
		public AssociationImp(K key, V value) {
			this.llave=key;
			this.valor=value;
		}
		//Getters y setters
		public K getKey() {
			return this.llave;
		}
		
		public V getValue() {
			return this.valor;
		}
		
		public void setKey(K key) {
			this.llave=key;
		}
	}

