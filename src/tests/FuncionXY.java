package tests;
/*
 * Funcion hecha solo para probar la logica con una funcion simple para luego aplicar
 * la misma logica a las funciones del problema
 */
import model.Funcion;

public class FuncionXY extends Funcion {

	@Override
	public double evaluar(double parametro1, double parametro2) {
		
		return (parametro1+parametro2);
	}

}
