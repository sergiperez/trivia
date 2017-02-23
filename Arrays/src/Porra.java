import java.util.Scanner;

public class Porra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//La matriu per guardar la informació de la porra
		String[][] porra = new String[4][3];
		
		Scanner lector = new Scanner(System.in);
		//Bucle para rellenar las apuestas
		//APUESTA 1
		//Dato1
		//Dato2 
		//Dato3
		//APUESTA 2
		for(int aposta=0;aposta<porra.length;aposta++){
			System.out.println("Entra aposta "+(aposta+1));
			for(int dada=0;dada<porra[aposta].length;dada++){
				System.out.print("Entra dada "+(dada+1));
				porra[aposta][dada]=lector.next();
			}
		}
		
		//PINTEM DADES
		for(int aposta=0;aposta<porra.length;aposta++){
			System.out.println("Aposta "+(aposta+1));
			for(int dada=0;dada<porra[aposta].length;dada++){
				System.out.print(porra[aposta][dada]+"-");
			}
			System.out.println("");
		}
		
		for(String[] fila : porra){
			for(String columna : fila){
				System.out.print(columna);
			}
		}
	}

}
