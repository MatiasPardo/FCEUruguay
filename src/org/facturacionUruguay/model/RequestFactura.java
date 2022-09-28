package org.facturacionUruguay.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestFactura {

	private int tipo;
	
	private boolean contingencia;
	
	private String serie;
	
	private String tipoMoneda;
	
	private String montosBrutos;
	
	private int tipoTraslado;
	
	private int formaPago;
	
	//formato "20211026" AAAAMMDD
	private String fechaEmision;
	
	private Receptor receptor;
	
	private List<Detalle> detalle;
	
	private List<DescuentosRecargos> descuentosRecargos;
	
	private List<Referencias> referencias;
	
	private Adenda adenda;
	
	private Totales totales;

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isContingencia() {
		return contingencia;
	}

	public void setContingencia(boolean contingencia) {
		this.contingencia = contingencia;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getMontoBrutos() {
		return montosBrutos;
	}

	public void setMontosBrutos(String montosBrutos) {
		this.montosBrutos = montosBrutos;
	}

	public int getTipoTraslado() {
		return tipoTraslado;
	}

	public void setTipoTraslado(int tipoTraslado) {
		this.tipoTraslado = tipoTraslado;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public List<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}

	public List<DescuentosRecargos> getDescuentosRecargos() {
		return descuentosRecargos;
	}

	public void setDescuentosRecargos(List<DescuentosRecargos> descuentosRecargos) {
		this.descuentosRecargos = descuentosRecargos;
	}

	public List<Referencias> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<Referencias> referencias) {
		this.referencias = referencias;
	}

	public Adenda getAdenda() {
		return adenda;
	}

	public void setAdenda(Adenda adenda) {
		this.adenda = adenda;
	}

	public int getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(int formaPago) {
		this.formaPago = formaPago;
	}

	public Totales getTotales() {
		return totales;
	}

	public void setTotales(Totales totales) {
		this.totales = totales;
	}

	public void recalcularItems() {
		if(this.getDetalle() != null){
			Map<String, List<Detalle>> mapDetalles = new HashMap<String,List<Detalle>>();
			for(Detalle item: this.getDetalle()){
				if(mapDetalles.containsKey(item.getNombreItem())){
					Boolean merger = Boolean.FALSE;
					for(Detalle itDetailMerger: mapDetalles.get(item.getNombreItem())){
						if(itDetailMerger.merge(item)){
							merger = Boolean.TRUE;
							break;
						}
					}
					if(!merger){
						mapDetalles.get(item.getNombreItem()).add(item);
					}
				}else{
					List<Detalle> detalles = new LinkedList<Detalle>();
					detalles.add(item);
					mapDetalles.put(item.getNombreItem(), detalles);
				}
			}
			List<Detalle> detallesConsolidado = new LinkedList<Detalle>(); 
			mapDetalles.forEach((key,value)->{
				detallesConsolidado.addAll(value);
			});
			
			this.setDetalle(detallesConsolidado);
			initNumLinea();
		}
		
	}

	private void initNumLinea() {
		int count = 1;
		for(Detalle item: this.getDetalle()){
			item.setNumeroLinea(count);
			count++;
		}
	}
	
	
}
