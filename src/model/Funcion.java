package model;

public abstract class Funcion {
	
	protected double velocidadInicial;
	protected double t1;
	protected double t2;
	protected double largoTotal;
	
	
	public abstract double evaluar(double parametro, double tiempo);
	
	
	public double determinarPosicion(double tiempo) {
		
		double posicion = this.velocidadInicial*tiempo;
		
		return posicion;
	}
	
	
	public double determinarTemperatura(double tiempo) {
		
		if(this.determinarPosicion(tiempo)>this.largoTotal/2) {
			
			return this.t2;
		}else {
			
			return this.t1;
		}
	}
	
	
	
	
}
