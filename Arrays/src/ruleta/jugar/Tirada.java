package ruleta.jugar;

public class Tirada {
	public static final int minim=0;
	public static final int maxim=36;
	
	public static int partida( int max, int min) {
		 int ran=(int) Math.floor(Math.random() * 37);
		// ran=10;
		 return ran;
		}

}
