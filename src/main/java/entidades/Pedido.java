package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;

import Enumeraciones.Estado;
import Enumeraciones.TipoEnvio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Pedido")
public class Pedido extends EntidadBase {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Fecha")
    private Date fecha;
    @Column(name = "Total")
    private double total;
    @Column(name = "Estado")
    private Estado estado;
    private TipoEnvio tipoEnvio;
    
    //relacion pedido con detallepedido: OneToMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido_fk")
    @Builder.Default
    private List<DetallePedido> detalle = new ArrayList<>();
    
    public List<DetallePedido> getDetallePedido(){
    	return detalle;
    }
    public void agregarDetallePedido(DetallePedido det){
    	detalle.add(det);
    }
    
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

	
}
