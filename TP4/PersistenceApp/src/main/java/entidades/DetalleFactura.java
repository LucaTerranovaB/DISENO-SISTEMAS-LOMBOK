package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Audited

public class DetalleFactura  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidad")
	private int cantidad; 
	
	@Column(name = "subtotal")
	private int subtotal;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_articulo")
	private Articulo articulo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "detelle_fk_factura")
	
	private Factura factura;
	

}



