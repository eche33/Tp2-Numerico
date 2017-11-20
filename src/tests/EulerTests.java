package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.Euler;
import model.FuncionPunto1;

class EulerTests {

	@Test
	void eulerFuncionaCorrectamenteCon1Iteracion() {
		
		FuncionPunto1 funcion = new FuncionPunto1(50, 0.0342, 889, 889);
		Euler euler = new Euler(funcion);
		
		Assert.assertEquals(0.361, euler.aplicarMetodoParaUnPunto(0,1,1), 0.001);
	}
	
	
	@Test
	void eulerFuncionaCorrectamenteCon2Iteraciones() {
		
		FuncionPunto1 funcion = new FuncionPunto1(50, 0.0342, 889, 200);
		Euler euler = new Euler(funcion);
		
		Assert.assertEquals(0.722, euler.aplicarMetodoParaUnPunto(0,1,2), 0.001);
	}
	
	
	
	@Test
	void eulerFuncionaCorrectamenteConDatosDeProblemaParaUnaIteracion() {
		
		FuncionPunto1 funcion = new FuncionPunto1(50, 0.0342, 889, 0);
		Euler euler = new Euler(funcion);
		
		Assert.assertEquals(300, euler.aplicarMetodoParaUnPunto(293,29.2,1), 0.1);
	}
	
	

}
