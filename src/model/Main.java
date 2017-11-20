package model;

import java.io.IOException;
import java.util.Scanner;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) {
		
		FuncionPunto2 funcion = new FuncionPunto2(50, 0.0342, 658,952);
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
	}
		
		
}
