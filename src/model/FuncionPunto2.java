package model;

/*
 * f = 0.000406.(t-889) - 9.79E-13 (t^4-tinf^4)
 */

public class FuncionPunto2 extends Funcion {

	/*@Override
	public double evaluar(double parametro) {
		
		double parteConveccion = -0.000406*(parametro-889);
		
		double parametroElevado = Math.pow(parametro, 4);
		double temperaturaInicialElevada = Math.pow(889, 4);
		
		double parteRadiacion = -0.000000000000979*(parametroElevado-temperaturaInicialElevada);
		
		return (parteConveccion+parteRadiacion);
	}*/
	
	public FuncionPunto2 (double largoTotal, double velocidadInicial, double t1, double t2) {
		
		this.largoTotal = largoTotal;
		this.velocidadInicial = velocidadInicial;
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public double evaluar(double parametro, double tiempo) {
		
		double parteConveccion = -0.000406*(parametro-this.determinarTemperatura(tiempo));
		
		double parametroElevado = Math.pow(parametro, 4);
		double temperaturaHornoElevada = Math.pow(this.determinarTemperatura(tiempo), 4);
		
		double parteRadiacion = -0.000000000000979*(parametroElevado-temperaturaHornoElevada);
		
		return (parteConveccion+parteRadiacion);
		
	}
	
	

}
