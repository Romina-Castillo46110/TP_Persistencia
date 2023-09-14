package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Enumeraciones.FormaPago;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Factura")
public class Factura extends EntidadBase {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Numero")
	private int numero;
    @Column(name = "Fecha")
    private Date fecha;
    @Column(name = "Descuento")
    private double descuento;
    private FormaPago formaPago;
    @Column(name = "Total")
    private int total;
    
    @OneToOne
    @JoinColumn(name = "fk_pedido", unique = true)
    private Pedido pedido;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
