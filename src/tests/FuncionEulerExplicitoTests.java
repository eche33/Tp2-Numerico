package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.FuncionEulerExplicito;

class FuncionEulerExplicitoTests {

	@Test
	void funcionEvaluaCorrectamenteConParametrosBasicos() {
		
		FuncionEulerExplicito funcion = new FuncionEulerExplicito();
		
		Assert.assertEquals(0.360, funcion.evaluar(1), 0.001);
	}
	
	
	@Test
	void funcionEvaluaCorrectamente2() {
		
		FuncionEulerExplicito funcion = new FuncionEulerExplicito();
		
		Assert.assertEquals(0, funcion.evaluar(889.79), 0.001);
	}

}
