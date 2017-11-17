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

public class Euler {
	
	private Funcion funcion;
	
	
	public Euler(Funcion funcion) {
		
		this.funcion = funcion;
	}


	
	public double aplicarMetodoParaUnPunto(double valorInicial, double h, int iteraciones) {
		
		double valorAnterior = valorInicial;
		double resultado = 0;
		
		for (int i=0; i<iteraciones; i++ ) {
			
			resultado = valorAnterior+(h*this.funcion.evaluar(valorAnterior, h*i));
			valorAnterior = resultado;
			
		}
		
		return resultado;
	}
	
	
	
	public void escribirEnExcel(double tope, double h, double valorInicial) throws IOException, RowsExceededException, WriteException {
		
		String fileName = "C:\\Users\\rorro\\Documents\\eulerExplicito.xls";
		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		
		Label tiempo = new Label(0,0, "Tiempo [s]");
		sheet.addCell(tiempo);
		
		Label temperatura = new Label(1,0,"Temperatura [K]");
		sheet.addCell(temperatura);
		
		int j = 1;
		
		double valorAnterior = valorInicial;
		
		for(double i=0; i<tope; i=i+h) {
			
			Number tiempoActual = new Number(0,j,i);
			double temperatura1 = this.aplicarMetodoParaUnPunto(valorAnterior, h, 1);
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
