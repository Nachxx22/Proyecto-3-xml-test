package com.example.mydatabasece_backend.Entity;

import com.example.mydatabasece_backend.Huffman.HuffmanCompression;
import com.example.mydatabasece_backend.Huffman.HuffmanNode;
import jakarta.persistence.*;

import java.util.Map;

/**
 * Clase que representa un usuario en el sistema.
 * Anotada con las anotaciones JPA para su mapeo con la base de datos.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    /**
     * Constructor vacío requerido por JPA.
     */
    public User() {
        // Constructor vacío requerido por JPA
    }

    /**
     * Actualiza la contraseña del usuario y realiza la compresión de la nueva contraseña.
     *
     * @param newPassword La nueva contraseña del usuario.
     * @return La nueva contraseña actualizada.
     */
    public String updatePassword(String newPassword) {

        // Calcular la frecuencia de los caracteres en el texto original
        Map<Character, Integer> frequencyMap = HuffmanCompression.calculateFrequencyMap(password);

        // Construir el árbol de Huffman utilizando la frecuencia de los caracteres
        HuffmanNode root = HuffmanCompression.buildHuffmanTree(frequencyMap);

        // Realizar la compresión
        String compressedString = HuffmanCompression.compress(password, root);
        System.out.println("Compressed String: " + compressedString);


        return newPassword;
    }

    /**
     * Constructor de la clase User.
     *
     * @param username El nombre de usuario.
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El ID del usuario.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username El nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Comprime la contraseña del usuario utilizando el algoritmo de Huffman.
     */
    public void compressPassword() {
        Map<Character, Integer> frequencyMap = HuffmanCompression.calculateFrequencyMap(password);
        HuffmanNode root = HuffmanCompression.buildHuffmanTree(frequencyMap);
        String compressedPassword = HuffmanCompression.compress(password, root);
        password = compressedPassword;
    }
}
