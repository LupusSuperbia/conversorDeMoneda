package conversor;

import java.util.HashMap;
import java.util.function.DoubleUnaryOperator;

public class ConversorDeTemp {

	double tempActual;
	double tempConv;
	public HashMap<String, DoubleUnaryOperator> temperaturaConversor = new HashMap<>();
	
	public ConversorDeTemp () {
		temperaturaConversor.put("CtoF", celsius -> (celsius * 9/5) + 32);
		temperaturaConversor.put("CtoK", celsius -> celsius + 273.15);
		temperaturaConversor.put("FtoC", fahrenheit -> (5/9)*(fahrenheit - 32));
		temperaturaConversor.put("FtoK", fahrenheit -> (fahrenheit - 32) + 273.15);
		temperaturaConversor.put("KtoC", kelvin -> kelvin - 273.15);
		temperaturaConversor.put("KtoF", kelvin -> (9/5) * (kelvin - 273.15) + 32);
	}
	
	public void setTempActual(double tempActual) {
		this.tempActual = tempActual;
	}
	public double getTempActual() {
		return tempActual;
	}
	
	public double conversorTemp(String fun, double monto) {
		DoubleUnaryOperator  funTem = temperaturaConversor.get(fun);
		
		return funTem.applyAsDouble(monto);
	}
	
}
