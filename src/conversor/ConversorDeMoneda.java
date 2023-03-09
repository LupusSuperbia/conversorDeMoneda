package conversor;

import java.util.HashMap;

public class ConversorDeMoneda {
	private double moneda;
	private String convertir;
	private double monedaCambio;
	 HashMap<Object, Object> tasasDeCambio = new HashMap<>();
	
	public double getMoneda() {
		return moneda;
	}

	public void setMoneda(double moneda) {
		this.moneda = moneda;
	}
	
	public double convertido(String monedaOrigen, String monedaDestino) {
		double cambio = devolverTasaDeCambio(monedaOrigen, monedaDestino);
		if(getMoneda() > 0) {
			monedaCambio = cambio * getMoneda();
			return monedaCambio;
		} else {
			return 0;
		}
		
		
	}

	public String getConvertir() {
		return convertir;
	}

	public void setConvertir(String convertir) {
		this.convertir = convertir;
	}


	  public ConversorDeMoneda() {
		  
	        // Inicializar el mapa con las tasas de cambio
	       
	        tasasDeCambio.put("ARG-DOLAR", 0.005);
	        tasasDeCambio.put("ARG-EURO", 0.0088);
	        tasasDeCambio.put("ARG-GBP", 0.0076);
	        tasasDeCambio.put("ARG-JPY", 1.17);
	        tasasDeCambio.put("ARG-KRW", 12.34);
	        tasasDeCambio.put("DOLAR-ARG", 371.31);
	        tasasDeCambio.put("DOLAR-EURO", 0.85);
	        tasasDeCambio.put("DOLAR-GBP", 0.72);
	        tasasDeCambio.put("DOLAR-JPY", 106.68);
	        tasasDeCambio.put("DOLAR-KRW", 1130.40);
	        tasasDeCambio.put("EURO-ARG", 113.17);
	        tasasDeCambio.put("EURO-DOLAR", 1.17);
	        tasasDeCambio.put("EURO-GBP", 0.85);
	        tasasDeCambio.put("EURO-JPY", 125.64);
	        tasasDeCambio.put("EURO-KRW", 1337.34);
	        tasasDeCambio.put("GBP-ARG", 131.28);
	        tasasDeCambio.put("GBP-DOLAR", 1.39);
	        tasasDeCambio.put("GBP-EURO", 1.18);
	        tasasDeCambio.put("GBP-JPY", 153.58);
	        tasasDeCambio.put("GBP-KRW", 1636.44);
	        tasasDeCambio.put("JPY-ARG", 0.85);
	        tasasDeCambio.put("JPY-DOLAR", 0.0094);
	        tasasDeCambio.put("JPY-EURO", 0.0079);
	        tasasDeCambio.put("JPY-GBP", 0.0065);
	        tasasDeCambio.put("JPY-KRW", 10.66);
	        tasasDeCambio.put("KRW-ARG", 0.081);
	        tasasDeCambio.put("KRW-DOLAR", 0.0009);
	        tasasDeCambio.put("KRW-EURO", 0.0007);
	        tasasDeCambio.put("KRW-GBP", 0.0006);
	        tasasDeCambio.put("KRW-JPY", 0.094);
	    }
	  
	  private double devolverTasaDeCambio(String monedaOrigen, String monedaDestino) {
		  if(monedaOrigen.equals(monedaDestino)) {
			  return 1.0;
		  } else {
			 String clave = monedaOrigen + "-" + monedaDestino;
			 if (tasasDeCambio.containsKey(clave)) {
				 return (double) tasasDeCambio.get(clave);
			 } else {
				 return 0.0;
			 }
		  }
		
	  }

}
