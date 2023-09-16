package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "DetallePedido")
public class DetallePedido extends EntidadBase {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Subtotal")
    private double subtotal;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_producto")
    private Producto producto;

    public DetallePedido(int cant,double subt, Producto product){
        this.cantidad = cant;
        this.subtotal = subt;
        this.producto = product;


    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}