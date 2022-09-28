package org.facturacionUruguay.conection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.facturacionUruguay.model.ResponseFactura;


public class Client {

	private static final String API_URL_TEST = "http://api.test.facturu.com";
	private static final String API_URL_PRODUCCION = "https://api.facturu.com";
	private static String credentialTesting = "d6b9bf4d-23c4-4632-9be0-5421725042c7/6d1d88a4-bb7c-4811-b57d-d8070a57f80e";

	private String apyKey;
	
	private String secretKey;
	
	public String getApyKey() {
		return apyKey;
	}
	public void setApyKey(String apyKey) {
		this.apyKey = apyKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public ResponseFactura instanciarFactura(){
		return new ResponseFactura(this);
	}
	
	private boolean inProduction = true;
	
	public void isProduction(boolean inProduction){
		this.inProduction = inProduction;
	}
	
	private String getURL() {
		if(this.inProduction){
			return API_URL_PRODUCCION;
		}else{
			return API_URL_TEST;
		}
	}

	public String get(String path, Map<String, String> params){
		
		String response = null;
		try {
			response = crearConexion(prepareApiUrl(path,parametersToUrl(params)),"GET", null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	} 
	
	public String put(String path, Map<String, String> params, String body){
		StringBuffer bodyConCFE = new StringBuffer("cfeJson= ");
		bodyConCFE.append(body);
		String response = null;
		try {
			response = crearConexion(prepareApiUrl(path,parametersToUrl(params)), "PUT", bodyConCFE.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	} 
	
	public String crearConexion(String url, String method, String body) throws IOException{
		
		URL urlFacturu = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlFacturu.openConnection();
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		String response = null;
		
		connection.setRequestMethod(method);
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Authorization", this.getCredenciales());
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		connection.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());
		
		if (body != null && !body.isEmpty()) {
			writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(body);
			writer.flush();
			writer.close();
		}
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		response = recorrerBuffered(reader);
		reader.close();
		connection.disconnect();
		return response;
	}
	
	private String getCredenciales() {
		if(this.inProduction){
			return this.apyKey + "/" + this.secretKey;
		}else{
			return credentialTesting;
		}
	}
	
	private static String recorrerBuffered(BufferedReader reader) {
		String auxLine;
		StringBuffer auxResponse = new StringBuffer();
		try {
			while ((auxLine = reader.readLine()) != null) {
				auxResponse.append(auxLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auxResponse.toString();		
	}
	
	private String parametersToUrl(Map<String, String> params) {
		String query = "";
		for (String key : params.keySet()) {
			String value = params.get(key);
			query = query + key + "=" + value + "&";

		}
		return query;
	}
	
	private String prepareApiUrl(String path, String query) {
		return getURL() + path + "?" + query;
	}
}
