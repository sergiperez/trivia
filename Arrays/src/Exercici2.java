/*
*
* Crea un programa que demani 10 números sencers, 
* i que els guardi. 
*La sortida de l’aplicació, haurà de ser els 10 números però en ordre invertit. 
*/
import java.util.Scanner;

import doodle.*;


public class Exercici2{
	public static void main(String args[]){
		//Demanar 10 números
		Scanner lector = new Scanner(System.in);
		int[] num= new int[10];
		//Demanar i guardar
		for(int i=0;i<num.length;i++){
			System.out.println("Entra el numero "+(i+1));
			num[i]=lector.nextInt();
		}	

		//Pintar array
		for(int i : num){
			System.out.println("El numero és "+i);
		}		

		System.out.println(Trobarcita.diaParaula(1));
		Evento.pinta("aaa");
		//L'ordre invers he de fer el bucle decreixent
		for(int i=num.length;i>0;i--){
			System.out.println("El numero "+i+" és "+num[i-1]);
		}		
		lector.close();
	}

}