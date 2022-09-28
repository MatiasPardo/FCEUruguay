package org.facturacionUruguay.model;

public class Cae {

	private String id;
	
	private int numeroDesde;
	
	private int numeroHasta;
	
	private String fechaVencimiento;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumeroDesde() {
		return numeroDesde;
	}

	public void setNumeroDesde(int numeroDesde) {
		this.numeroDesde = numeroDesde;
	}

	public int getNumeroHasta() {
		return numeroHasta;
	}

	public void setNumeroHasta(int numeroHasta) {
		this.numeroHasta = numeroHasta;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
}
