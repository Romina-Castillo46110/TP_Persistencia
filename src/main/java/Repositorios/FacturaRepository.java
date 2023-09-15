package Repositorios;

import entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {

}
