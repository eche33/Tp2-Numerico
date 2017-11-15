package model;

import java.io.IOException;
import java.util.Scanner;

import jxl.write.WriteException;

public class Main {

	public static void main(String[] args) {
		
		/*int opcion = 1;
		
		while(opcion != 0) {
			
			System.out.println("Ingrese opcion deseada: \n");
			System.out.println("1-Evaluar funcion de punto 1 \n");
			
			Scanner entradaEscaner = new Scanner (System.in); 
		    opcion = Integer.parseInt(entradaEscaner.nextLine ());
		    
		    switch(opcion) {
		    
		    case 1: asistenteParaEvaluarFuncionPunto1();
		    		break;
		    		
		    }
		}

	}
	
	

	private static void asistenteParaEvaluarFuncionPunto1() {
		
		FuncionEulerExplicito funcion = new FuncionEulerExplicito();
		
		System.out.println("Ingrese parametro: \n");
		Scanner entradaEscaner = new Scanner (System.in); 
	    double parametro = Double.parseDouble(entradaEscaner.nextLine ());
	    
	    System.out.println("Resultado: "+ funcion.evaluar(parametro)+"\n");
	
		FuncionPuntoA funcion = new FuncionPuntoA();
		Euler metodo = new Euler(funcion);
		try {
			metodo.escribirEnExcel(20000, 29.2, 293);
		} catch (WriteException | IOException e) {
			e.printStackTrace();
		}	
		*/
		
		FuncionPuntoA funcion = new FuncionPuntoA();
		RungeKuta4 metodo = new RungeKuta4(funcion, 29.2);
		try {
			metodo.escribirEnExcel(20000, 293);
		} catch (WriteException | IOException e) {
			e.printStackTrace();
		}
	}
		
		
}
