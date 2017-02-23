import java.util.Scanner;

public class Pisos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] pisos = new int[files][columnes]
		int[][] pisos = new int[2][4];
		pisos[0][2]=3;
		pisos[1][1]=1;
		pisos[1][3]=1;

		//pisos.length ens retorna el número de files
		for(int fila=0;fila<pisos.length;fila++){
			Scanner lector = new Scanner(System.in);
			//pisos[fila][0]=lector.nextInt();
			for(int columna=0;columna<pisos[fila].length;columna++){
				//pisos[fila][columna]=lector.nextInt();
				System.out.print(pisos[fila][columna]+" ");
			}
			System.out.println("");
		}
		
		
	}

}
