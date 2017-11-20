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
	
	
	public SENL(double soakingObj, double tempObj) {
		
		this.soakingObj = soakingObj;
		this.tempObj = tempObj;
		this.jacobiano = new double [2][2];
		this.F1 = new F1(this.soakingObj);
		this.F2 = new F2(this.tempObj);
		
		this.cargarJacobiano();
		
		
	}


	private void cargarJacobiano() {
		
		this.jacobiano[0][0] = -0.5;
		this.jacobiano[0][1] = 1.5;
		this.jacobiano[1][0] = 1.5;
		this.jacobiano[1][1] = -0.5;
		
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
	
	public void calcular(double T1Semilla, double T2Semilla) {
		
		
	}
	
}
