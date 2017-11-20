package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import model.F1;
import model.FuncionPunto2;
import model.RungeKuta4;

class F1Tests {

	@Test
	void F1EvaluaCorrectamente() {
		
		F1 funcion = new F1(600);
		
		Assert.assertEquals(480.4, funcion.evaluar(889,889), 0.01);
	}

}
