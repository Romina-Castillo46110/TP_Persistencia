package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Enumeraciones.Estado;
import Enumeraciones.FormaPago;
import Enumeraciones.Tipo;
import Enumeraciones.TipoEnvio;
import Repositorios.RubroRepository;
import entidades.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class PersistenciaApp {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaApp.class, args);
		System.out.println("Estoy Funcionando");
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println("------------Estoy Funcionando------------");

			Cliente cliente = new Cliente();

			cliente.setNombre("Emma");
			cliente.setApellido("Gonzalez");
			cliente.setTelefono("123456789");
			cliente.setEmail("emmagonzalez@gmail.com");

			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(5);
			detallePedido.setSubtotal(100);

			Domicilio domicilio = new Domicilio();

			domicilio.setCalle("Av. España");
			domicilio.setNumero("2550");
			domicilio.setLocalidad("Mendoza");

			Factura factura = new Factura();

			factura.setNumero(25);
			factura.setDescuento(0);
			factura.setFormaPago(FormaPago.Efectivo);
			factura.setTotal(1250);

			Pedido pedido = new Pedido();
			//pedido.setFecha();
			pedido.setEstado(Estado.Preparacion);
			pedido.setTipoEnvio(TipoEnvio.Delivery);
			pedido.setTotal(2150);

			Producto producto = new Producto();
			producto.setTipo(Tipo.Manufacturado);
			producto.setTiempoEstimadoCocina(45);
			producto.setDenominacion("Pure");
			producto.setPrecioVenta(350);
			producto.setPrecioCompra(200);
			producto.setStockActual(50);
			producto.setStockMinimo(5);
			producto.setUnidadMedida("kg");
			producto.setReceta("1.Pelar y picar papas" + "2.Colocar agua en olla y dejar que hierva" + "3.Colocar las papas en la olla con sal" + "4.Cuando esten blandas retirar" + "5.Pisar sin dejar grumos, agregar condimento a gusto" + "6.Servir en el plato");

			Rubro rubro = new Rubro();
			rubro.setDenominacion("Verdura");

			// Guardar el objeto Cliente en la base de datos

			cliente.agregarDomicilio(domicilio);
			cliente.agregarPedido(pedido);

			pedido.agregarDetallePedido(detallePedido);
			pedido.setFactura(factura);

			detallePedido.setProducto(producto);

			rubro.agregarProducto(producto);

			clienteRepository.save(cliente);
			rubroRepository.save(rubro);

		};
	}
}


