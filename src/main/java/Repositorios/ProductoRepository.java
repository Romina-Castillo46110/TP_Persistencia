package Repositorios;

import entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

}
