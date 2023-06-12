package com.example.mydatabasece_backend.Repo;

import com.example.mydatabasece_backend.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que define las operaciones de acceso a la base de datos para la entidad User.
 * Extiende la interfaz CrudRepository proporcionada por Spring Data JPA.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * Busca un usuario por nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return El objeto User correspondiente al nombre de usuario especificado, o null si no se encuentra.
     */
    User findByUsername(String username);
}