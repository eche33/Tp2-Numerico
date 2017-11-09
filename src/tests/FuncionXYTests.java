package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class FuncionXYTests {

	@Test
	void funcionXYEvaluaCorrectamente() {
		
		FuncionXY funcion = new FuncionXY();
		
		Assert.assertEquals(5, funcion.evaluar(2, 3), 0);
		
	}

}
