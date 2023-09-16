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
@Table(name = "Rubro")
public class Rubro extends EntidadBase {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Denominacion")
	private String denominacion;
	
    //relacion rubro con productos: OneToMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Rubro_fk")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public Rubro(String denominacion,List<Producto> productos) {
        this.denominacion = denominacion;
        this.productos = productos;
    }
    public void mostrarProductos() {
        System.out.println("Los productos de este rubro son: ");
        for (Producto producto : productos) {
            System.out.println("Denominacion: " + producto.getDenominacion() + ", Receta: " + producto.getReceta()
                    + ", Unidad Medida: " + producto.getUnidadMedida() + ", Precio Compra: " + producto.getPrecioCompra()
                    + ", Precio Venta: " + producto.getPrecioVenta() + ", Stock Actual: " + producto.getStockActual()
            + ", Stock Minimo: " + producto.getStockMinimo() + ", Tiempo Estimado Cocina: " + producto.getTiempoEstimadoCocina()
            + ", Tipo: " + producto.getTipo());
        }
    }
    
    public void agregarProducto(Producto prod) {
    	productos.add(prod);
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
