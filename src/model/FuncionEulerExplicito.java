package model;

/*
 * Funcion obtenida para punto 1 del tp
 * La funcion es  -0.0000406*(T-889.79)
 */

public class FuncionEulerExplicito extends Funcion {

	
	@Override
	public double evaluar(double parametro) {
		
		double resultado = -0.000406*(parametro-889);
		
		return resultado;
	}

}
