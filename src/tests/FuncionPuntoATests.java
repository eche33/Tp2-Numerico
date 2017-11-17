package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.FuncionPuntoA;

class FuncionPuntoATests {

	@Test
	void funcionEvaluaCorrectamenteConParametrosBasicos() {
		
		FuncionPuntoA funcion = new FuncionPuntoA(50, 0.0342, 889, 889);
		
		Assert.assertEquals(0.360, funcion.evaluar(1, 700), 0.001);
	}
	
	
	@Test
	void funcionEvaluaCorrectamente2() {
		
		FuncionPuntoA funcion = new FuncionPuntoA(50, 0.0342, 889, 889);
		
		Assert.assertEquals(0, funcion.evaluar(889.79, 1400), 0.001);
	}
	
	
	@Test
	void funcionEvaluaCorrectamenteConTemperaturat2() {
		
		FuncionPuntoA funcion = new FuncionPuntoA(50, 0.0342, 889, 200);
		
		Assert.assertEquals(-0.27, funcion.evaluar(889, 1400), 0.01);
	}

}
