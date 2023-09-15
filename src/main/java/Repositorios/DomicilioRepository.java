package Repositorios;

import entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
