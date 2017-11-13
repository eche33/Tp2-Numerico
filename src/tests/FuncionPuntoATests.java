package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.FuncionPuntoA;

class FuncionPuntoATests {

	@Test
	void funcionEvaluaCorrectamenteConParametrosBasicos() {
		
		FuncionPuntoA funcion = new FuncionPuntoA();
		
		Assert.assertEquals(0.360, funcion.evaluar(1), 0.001);
	}
	
	
	@Test
	void funcionEvaluaCorrectamente2() {
		
		FuncionPuntoA funcion = new FuncionPuntoA();
		
		Assert.assertEquals(0, funcion.evaluar(889.79), 0.001);
	}

}
