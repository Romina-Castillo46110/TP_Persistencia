package entidades;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "TipoEnvio")
public class TipoEnvio extends EntidadBase {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
