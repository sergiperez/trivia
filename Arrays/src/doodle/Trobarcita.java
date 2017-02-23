package doodle;
import java.util.Scanner;

public class Trobarcita {
	
	//Definiu constant diesSetmana i maxAlumnes
	public static final int maxAlumnes=3;
	public static final int diesSetmana=7;
	public static final String[] setmana={"dilluns","dimarts","dimecres","dijous","divendres","dissabte","diumenge"};
	

	public static void main(String[] args) {

	Scanner lector = new Scanner (System.in);

		//Definiu matriu on guardareu per a cada alumne i dia, si pot quedar (true) o no (false)
		boolean[][] diesTriats= new boolean[maxAlumnes][diesSetmana];
		int[] disponibles= new int[diesSetmana];
		    

		//Demanar quan poden els ex-alumnes

		for(int ex=0;ex<maxAlumnes;ex++){

		       System.out.println("Hola! Alumne "+ex+" ara ens diràs quins dies pots de la setmana que ve.");

		        for (int dia=0;dia<diesSetmana;dia++){

		    	String respostaDisponible="";

		    	do{

		    		System.out.println("Pots el "+diaParaula(dia)+"(S/N)?");

		    		respostaDisponible=lector.next();

			//Demana mentre la resposta no sigui S o N

		    	}while(!(respostaDisponible.toUpperCase().equals("S") || respostaDisponible.toUpperCase().equals("N")));

			//Cridem a omplirDia

		    	omplirDia(diesTriats,ex,dia,respostaDisponible);

		    	}

		    }

		    

		//Comptar alumnes per dia usant la funció alumnesDisponibles
		for(int dia=0;dia<diesSetmana;dia++){
			disponibles[dia]=alumnesDisponibles(diesTriats,dia);
		}
		

		//Decidir quin dia és el que va millor cridant diaLLiure
		int diaEscollit = diaLLiure(disponibles);

	//Mostrar missatge amb el nom del dia que diu la funció diaParaula

		System.out.println("El millor dia per quedar és "+diaParaula(diaEscollit)+" perquè té "+disponibles[diaEscollit]+" ex-alumnes disponibles.");

		  }

	public static String diaParaula(int dia){
		return setmana[dia];
	}	
	
	public static void omplirDia(boolean[][] graella, int alumne, int dia, String resposta){
		graella[alumne][dia]=resposta.equals("S");
	}	
	
	public static int alumnesDisponibles(boolean[][] graella,int dia){
		int numero=0;
		for(int al=0;al<graella.length;al++){
			if (graella[al][dia]) numero++; 
		}
		return numero;
	} 

	public static int diaLLiure(int[] disponibles){
		int triat=0,max=0;
		for(int dia=0;dia<disponibles.length;dia++){
			if (disponibles[dia]>max){
				triat=dia;
			}
		}
		return triat;
	}
}
