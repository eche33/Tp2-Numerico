package model;

import java.io.IOException;
import java.util.Scanner;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {

	public static void main(String[] args) {
		
		FuncionPuntoA funcion = new FuncionPuntoA(50, 0.0342, 889, 889);
		RungeKuta4 metodo = new RungeKuta4(funcion, 29.2);
		
		try {
			metodo.escribirEnExcel(1461.99, 293);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
}
