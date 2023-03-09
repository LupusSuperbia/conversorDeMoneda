package conversor;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class test {
public static void main(String[] args) {
	ConversorDeTemp conver = new ConversorDeTemp();
	
	DoubleUnaryOperator  CToF = conver.temperaturaConversor.get("CtoF");
	double celsius = 20;
	double fahrenheit = CToF.applyAsDouble(celsius);
	DoubleUnaryOperator CToK = conver.temperaturaConversor.get("CtoK");
	double kelvin = CToK.applyAsDouble(celsius);
	System.out.println(fahrenheit);
	System.out.println(kelvin);
	
}
}
