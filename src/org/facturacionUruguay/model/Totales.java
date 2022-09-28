package org.facturacionUruguay.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Totales {

	private int cantidadLineasDetalle;
	
	private BigDecimal ivaTasaBasica;
	
    private BigDecimal ivaTasaMinima;
    
    private BigDecimal montoExportacionesAsimiladas;
    
    private BigDecimal montoImpuestoPercibido;
    
    private BigDecimal montoIVAEnSuspenso;
    
    private BigDecimal montoIVAOtraTasa;
    
    private BigDecimal montoIVATasaBasica;
    
    private BigDecimal montoIVATasaMinima;
    
    private BigDecimal netoIVAOtraTasa;
    
    private BigDecimal netoIVATasaBasica;
    
    private BigDecimal netoIVATasaMinima;
    
    private BigDecimal montoNoGravado;
    
    private BigDecimal montoAPagar;
    
    private BigDecimal montoTotal;
    
    private BigDecimal montoCreditosFiscales;
    
    private BigDecimal montoRetenido;
    
    private BigDecimal montoNoFacturable;
    
    private BigDecimal tipoCambio;
    
    private String tipoMoneda;

    public void aplicarRedondeo(int redondeo, RoundingMode tipoRedondeo){
		this.setMontoAPagar(this.redondearSiCorresponde(this.getMontoAPagar(),redondeo, tipoRedondeo));
		this.setMontoTotal(this.redondearSiCorresponde(this.getMontoTotal(),redondeo, tipoRedondeo));
		this.setMontoIVAOtraTasa(this.redondearSiCorresponde(this.getMontoIVAOtraTasa(),redondeo, tipoRedondeo));
		this.setMontoIVATasaBasica(this.redondearSiCorresponde(this.getMontoIVATasaBasica(), redondeo, tipoRedondeo));
		this.setMontoIVATasaMinima(this.redondearSiCorresponde(this.getMontoIVATasaMinima(), redondeo, tipoRedondeo));
		this.setNetoIVAOtraTasa(this.redondearSiCorresponde(this.getNetoIVAOtraTasa(), redondeo, tipoRedondeo));
    	this.setNetoIVATasaBasica(this.redondearSiCorresponde(this.getNetoIVATasaBasica(), redondeo, tipoRedondeo));
    	this.setNetoIVATasaMinima(this.redondearSiCorresponde(this.getNetoIVATasaMinima(), redondeo, tipoRedondeo));
    	this.setMontoNoGravado(this.redondearSiCorresponde(this.getMontoNoGravado(), redondeo, tipoRedondeo));
    }
    
    public BigDecimal redondearSiCorresponde(BigDecimal monto, int redondeo, RoundingMode tipoRedondeo){
    	if(monto.compareTo(BigDecimal.ZERO) != 0){
    		return monto.setScale(redondeo, tipoRedondeo);
    	}else{
    		return monto;
    	}
    }
	public int getCantidadLineasDetalle() {
		return cantidadLineasDetalle;
	}

	public void setCantidadLineasDetalle(int cantidadLineasDetalle) {
		this.cantidadLineasDetalle = cantidadLineasDetalle;
	}

	public BigDecimal getIvaTasaBasica() {
		return ivaTasaBasica;
	}

	public void setIvaTasaBasica(BigDecimal ivaTasaBasica) {
		this.ivaTasaBasica = ivaTasaBasica;
	}

	public BigDecimal getIvaTasaMinima() {
		return ivaTasaMinima;
	}

	public void setIvaTasaMinima(BigDecimal ivaTasaMinima) {
		this.ivaTasaMinima = ivaTasaMinima;
	}

	public BigDecimal getMontoExportacionesAsimiladas() {
		return montoExportacionesAsimiladas != null ? montoExportacionesAsimiladas: BigDecimal.ZERO;
	}

	public void setMontoExportacionesAsimiladas(BigDecimal montoExportacionesAsimiladas) {
		this.montoExportacionesAsimiladas = montoExportacionesAsimiladas;
	}

	public BigDecimal getMontoImpuestoPercibido() {
		return montoImpuestoPercibido != null  ? montoImpuestoPercibido: BigDecimal.ZERO;
	}

	public void setMontoImpuestoPercibido(BigDecimal montoImpuestoPercibido) {
		this.montoImpuestoPercibido = montoImpuestoPercibido;
	}

	public BigDecimal getMontoIVAEnSuspenso() {
		return montoIVAEnSuspenso != null  ? montoIVAEnSuspenso: BigDecimal.ZERO;
	}

	public void setMontoIVAEnSuspenso(BigDecimal montoIVAEnSuspenso) {
		this.montoIVAEnSuspenso = montoIVAEnSuspenso;
	}

	public BigDecimal getMontoIVAOtraTasa() {
		return montoIVAOtraTasa != null  ? montoIVAOtraTasa: BigDecimal.ZERO;
	}

	public void setMontoIVAOtraTasa(BigDecimal montoIVAOtraTasa) {
		this.montoIVAOtraTasa = montoIVAOtraTasa;
	}

	public BigDecimal getMontoIVATasaBasica() {
		return montoIVATasaBasica  != null  ? montoIVATasaBasica: BigDecimal.ZERO;
	}

	public void setMontoIVATasaBasica(BigDecimal montoIVATasaBasica) {
		this.montoIVATasaBasica = montoIVATasaBasica;
	}

	public BigDecimal getMontoIVATasaMinima() {
		return montoIVATasaMinima  != null  ? montoIVATasaMinima: BigDecimal.ZERO;
	}

	public void setMontoIVATasaMinima(BigDecimal montoIVATasaMinima) {
		this.montoIVATasaMinima = montoIVATasaMinima;
	}

	public BigDecimal getNetoIVAOtraTasa() {
		return netoIVAOtraTasa  != null  ? netoIVAOtraTasa: BigDecimal.ZERO;
	}

	public void setNetoIVAOtraTasa(BigDecimal netoIVAOtraTasa) {
		this.netoIVAOtraTasa = netoIVAOtraTasa;
	}

	public BigDecimal getNetoIVATasaBasica() {
		return netoIVATasaBasica  != null  ? netoIVATasaBasica: BigDecimal.ZERO;
	}

	public void setNetoIVATasaBasica(BigDecimal netoIVATasaBasica) {
		this.netoIVATasaBasica = netoIVATasaBasica;
	}

	public BigDecimal getNetoIVATasaMinima() {
		return netoIVATasaMinima  != null  ? netoIVATasaMinima: BigDecimal.ZERO;
	}

	public void setNetoIVATasaMinima(BigDecimal netoIVATasaMinima) {
		this.netoIVATasaMinima = netoIVATasaMinima;
	}

	public BigDecimal getMontoNoGravado() {
		return montoNoGravado  != null  ? montoNoGravado: BigDecimal.ZERO;
	}

	public void setMontoNoGravado(BigDecimal montoNoGravado) {
		this.montoNoGravado = montoNoGravado;
	}

	public BigDecimal getMontoAPagar() {
		return montoAPagar  != null  ? montoAPagar: BigDecimal.ZERO;
	}

	public void setMontoAPagar(BigDecimal montoAPagar) {
		this.montoAPagar = montoAPagar;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal  != null  ? montoTotal: BigDecimal.ZERO;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public BigDecimal getMontoCreditosFiscales() {
		return montoCreditosFiscales  != null  ? montoCreditosFiscales: BigDecimal.ZERO;
	}

	public void setMontoCreditosFiscales(BigDecimal montoCreditosFiscales) {
		this.montoCreditosFiscales = montoCreditosFiscales;
	}

	public BigDecimal getMontoRetenido() {
		return montoRetenido  != null  ? montoRetenido: BigDecimal.ZERO;
	}

	public void setMontoRetenido(BigDecimal montoRetenido) {
		this.montoRetenido = montoRetenido;
	}

	public BigDecimal getMontoNoFacturable() {
		return montoNoFacturable  != null  ? montoNoFacturable: BigDecimal.ZERO;
	}

	public void setMontoNoFacturable(BigDecimal montoNoFacturable) {
		this.montoNoFacturable = montoNoFacturable;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio  != null  ? tipoCambio: BigDecimal.ZERO;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
    
	
}
