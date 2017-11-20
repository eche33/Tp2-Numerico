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

public abstract class MetodoED {
	
	protected Funcion funcion;
	protected double h;
	protected double[] vectorResultados;
	protected int iteraciones;
	
	public abstract void aplicarMetodo(double valorInicial); //Carga el vector con la info
	
	
	public void escribirEnExcel() throws IOException, RowsExceededException, WriteException {
		
		String fileName = "C:\\Users\\rorro\\Documents\\rungeKuta4.xls";
		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		
		Label tiempo = new Label(0,0, "Tiempo [s]");
		sheet.addCell(tiempo);
		
		Label temperatura = new Label(1,0,"Temperatura [K]");
		sheet.addCell(temperatura);
		
		int j = 1;
		
		for(int i=0; i<this.iteraciones; i++) {
			
			Number tiempoActual = new Number(0,j,i*this.h);
			Number temperaturaActual = new Number(1,j,this.vectorResultados[i]);
			
			j++;
			
			sheet.addCell(tiempoActual);
			sheet.addCell(temperaturaActual);
			
		}
		
		workbook.write();
		workbook.close();
	}
	
	
	public double calcularSoaking() {
		
		double temperaturaMinima = (this.vectorResultados[this.iteraciones-1])-283; //Genero rango [Tfinal, Tfinal-10]
		int contador = 0;
		double temperaturaActual = this.vectorResultados[this.iteraciones-1-contador]; 
		
		while(temperaturaActual>temperaturaMinima) {
			
			contador++;
			temperaturaActual = this.vectorResultados[this.iteraciones-1-contador];
		}
		
		return (this.h*(contador-1));
		
	}
	
	
	public double calcularTemperaturaPromedio() {
		
		double temperaturaMinima = (this.vectorResultados[this.iteraciones-1])-283; //Genero rango [Tfinal, Tfinal-10]
		int contador = 0;
		double temperaturaActual = this.vectorResultados[this.iteraciones-1-contador]; 
		double total = 0;
		
		while(temperaturaActual>temperaturaMinima) {
			
			contador++;
			total = total + temperaturaActual;
			temperaturaActual = this.vectorResultados[this.iteraciones-1-contador];
		}
		
		return (total/contador);
		
	}
	
	
	
	

}
