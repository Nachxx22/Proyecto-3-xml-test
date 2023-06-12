package com.example.mydatabasece_backend.Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Clase que proporciona funcionalidades para realizar compresión y descompresión de texto utilizando el algoritmo de Huffman.
 */
public class HuffmanCompression {

    /**
     * Construye el árbol de Huffman utilizando un mapa de frecuencias de caracteres.
     *
     * @param frequencyMap El mapa de frecuencias de caracteres.
     * @return El nodo raíz del árbol de Huffman construido.
     */
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }

        return pq.poll();
    }

    /**
     * Comprime un texto original utilizando el árbol de Huffman especificado.
     *
     * @param originalText El texto original a comprimir.
     * @param root         El nodo raíz del árbol de Huffman.
     * @return El texto comprimido.
     */
    public static String compress(String originalText, HuffmanNode root) {
        Map<Character, String> encodingMap = buildEncodingMap(root);
        StringBuilder compressed = new StringBuilder();

        for (char c : originalText.toCharArray()) {
            compressed.append(encodingMap.get(c));
        }

        return compressed.toString();
    }

    /**
     * Descomprime un texto comprimido utilizando el árbol de Huffman especificado.
     *
     * @param compressed El texto comprimido.
     * @param root       El nodo raíz del árbol de Huffman.
     * @return El texto descomprimido.
     */
    public static String decompress(String compressed, HuffmanNode root) {
        StringBuilder decompressed = new StringBuilder();
        HuffmanNode current = root;

        for (int i = 0; i < compressed.length(); i++) {
            char bit = compressed.charAt(i);
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            }

            if (current.isLeaf()) {
                decompressed.append(current.character);
                current = root;
            }
        }

        return decompressed.toString();
    }

    private static Map<Character, String> buildEncodingMap(HuffmanNode root) {
        Map<Character, String> encodingMap = new HashMap<>();
        buildEncodingMapRecursive(root, "", encodingMap);
        return encodingMap;
    }

    private static void buildEncodingMapRecursive(HuffmanNode node, String path, Map<Character, String> encodingMap) {
        if (node.isLeaf()) {
            encodingMap.put(node.character, path);
        } else {
            buildEncodingMapRecursive(node.left, path + "0", encodingMap);
            buildEncodingMapRecursive(node.right, path + "1", encodingMap);
        }
    }

    /**
     * Calcula el mapa de frecuencias de caracteres para un texto dado.
     *
     * @param originalText El texto original.
     * @return El mapa de frecuencias de caracteres.
     */
    public static Map<Character, Integer> calculateFrequencyMap(String originalText) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : originalText.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
