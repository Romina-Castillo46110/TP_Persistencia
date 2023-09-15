package Repositorios;

import entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
