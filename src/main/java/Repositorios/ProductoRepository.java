package Repositorios;

import org.springframework.stereotype.Repository;

import entidades.Producto;

@Repository
public interface ProductoRepository extends EntidadBaseRepository<Producto,Long> {

}
