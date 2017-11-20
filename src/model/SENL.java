package model;

/*2x2
 * 
 * Jacobiano invertido= [-0.5  1.5]
 * 						[ 1.5  -0.5]	
 */						  	
public class SENL {

	private double jacobiano[] [];
	private F1 F1;
	private F2 F2;
	private double soakingObj;
	private double tempObj;
	public int iteracionesUsadas;
	
	
	public SENL(double soakingObj, double tempObj) {
		
		this.soakingObj = soakingObj;
		this.tempObj = tempObj;
		this.jacobiano = new double [2][2];
		this.F1 = new F1(this.soakingObj);
		this.F2 = new F2(this.tempObj);
		
		this.cargarJacobiano();
		
		
	}


	private void cargarJacobiano() {
		
		this.jacobiano[0][0] = 1;
		this.jacobiano[0][1] = 0.5;
		this.jacobiano[1][0] = 0.5;
		this.jacobiano[1][1] = 1;
		
	}
	
	
	
	public double[] multiplicarMatrices(double[][] matrizA, double []matrizB) {
		
		double[] resultado =new double [2];
		
		for (int i = 0; i<2; i++) {
			
			double parcial = 0;
			
			for (int j = 0; j<2; j++) {
				
				parcial = parcial + ((matrizA[i][j])*(matrizB[j]));
				
			}
			
		resultado [i] = parcial;	
		}
		
		return resultado;
		}
	
	
	public double[] restarMatrices(double[] matrizA, double[] matrizB) {
		
		double[] resultado =new double [2];
		
		for (int i = 0; i<2; i++) {
			
			resultado[i] = matrizA[i]-matrizB[i];
		}
		
		return resultado;
	}
	
	
	
	public double[] calcular(double T1Semilla, double T2Semilla, double tolerancia) {
		
		double[] valorAnterior = new double[2];
		valorAnterior[0] = T1Semilla;
		valorAnterior[1] = T2Semilla;
		
		double[] valorActual = new double[2];
		valorActual [0] = 0;
		valorActual [1] = 0;
		
		int iteraciones = 0;
		
		while(!this.toleranciaSuficiente(valorAnterior, valorActual, tolerancia)) {
			
			iteraciones++;
			
			if(iteraciones>=2) {
				
				valorAnterior[0] = valorActual[0];
				valorAnterior[1] = valorActual[1];
			}
			
			double[] vector= new double[2];
			vector[0] = this.F1.evaluar(valorAnterior[0], valorAnterior[1]);
			vector[1] = this.F2.evaluar(valorAnterior[0], valorAnterior[1]);
			
			double[] auxiliar = new double[2];
			
			auxiliar = this.multiplicarMatrices(jacobiano, vector);
			
			valorActual[0] = valorAnterior[0]-auxiliar[0];
			valorActual[1] = valorAnterior[1]-auxiliar[1];
			
			System.out.println("T1: "+valorActual[0]+"\n");
			System.out.println("T2: "+valorActual[1]+"\n");
			
		}
		
		this.iteracionesUsadas = iteraciones;
		return valorActual;
	}


	
	private boolean toleranciaSuficiente(double[] valorAnterior, double[] valorActual, double tolerancia) {
		
		double resultado0 = valorActual[0] - valorAnterior [0];
		double resultado1 = valorActual[1] - valorAnterior [1];
		
		resultado0 = this.sacarModulo(resultado0);
		resultado1 = this.sacarModulo(resultado1);
		
		if((resultado0<=tolerancia)&&(resultado1<=tolerancia)){
			
			return true;
		}else {
			
			return false;
		}
	}


	private double sacarModulo(double numero) {
		
		if(numero<0) {
			
			return (-numero);
		}else {
			
			return numero;
		}
		
	}
	
}
