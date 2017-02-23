package ruleta;
import ruleta.jugar.Tirada;
import ruleta.jugar.Premi;


public class Ruleta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("El número sortit de la ruleta");
		System.out.println(Premi.diners());
		System.out.println(Tirada.partida(Tirada.maxim, Tirada.minim));
	}

}
