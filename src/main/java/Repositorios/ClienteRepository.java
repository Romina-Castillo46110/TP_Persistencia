package Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}


