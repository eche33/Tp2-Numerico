package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.FuncionPunto2;

class FuncionPunto2Tests {

	@Test
	void funcionEvaluaCorrectamenteConCero() {
		
		FuncionPunto2 funcion = new FuncionPunto2();
		
		Assert.assertEquals(0.97, funcion.evaluar(0), 0.01);
	}
	
	
	@Test
	void funcionEvaluaCorrectamenteConValorInicial() {
		
		FuncionPunto2 funcion = new FuncionPunto2();
		
		Assert.assertEquals(0, funcion.evaluar(889), 0.01);
	}
	
	
	@Test
	void funcionEvaluaCorrectamenteConDiez() {
		
		FuncionPunto2 funcion = new FuncionPunto2();
		
		Assert.assertEquals(0.96, funcion.evaluar(10), 0.01);
	}

}
