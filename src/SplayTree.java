/**
 * @author Bryann Alfaro 
 * @author Diego de Jesus
 * @since April 26, 2020
 * 
 * Clase donde se encuentra el Splay Tree
 * 
 * El codigo utilizado fue extraido de: https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
 **/


public class SplayTree<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private Node root;   //Raiz del tree
    
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Metodo que retorna el valor asociado a la llave.
     */
    public V get(K key) {
        root = splay(root, key);
        int cmp = key.compareTo((K) root.key);
        if (cmp == 0) return (V) root.value;
        else          return null;
    }    

   /**
    * Insertar elementos en el SplayTree
    */
    public void put(K key, V value) {
        // Llave para la raiz
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        
        root = splay(root, key);

        int cmp = key.compareTo((K) root.key);
        
        // Inserta un nuevo nodo
        if (cmp < 0) {
            Node n = new Node(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Inserta un nuevo nodo en la raiz
        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        //Reemplaza el valor
        else {
            root.value = value;
        }

    }
    
    /**
     * Se realiza la eliminacion de nodos en el arbol
     * @param key
     */
    public void remove(K key) {
        if (root == null) return; // empty tree
        
        root = splay(root, key);

        int cmp = key.compareTo((K) root.key);
        
        if (cmp == 0) {
            if (root.left == null) {
                root = root.right;
            } 
            else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }
    }
    
    private Node splay(Node h, K key) {
        if (h == null) return null;

        int cmp1 = key.compareTo((K) h.key);

        if (cmp1 < 0) {
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo((K) h.left.key);
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }
            
            if (h.left == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            
            if (h.right == null) {
                return h;
            }

            int cmp2 = key.compareTo((K) h.right.key);
            if (cmp2 < 0) {
                h.right.left  = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = rotateRight(h.right);
            }
            else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            
            if (h.right == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }

    /**
     * Tamano de arbol
     * @return height
     */
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    
    public int size() {
        return size(root);
    }
    
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    /**
     * Se realiza la rotacion hacia la derecha
     * @param h
     * @return x
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    /**
     * Se realiza la rotacion hacia la izquierda
     * */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }
}
