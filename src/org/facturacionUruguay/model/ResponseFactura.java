package org.facturacionUruguay.model;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.facturacionUruguay.conection.Client;
import org.facturacionUruguay.exception.NotResultException;

import com.google.gson.Gson;

public class ResponseFactura {

	private Cae cae;
	
	private List<Detalle> detalle;
	
	private Encabezado encabezado;
	
	private String timestimestampFirma;
	
	private String estadoFacturu;
	
	private String username;
	
	private String graficaCFE;
	
	private Client client;

	private String errorId;
	
	private String errorMessage;
	
	private String digestValue;
	
	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ResponseFactura(Client client){
		this.client = client;
	}
	
	public ResponseFactura(){
	}

	public ResponseFactura buscar(String rutEmisor, String tipoCFE, String serieCFE, String numeroCFE){
		Map<String,String> params = new HashMap<String,String>();
		String path = "/document/uy";
		params.put("rutEmisor", rutEmisor);
		params.put("tipoCFE", tipoCFE);
		params.put("serieCFE", serieCFE);
		params.put("numeroCFE", numeroCFE);
		String response = this.client.get(path,params);
		ResponseFactura factura = new Gson().fromJson(response, ResponseFactura.class);
		if(factura != null){
			return factura;
		}else{
			throw new NotResultException(response);
		}
	}
	
	public ResponseFactura solicitarCae(RequestFactura jsonCFE){
		jsonCFE.recalcularItems();
		String path = "/document/uy";
		String cfeJson = new Gson().toJson(jsonCFE);
		cfeJson = this.deAccent(cfeJson);
		String response = this.client.put(path, new HashMap<String,String>(), cfeJson);
		ResponseFactura factura = new Gson().fromJson(response, ResponseFactura.class);
		if(factura.getCae() != null && factura.getCae().getId() != null){
			return factura.init();
		}else{
			throw new NotResultException(response);
		}
	}
	
	private ResponseFactura init() {
		if(!this.getGraficaCFE().contains("codSegCFE") && this.getDigestValue() != null){
			this.setGraficaCFE(this.getGraficaCFE() + "&codSegCFE="+this.getDigestValue().substring(0, 5));
		}
		return this;
	}

	public String deAccent(String str) {
	      String nfdNormalizedString = Normalizer.normalize(str,  Normalizer.Form.NFD); 
	      Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	      return pattern.matcher(nfdNormalizedString).replaceAll("");
	}


	public Cae getCae() {
		return cae;
	}

	public void setCae(Cae cae) {
		this.cae = cae;
	}

	public List<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}

	public Encabezado getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(Encabezado encabezado) {
		this.encabezado = encabezado;
	}

	public String getTimestimestampFirma() {
		return timestimestampFirma;
	}

	public void setTimestimestampFirma(String timestimestampFirma) {
		this.timestimestampFirma = timestimestampFirma;
	}

	public String getEstadoFacturu() {
		return estadoFacturu;
	}

	public void setEstadoFacturu(String estadoFacturu) {
		this.estadoFacturu = estadoFacturu;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGraficaCFE() {
		return graficaCFE;
	}

	public void setGraficaCFE(String graficaCFE) {
		this.graficaCFE = graficaCFE;
	}

	public String getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}
	
}
