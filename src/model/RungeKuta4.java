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

	public RungeKuta4 (Funcion funcion, double paso) {
		
		this.funcion = funcion;
		this.h = paso;
	}
	
	
	private double getQ1(double valor) {
		
		return (this.h*this.funcion.evaluar(valor));
	}
	
	
	private double getQ2(double valor) {
		
		double y = (this.getQ1(valor))*1/2;
		double x = this.funcion.evaluar(valor+y);
		
		return (x*this.h);
	}
	
	
	private double getQ3(double valor) {
		
		double y = (this.getQ2(valor))*1/2;
		double x = this.funcion.evaluar(valor+y);
		
		return (x*this.h);
	}
	
	
	private double getQ4(double valor) {
		
		double y = (this.getQ3(valor));
		double x = this.funcion.evaluar(valor+y);
		
		return (x*this.h);
	}
	
	
	public double aplicarMetodoParaUnPunto(double valorInicial, int iteraciones) {
		
		double valorAnterior = valorInicial;
		double resultado = 0;
		
		for (int i=0; i<iteraciones; i++ ) {
			
			double valorAuxiliar = (this.getQ1(valorAnterior))+(2*this.getQ2(valorAnterior))+(2*this.getQ3(valorAnterior)+this.getQ4(valorAnterior));
			resultado = valorAnterior+((valorAuxiliar)*1/6);
			valorAnterior = resultado;
			
		}
		
		return resultado;
	}
	
	
	
	public void escribirEnExcel(double tope, double valorInicial) throws IOException, RowsExceededException, WriteException {
		
		String fileName = "C:\\Users\\rorro\\Downloads\\rungeKuta4.xls";
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
			double temperatura1 = this.aplicarMetodoParaUnPunto(valorAnterior, 1);
			Number temperaturaActual = new Number(1,j,temperatura1);
			
			valorAnterior = temperatura1;
			j++;
			
			sheet.addCell(tiempoActual);
			sheet.addCell(temperaturaActual);
			
		}
		
		workbook.write();
		workbook.close();
		
		
	}
	
	
}
