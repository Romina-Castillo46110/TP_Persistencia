package Repositorios;


import org.springframework.stereotype.Repository;

import entidades.Cliente;

@Repository
public interface ClienteRepository extends EntidadBaseRepository<Cliente,Long> {

}


