package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.F1;
import model.F2;

class F2Tests {

	@Test
	void F2EvaluaCorrectamente() {
		
		F2 funcion = new F2(600, 50, 0.0342, 29.2, 51, 293);
		
		Assert.assertEquals(184, funcion.evaluar(889,889), 1);
	}

}
