package examen;

import elmeuavio.FuncionsAvio;
import java.util.Scanner;

public class DamAirlines {

    public static void main(String[] args) {
        int opc = 0;
        int places=0;

        boolean exit = true;
        
        Scanner lector = new Scanner(System.in);
        System.out.println("Quantes places hi haurà de primera?");
    
     	while(!lector.hasNextInt()){
     		System.out.println("Introdueix un nombre enter");
            lector = new Scanner(System.in);
     	}
             
        places = lector.nextInt();
        boolean [] primera = Funcions.InicialitzarAvio(places);

        //Inicialitzar avió retornarà un vector en una posició per a cada plaça.
        //Inicialment l'avió està buit vol dir plaça lliure = false;
        System.out.println("Quantes places hi haurà de turista?");
    
        while(!lector.hasNextInt()){
        	System.out.println("Introdueix un nombre enter");
            lector = new Scanner(System.in);
        }
             
        places = lector.nextInt();
        boolean [] segona = Funcions.InicialitzarAvio(places);

        do {
            //funcions menú mostrará el següent menú:
            //1 - Reservar plaza
            //2 - Anular reserva
            //3 - Llistar plazas libres
            //4 - Llistar plazas ocupadas
            //5 - Sortir
            
            opc = FuncionsAvio.menu();
            switch (opc){
            
                case 1:
                	//la funció reservará una única plaça en un dels dos 
                    //vectors (que solicitarà a l'usuari. Retornarà false si no es pot reservar
                    exit = FuncionsAvio.reserva(primera, segona);
                    if (exit) {
                        System.out.println("Plaça reservada!");
                    } else {
                        System.out.println("Error en la reserva. La plaça no està disponible. Si us plau, reviseu llistat places lliures!");
                    }
                    break;    
                case 2:
                    //la funció anular reserva, anulará la reserva que 
                	//l'usuari inidique.
                    exit = FuncionsAvio.reserva(primera, segona);
                    if (exit) {
                        System.out.println("Reserva anulada!");
                    } else {
                        System.out.println("No s'ha pogut anular. Revise si ja estava anulada en anterioritat!");
                    }
                    break;
                    
                case 3:
                    //llistará les places lliures
                    FuncionsAvio.lliures(primera, segona);
                    break;    
                case 4:
                    //llistará les places ocupades
                    FuncionsAvio.ocupades(primera, segona);
                    break;
                    
                case 5:
                    System.out.println("Adeu!");
                    break;    
                default:
                    System.out.println("Opció incorrecta!");
            }        
            
        }while (opc != 5);            
        
    }

}

