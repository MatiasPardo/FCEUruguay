package org.facturacionUruguay.model;

import java.math.BigDecimal;

public class Detalle {

	private BigDecimal cantidad;
		
	private BigDecimal precioUnitario;
	
	private int indicadorFacturacion;
	
	private String nombreItem;
	
	private int numeroLinea;
	
	private String unidadMedida;
		
	private String porcentajeDescuento;
	
	private BigDecimal montoDescuento;

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getIndicadorFacturacion() {
		return indicadorFacturacion;
	}

	public void setIndicadorFacturacion(int indicadorFacturacion) {
		this.indicadorFacturacion = indicadorFacturacion;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public int getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public BigDecimal getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(BigDecimal montoDescuento) {
		this.montoDescuento = montoDescuento;
	}

	public String getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(String porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public void acumular(Detalle item) {
		this.setCantidad(this.getCantidad().add(item.getCantidad()));
		this.setMontoDescuento(this.getMontoDescuento().add(item.getMontoDescuento()));
		
	}

	public boolean merge(Detalle item) {
		if(this.getPrecioUnitario().compareTo(item.getPrecioUnitario()) == 0 && 
				this.getIndicadorFacturacion() == item.getIndicadorFacturacion() && 
				this.getUnidadMedida().equals(item.getUnidadMedida())){
			this.acumular(item);
			return true;
		}else{
			return false;
		}
	}
	
}
