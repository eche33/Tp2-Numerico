package model;

public class RungeKuta4 {
	
	private Funcion funcion;
	private double h;

	public RungeKuta4 (Funcion funcion, double paso) {
		
		this.funcion = funcion;
		this.h = paso;
	}
	
	
	private double getQ1(double valor) {
		
		return (this.h*this.funcion.evaluar(valor));
	}
	
	
	private double getQ2(double valor) {
		
		double y = (this.getQ1(valor))*1/2;
		double x = this.funcion.evaluar(valor+y);
		
		return (x*this.h);
	}
	
	
	
	
}
