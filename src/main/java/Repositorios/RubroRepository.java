package Repositorios;

import entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entidades.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
}
