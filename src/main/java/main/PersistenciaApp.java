package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import Repositorios.ClienteRepository;
import entidades.Cliente;
import entidades.Domicilio;


public class PersistenciaApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAPPPU");
		EntityManager em = emf.createEntityManager();
		SpringApplication.run(PersistenciaApp.class, args);
		
		/*try {
			em.getTransaction().begin();
			Cliente cliente = new Cliente("Romina","Castillo","2616968493","romina.castillo195@gmail.com", null, null);
			em.persist(cliente);
			em.flush();
			em.getTransaction().commit();
		}catch (Exception E) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		*/
		
		CommandLineRunner init(ClienteRepository clienteRepository) {
			return args ->  {
				System.out.println("Estoy funcionando");
				Cliente cliente = new Cliente();
				cliente.setNombre("Juan");
				cliente.setApellido("Perez");
				cliente.setTelefono("2605868945");
				cliente.setEmail("romina@gmail.com");
				
				clienteRepository.save(cliente);
				
				Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
				if (clienteRecuperado != null) {
					System.out.println("Nombre: " + clienteRecuperado.getNombre());
					System.out.println("Apellido: " + clienteRecuperado.getApellido());
					System.out.println("Telefono " + clienteRecuperado.getTelefono());
					System.out.println("Email: " + clienteRecuperado.getEmail());
					
					
				}
			};
		}
		
	}

}
