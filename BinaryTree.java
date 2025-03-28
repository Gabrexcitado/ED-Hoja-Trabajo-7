/**
 * Arbol binario de busqueda adaptado de GeeksForGeeks.com
 */
public class BinaryTree<K extends Comparable<K>, V> {
    
    /**
     * Clase privada Nodo, implementando la estructura <K,V>
     */
    private class Node {
        K key;
        V value;
        Node left, right;

        /***
         * Constructor del nodo
         * @param key
         * @param value
         */
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    /**
     * Metodo para agregar un dato al arbol
     * @param root raiz del arbol
     * @param key clave del nodo
     * @param value valor del nodo
     * @return nodos para la recursividad
     */
    public Node insert(Node root, K key, V value) {
        //si esta vacio
        if (root == null) {
            return new Node(key, value);
        }

        //Si se repite la clave
        if (key.equals(root.key)) { // Se usa equals() en lugar de ==
            root.value = value;
            return root;
        }

        //recorrimiento
        if (key.compareTo(root.key) < 0) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }

        return root;
    }

    /**
     * Metodo para la busqueda de datos en el arbol
     * @param root raiz del arbol
     * @param key clave a comparar
     * @return raiz buscada
     */
    public Node search(Node root, K key) {
        //nulo o encontrada
        if (root == null || key.equals(root.key)) { // Se usa equals() en lugar de ==
            return root;
        }

        //recorrimiento
        if (key.compareTo(root.key) < 0) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    /**
     * Metodo para imprimir el arbol en inOrder
     * @param root raiz del arbol
     */
    public void listInOrder(Node root) {
        if (root == null) {
            return;
        }

        //izquierda, raiz, derecha
        listInOrder(root.left);
        System.out.print(root.key + " : " + root.value + "\n");
        listInOrder(root.right);
    }  
}