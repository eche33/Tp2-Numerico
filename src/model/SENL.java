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
	private MetodoED metodo;
	private double soakingObj;
	private double tempObj;
	
	
	public SENL(MetodoED metodo) {
		
		this.metodo = metodo;
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
	
}
