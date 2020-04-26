/**
 * @author Bryann Alfaro 
 * @author Diego de Jesus
 * @since April 26, 2020
 * 
 * Clase donde se encuentra el nodo para el  manejo del splay
 * 
 * El codigo utilizado fue extraido de: https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 **/
class Node<K,V> {
	    public K key;            // key
	    public V value;        // valor asociado a la llave
        public Node left, right;   // nodos izquierdo y derecho

        public Node(K key, V value) {
            this.key   = key;
            this.value = value;
        }
    }