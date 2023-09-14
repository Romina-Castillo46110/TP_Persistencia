package Repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import entidades.EntidadBase;



@NoRepositoryBean
public interface EntidadBaseRepository<E extends EntidadBase, ID extends Serializable> extends JpaRepository<E,ID> {

}
