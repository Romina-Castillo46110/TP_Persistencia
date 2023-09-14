package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import Enumeraciones.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Producto")

public class Producto extends EntidadBase {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "tiempoEstimadoCocina")
    private int tiempoEstimadoCocina;
    @Column(name = "Denominacion")
    private String denominacion;
    @Column(name = "precioVenta")
    private double precioVenta;
    @Column(name = "precioCompra")
    private double precioCompra;
    @Column(name = "StockActual")
    private int stockActual;
    @Column(name = "StockMinimo")
    private int stockMinimo;
    @Column(name = "UnidadMendida")
    private String unidadMedida;
    @Column(name = "Receta")
    private String receta;
    private Tipo tipo;

    public int getTiempoEstimadoCocina() {
        return tiempoEstimadoCocina;
    }

    public void setTiempoEstimadoCocina(int tiempoEstimadoCocina) {
        this.tiempoEstimadoCocina = tiempoEstimadoCocina;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
}
