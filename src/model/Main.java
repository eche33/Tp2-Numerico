package model;

import java.io.IOException;
import java.util.Scanner;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) {
		
		FuncionPunto2 funcion = new FuncionPunto2(50, 0.0342,771,1048);
		RungeKuta4 metodo = new RungeKuta4(funcion, 29.2, 51);
		
		metodo.aplicarMetodo(293);
		try {
			metodo.escribirEnExcel();
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Soaking: "+metodo.calcularSoaking()+"\n");
		System.out.println("Tsoaking: "+metodo.calcularTemperaturaPromedio()+"\n");
		
		/*Punto 4
		 * 
		 * SENL sistema =  new SENL(600, 931, 50, 0.0342, 14.6, 101, 293);
		
		double[] resultado = new double[2];
		
		resultado = sistema.calcular(931, 931, 0.9);
		
		System.out.println("T1: "+resultado[0]+"\n");
		System.out.println("T2: "+resultado[1]+"\n");
		System.out.println("Iteraciones: "+ sistema.getIteraciones()+"\n");*/
		
	}
		
		
}
