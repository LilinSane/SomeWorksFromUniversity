package com.example.blps_1.repository;

import com.example.blps_1.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c JOIN c.cart p WHERE p.id = :productId")
    Optional<List<Client>> findByCartId(Long productId);

    Optional<Client> findClientByMail(String mail);

    boolean existsByMail(String mail);
}
