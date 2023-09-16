package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "Cliente")

public class Cliente extends EntidadBase {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Email")
    private String email;

    public Cliente(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    
    //relacion cliente con pedido: OneToMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_fk")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido Ped) {
    	pedidos.add(Ped);
    }
    //relacion cliente con domicilio: OneToMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Cliente_fk")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();


    public void agregarDomicilio(Domicilio Dom) {
    	domicilios.add(Dom);
    }
    public void mostrarDomicilios() {
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero());
        }
    }

    public Cliente(String nom, String apell, String tel, String mail, List<Pedido> pedidos,List<Domicilio> domicilios) {
        this.nombre = nom;
        this.apellido = apell;
        this.telefono = tel;
        this.email = mail;
        this.domicilios = domicilios;
        this.pedidos = pedidos;
    }
    public void mostrarPedidos() {
        System.out.println("Pedidos de " + nombre + " " + apellido + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() + ", Total: " + pedido.getTotal());
            int counter = 0;
            for (DetallePedido detalle: pedido.getDetallePedido()){
                counter += 1;
                System.out.println("Producto "+counter+": "+detalle.getProducto().getDenominacion()+"  cantidad: "+detalle.getCantidad()+"  subtotal: "+detalle.getSubtotal());
            }
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}