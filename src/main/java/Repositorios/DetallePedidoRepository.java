package Repositorios;

import entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.DetallePedido;
@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {

}
