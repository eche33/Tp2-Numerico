package model;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class RungeKuta4 extends MetodoED{
	

	public RungeKuta4 (Funcion funcion, double paso, int iteraciones) {
		
		this.funcion = funcion;
		this.h = paso;
		this.iteraciones = iteraciones;
		this.vectorResultados = new double[this.iteraciones];
		
	}
	
	
	private double getQ1(double valor, double tiempo) {
		
		return (this.h*this.funcion.evaluar(valor, tiempo));
	}
	
	
	private double getQ2(double valor, double tiempo) {
		
		double y = (this.getQ1(valor, tiempo))*1/2;
		double x = this.funcion.evaluar(valor+y, tiempo);
		
		return (x*this.h);
	}
	
	
	private double getQ3(double valor, double tiempo) {
		
		double y = (this.getQ2(valor, tiempo))*1/2;
		double x = this.funcion.evaluar(valor+y, tiempo);
		
		return (x*this.h);
	}
	
	
	private double getQ4(double valor, double tiempo) {
		
		double y = (this.getQ3(valor, tiempo));
		double x = this.funcion.evaluar(valor+y, tiempo);
		
		return (x*this.h);
	}
	
	

	
	
	
	/*
	
	
	public double calcularTemperaturaPromedio() {
		
		double temperatura = (this.vectorTemperaturas[50])-283;
		int contador = 1;
		double total = this.vectorTemperaturas[50];
		double temperaturaActual = this.vectorTemperaturas[50];
		
		while(temperaturaActual>temperatura) {
			
			temperaturaActual = this.vectorTemperaturas[50-contador];
			total = total + temperaturaActual;
			contador++;
		}
		
		return (total/(contador-1));
		
	}*/


	@Override
	public void aplicarMetodo(double valorInicial) {
		
		double valorAnterior = valorInicial;
		double resultado = 0;
		
		for (int i=0; i<this.iteraciones; i++ ) {
			
			double tiempo = this.h*i;
			double valorAuxiliar = (this.getQ1(valorAnterior,tiempo))+(2*this.getQ2(valorAnterior,tiempo))+(2*this.getQ3(valorAnterior,tiempo)+this.getQ4(valorAnterior,tiempo));
			resultado = valorAnterior+((valorAuxiliar)*1/6);
			
			this.vectorResultados[i] = resultado;
			valorAnterior = resultado;
			
		}
		
	}
	
	
}
