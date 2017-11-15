package model;

/*
 * f = 0.000406.(t-889) - 9.79E-13 (t^4-889^4)
 */

public class FuncionPunto2 extends Funcion {

	@Override
	public double evaluar(double parametro) {
		
		double parteConveccion = -0.000406*(parametro-889);
		
		double parametroElevado = Math.pow(parametro, 4);
		double temperaturaInicialElevada = Math.pow(889, 4);
		
		double parteRadiacion = -0.000000000000979*(parametroElevado-temperaturaInicialElevada);
		
		return (parteConveccion+parteRadiacion);
	}
	
	

}
