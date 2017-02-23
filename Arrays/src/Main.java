import java.util.*;
public class Main {
	public static final int maxAlumnes=2;
	public static void main(String[] args) {
		Scanner lector = new Scanner (System.in);
		
		//Definiu matriu on guardareu per a cada alumne i dia, si pot quedar (true) o no (false)

		int[] millorsDies=new int[8];
		boolean[][] alumnes= new boolean[maxAlumnes][7];
			//Demanar quan poden els ex-alumnes
			for(int ex=0;ex<maxAlumnes;ex++){
			      System.out.println("Hola! Alumne "+ex+" ara ens diràs quins dies pots de la setmana que ve.");
			       for (int dia=0;dia<alumnes[ex].length;dia++){
			       	String respostaDisponible="";
			       	
			       	//Demana mentre la resposta no sigui S o N
			       	do{
			       		System.out.println("Pots el "+diaParaula(dia)+" (S/N)?");
			       		respostaDisponible=lector.next();
			       	}while((!respostaDisponible.toLowerCase().equals("s")) && (!respostaDisponible.toLowerCase().equals("n")));
			       	
			       	//Cridem a omplirDia
			       	omplirDia(alumnes,ex,dia,respostaDisponible);
			   	}
			   }
			
			//Guardem els vots per mostrar-los
			int vots=millorDia(alumnes,millorsDies);
		//Mostrar missatge amb el nom del dia que diu la funció diaParaula
		System.out.println("El millor dia per quedar es "+diaParaula(millorsDies[7])+" perque te "+vots+" vots");
	}
	
	//mostra dies
	public static void showDies(int[] dies){
		System.out.println("Els millors dies per quedar son: ");
		for (int i=0;i<dies.length;i++){
			if(dies[i]!=0) System.out.println( diaParaula(i));
		}
	}
	
	
	//Millors dies per quedar
	public static int millorDia(boolean[][] alumnes, int[] millorsDies){
		int max=0;
		for (int i=0;i<alumnes.length;i++){
		 for (int columna=0;columna<alumnes[i].length;columna++){
		   if (alumnes[i][columna]) millorsDies[columna]++;
		 }
		}
	 for (int i=0;i<millorsDies.length-1;i++){
	   if (millorsDies[i]>max){
	     max=millorsDies[i];
	     millorsDies[7]=i;
	   }
	 }
	 return max;
	}
	
	//numeros a dias
	public static String diaParaula(int dia_num){
		String dia_nombre;
		switch(dia_num){
		case 0: dia_nombre="Dilluns";	break;
		case 1: dia_nombre="Dimarts";	break;
		case 2:dia_nombre="Dimecres";	break;
		case 3:dia_nombre="Dijous";	break;
		case 4:dia_nombre="Divendres";	break;
		case 5:dia_nombre="Dissabte";	break;
		case 6:dia_nombre="Diumenge";	break;
		default: dia_nombre="Aquest dia no existeix";
		}
		
		return dia_nombre;
	}
	
	//rellena setmana
	public static void omplirDia(boolean[][] alumnes,int fila,int columna, String respostaDisponible){
		alumnes[fila][columna]=respostaDisponible.equals("s");			
			
	}

}