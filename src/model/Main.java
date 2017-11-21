package model;

import java.io.IOException;
import java.util.Scanner;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) {
		
		/*FuncionPunto2 funcion = new FuncionPunto2(50, 0.0342,658,952);
		RungeKuta4 metodo = new RungeKuta4(funcion, 29.2, 51);
		
		metodo.aplicarMetodo(293);
		
		
		System.out.println("Soaking: "+metodo.calcularSoaking()+"\n");
		System.out.println("Tsoaking: "+metodo.calcularTemperaturaPromedio()+"\n");*/
		
		SENL sistema =  new SENL(600, 784, 50, 0.0342, 29.2, 51, 293);
		
		double[] resultado = new double[2];
		
		resultado = sistema.calcular(784, 784, 0.9);
		
		System.out.println("T1: "+resultado[0]+"\n");
		System.out.println("T2: "+resultado[1]+"\n");
		
	}
		
		
}
