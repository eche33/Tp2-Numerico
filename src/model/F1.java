package model;

public class F1 {
	
	private double objetivo;
	private double temperauraInicial;
	private double largo;
	private double paso;
	private double velociadInicial;
	private int iteraciones;
	
	public F1(double objetivo, double largo, double velocidadInicial, double paso, int iteraciones, double tempInicial) {
		
		this.objetivo = objetivo;
		this.temperauraInicial = tempInicial;
		this.largo = largo;
		this.velociadInicial = velocidadInicial;
		this.paso = paso;
		this.iteraciones = iteraciones;
		
		
	}

	public double evaluar(double t1, double t2) {
		
		FuncionPunto2 funcion = new FuncionPunto2(this.largo, this.velociadInicial, t1, t2);
		RungeKuta4 metodo = new RungeKuta4(funcion, this.paso, this.iteraciones);
		
		metodo.aplicarMetodo(this.temperauraInicial);
		
		double soaking = metodo.calcularSoaking();
		
		return (soaking-this.objetivo);
		
		
	}

	

}
