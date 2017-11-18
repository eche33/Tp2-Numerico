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

public class RungeKuta4 {
	
	private Funcion funcion;
	private double h;
	private double[] vectorTemperaturas;

	public RungeKuta4 (Funcion funcion, double paso) {
		
		this.funcion = funcion;
		this.h = paso;
		this.vectorTemperaturas = new double [51];
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
	
	
	public double aplicarMetodoParaUnPunto(double valorInicial, int iteraciones, double tiempo) {
		
		double valorAnterior = valorInicial;
		double resultado = 0;
		
		for (int i=0; i<iteraciones; i++ ) {
			
			double valorAuxiliar = (this.getQ1(valorAnterior,tiempo))+(2*this.getQ2(valorAnterior,tiempo))+(2*this.getQ3(valorAnterior,tiempo)+this.getQ4(valorAnterior,tiempo));
			resultado = valorAnterior+((valorAuxiliar)*1/6);
			valorAnterior = resultado;
			
		}
		
		return resultado;
	}
	
	
	
	public void escribirEnExcel(double tope, double valorInicial) throws IOException, RowsExceededException, WriteException {
		
		String fileName = "C:\\Users\\rorro\\Documents\\rungeKuta4.xls";
		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		
		Label tiempo = new Label(0,0, "Tiempo [s]");
		sheet.addCell(tiempo);
		
		Label temperatura = new Label(1,0,"Temperatura [K]");
		sheet.addCell(temperatura);
		
		int j = 1;
		
		double valorAnterior = valorInicial;
		
		for(double i=0; i<tope; i=i+this.h) {
			
			Number tiempoActual = new Number(0,j,i);
			double temperatura1 = this.aplicarMetodoParaUnPunto(valorAnterior, 1, i);
			Number temperaturaActual = new Number(1,j,temperatura1);
			
			valorAnterior = temperatura1;
			this.vectorTemperaturas[j-1] = temperatura1;
			j++;
			
			sheet.addCell(tiempoActual);
			sheet.addCell(temperaturaActual);
			
		}
		
		workbook.write();
		workbook.close();
		
		
	}
	
	
	public double calcularSoaking() {
		
		double temperatura = (this.vectorTemperaturas[50])-283;
		int contador = 1;
		double temperaturaActual = this.vectorTemperaturas[50];
		
		while(temperaturaActual>temperatura) {
			
			temperaturaActual = this.vectorTemperaturas[50-contador];
			contador++;
		}
		
		return (this.h*(contador-2));
		
	}
	
	
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
		
	}
	
	
}
