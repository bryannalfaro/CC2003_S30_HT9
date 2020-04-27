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

    private Node raiz;   //Raiz del tree
    
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Metodo que retorna el valor asociado a la llave.
     */
    public V get(K llave) {
        raiz = splay(raiz, llave);
        int cmp = llave.compareTo((K) raiz.key);
        if (cmp == 0) return (V) raiz.value;
        else          return null;
    }    

   /**
    * Insertar elementos en el SplayTree
    */
    public void put(K llave, V valor) {
        // Llave para la raiz
        if (raiz == null) {
            raiz = new Node(llave, valor);
            return;
        }
        
        raiz = splay(raiz, llave);

        int comparar = llave.compareTo((K) raiz.key);
        
        // Inserta un nuevo nodo
        if (comparar < 0) {
            Node nodo = new Node(llave, valor);
            nodo.left = raiz.left;
            nodo.right = raiz;
            raiz.left = null;
            raiz = nodo;
        }

        // Inserta un nuevo nodo en la raiz
        else if (comparar > 0) {
            Node nodo = new Node(llave, valor);
            nodo.right = raiz.right;
            nodo.left = raiz;
            raiz.right = null;
            raiz = nodo;
        }

        //Reemplaza el valor
        else {
            raiz.value = valor;
        }

    }
    
    /**
     * Se realiza la eliminacion de nodos en el arbol
     * @param llave
     */
    public void remove(K llave) {
        if (raiz == null) return; // empty tree
        
        raiz = splay(raiz, llave);

        int comparar = llave.compareTo((K) raiz.key);
        
        if (comparar == 0) {
            if (raiz.left == null) {
                raiz = raiz.right;
            } 
            else {
                Node x = raiz.right;
                raiz = raiz.left;
                splay(raiz, llave);
                raiz.right = x;
            }
        }
    }
    
    private Node splay(Node hNode, K key) {
        if (hNode == null) return null;

        int cmp1 = key.compareTo((K) hNode.key);

        if (cmp1 < 0) {
            if (hNode.left == null) {
                return hNode;
            }
            int cmp2 = key.compareTo((K) hNode.left.key);
            if (cmp2 < 0) {
                hNode.left.left = splay(hNode.left.left, key);
                hNode = rotateRight(hNode);
            }
            else if (cmp2 > 0) {
                hNode.left.right = splay(hNode.left.right, key);
                if (hNode.left.right != null)
                    hNode.left = rotateLeft(hNode.left);
            }
            
            if (hNode.left == null) return hNode;
            else                return rotateRight(hNode);
        }

        else if (cmp1 > 0) { 
            
            if (hNode.right == null) {
                return hNode;
            }

            int cmp2 = key.compareTo((K) hNode.right.key);
            if (cmp2 < 0) {
                hNode.right.left  = splay(hNode.right.left, key);
                if (hNode.right.left != null)
                    hNode.right = rotateRight(hNode.right);
            }
            else if (cmp2 > 0) {
                hNode.right.right = splay(hNode.right.right, key);
                hNode = rotateLeft(hNode);
            }
            
            if (hNode.right == null) return hNode;
            else                 return rotateLeft(hNode);
        }

        else return hNode;
    }

    /**
     * Tamano de arbol
     * @return height
     */
    public int height() { return height(raiz); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    
    public int size() {
        return size(raiz);
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
