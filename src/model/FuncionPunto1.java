package model;

/*
 * Funcion obtenida para punto 1 del tp
 * La funcion es  -0.000406*(T-Tinf)
 */

public class FuncionPunto1 extends Funcion {

	
	public FuncionPunto1 (double largoTotal, double velocidadInicial, double t1, double t2) {
		
		this.largoTotal = largoTotal;
		this.velocidadInicial = velocidadInicial;
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public double evaluar(double parametro, double tiempo) {
		
		double resultado = -0.000406*(parametro-this.determinarTemperatura(tiempo));
		
		return resultado;
	}

}
