package com.example.clientes.model;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client_detalle")
public class FacturasDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetalle;

	@Column(name = "id")
	private int id;

	@Column(name = "concepto")
	private String concepto;

	@Column(name = "unidades")
	private int unidades;
	
	@Column(name = "importe")
	private int importe;
	
	@Column(name = "pagado")
	private boolean pagado;
	

	@ManyToOne
	@JoinColumn(name="idTutorial", nullable=false)
	private Facturas facturas;

	public FacturasDetalle() {

	}

	

	public FacturasDetalle(long idDetalle, int id, String concepto, int unidades, int importe, boolean pagado,
			Facturas facturas) {
		super();
		this.idDetalle = idDetalle;
		this.id = id;
		this.concepto = concepto;
		this.unidades = unidades;
		this.importe = importe;
		this.pagado = pagado;
		this.facturas = facturas;
	}


	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturasDetalle other = (FacturasDetalle) obj;
		return Objects.equals(concepto, other.concepto) && Objects.equals(facturas, other.facturas) && id == other.id
				&& idDetalle == other.idDetalle && importe == other.importe && pagado == other.pagado
				&& unidades == other.unidades;
	}



	@Override
	public int hashCode() {
		return Objects.hash(concepto, facturas, id, idDetalle, importe, pagado, unidades);
	}


	

	@Override
	public String toString() {
		return "FacturasDetalle [idDetalle=" + idDetalle + ", id=" + id + ", concepto=" + concepto + ", unidades="
				+ unidades + ", importe=" + importe + ", pagado=" + pagado + ", facturas=" + facturas + "]";
	}



	public long getIdDetalle() {
		return idDetalle;
	}



	public void setIdDetalle(long idDetalle) {
		this.idDetalle = idDetalle;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getConcepto() {
		return concepto;
	}



	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}



	public int getUnidades() {
		return unidades;
	}



	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}



	public int getImporte() {
		return importe;
	}



	public void setImporte(int importe) {
		this.importe = importe;
	}



	public boolean isPagado() {
		return pagado;
	}



	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}



	public Facturas getFacturas() {
		return facturas;
	}



	public void setFacturas(Facturas facturas) {
		this.facturas = facturas;
	}



}
