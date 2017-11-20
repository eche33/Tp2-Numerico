package model;

public class F1 {
	
	private double objetivo;
	
	public F1(double objetivo) {
		
		this.objetivo = objetivo;
	}

	public double evaluar(double t1, double t2) {
		
		FuncionPunto2 funcion = new FuncionPunto2(50, 0.0342, t1,t2);
		RungeKuta4 metodo = new RungeKuta4(funcion, 29.2, 51);
		
		metodo.aplicarMetodo(293);
		
		double soaking = metodo.calcularSoaking();
		
		return (soaking-this.objetivo);
		
		
	}

	

}
