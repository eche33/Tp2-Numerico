package model;

import java.io.IOException;
import java.util.Scanner;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) {
		
		/*FuncionPunto2 funcion = new FuncionPunto2(50, 0.0342, 889,889);
		RungeKuta4 metodo = new RungeKuta4(funcion, 29.2, 51);
		
		metodo.aplicarMetodo(293);
		
		try {
			metodo.escribirEnExcel();
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Soaking: "+metodo.calcularSoaking()+"\n");
		System.out.println("Tsoaking: "+metodo.calcularTemperaturaPromedio()+"\n");*/
		
		SENL sistema =  new SENL(600, 784);
		
		double[] resultado = new double[2];
		
		resultado = sistema.calcular(680, 940, 0.9);
		
		System.out.println("T1: "+resultado[0]+"\n");
		System.out.println("T2: "+resultado[1]+"\n");
		
		
		/*F1 f1 = new F1(600);
		F2 f2 = new F2(784);
		
		System.out.println("T1: "+f1.evaluar(784, 784)+"\n");
		System.out.println("T2: "+f2.evaluar(784, 784)+"\n");*/
	}
		
		
}
