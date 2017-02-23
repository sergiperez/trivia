import java.util.Scanner;

public class Apuesta {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("quants jugadors sou?");
		int jugadors=lector.nextInt();
		// TODO Auto-generated method stub
		
		
		
		//Matriu on guardaré les apostes
		String[][] apostes = new String[jugadors][3];
		String[] noms_columnes= {"nom","gols equip local","gols equip visitant"};
		//String[][] menu = new String[3][2];
		
		//Introducción apuestas
		for(int fila=0;fila<apostes.length;fila++){

			System.out.println("NOVA APOSTA");
			for(int columna=0;columna<apostes[fila].length;columna++){
				System.out.println("Entra el dato "+noms_columnes[columna]+" :");
				apostes[fila][columna]=lector.next();
			}
		}

		
		//Bucle que pinta todas las apuestas
		for(int fila=0;fila<apostes.length;fila++){
			System.out.println("APOSTA "+(fila+1));
			for(int columna=0;columna<apostes[fila].length;columna++){
				System.out.print(apostes[fila][columna]+"-");
			}
			System.out.println("");
		}
		
		//Anem a veure qui és el guanyador
		System.out.println("Entreu el resultat del partit");
		System.out.println("Entra els gols del local");
		String golsLocal=lector.next();
		System.out.println("Entra els gols del visitant");
		String golsVisitant=lector.next();
		boolean hihaGuanyador=false;
		
		//Bucle que pinta todas las apuestas
		for(int fila=0;fila<apostes.length;fila++){
			if(golsLocal.equals(apostes[fila][1]) && golsVisitant.equals(apostes[fila][2])){
				System.out.println("El guanyador és "+apostes[fila][0]);
				hihaGuanyador=true;
			}
		}
		
		if(!hihaGuanyador){
			System.out.println("No hi ha cap guanyador, panocos, colorsito, haters, daniels victor, jefe, puto amo,  loosers");
		}
		lector.close();
	}

}
