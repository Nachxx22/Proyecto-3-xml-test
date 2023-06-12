package com.example.mydatabasece_backend.Huffman;


/**
 * Clase que representa un nodo en el árbol de Huffman.
 * Implementa la interfaz Comparable para permitir la comparación y el ordenamiento de los nodos.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    /**
     * Constructor de la clase HuffmanNode para un nodo hoja.
     *
     * @param character El carácter correspondiente al nodo hoja.
     * @param frequency La frecuencia del carácter.
     */
    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
    /**
     * Constructor de la clase HuffmanNode para un nodo interno.
     *
     * @param character El carácter correspondiente al nodo interno (se establece como '\0').
     * @param frequency La frecuencia acumulada de los nodos hijos.
     * @param left      El nodo hijo izquierdo.
     * @param right     El nodo hijo derecho.
     */

    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    /**
     * Verifica si el nodo es una hoja (no tiene hijos).
     *
     * @return true si el nodo es una hoja, false de lo contrario.
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }

    /**
     * Compara el nodo actual con otro nodo de acuerdo a su frecuencia.
     * Se utiliza para ordenar los nodos en una PriorityQueue.
     *
     * @param other El otro nodo a comparar.
     * @return Un valor negativo si la frecuencia del nodo actual es menor que la del otro nodo,
     *         un valor positivo si es mayor, o cero si son iguales.
     */
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}
