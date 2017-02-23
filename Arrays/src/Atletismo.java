import java.util.Scanner;
public class Atletismo {
 
    // DEFINICION CONSTANTES
    private static final String hombre = "0";
    private static final String mujer = "1";
    private static final String Palleja = "08780";
    private static final String Cornella = "08940";
    private static final String Gava = "08850";
    private static final String Santmarti = "08020";
    private static final String Poblenou = "08018";
    private static final String Pedralbes = "08034";
 
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
 
        // DEFINICION VARIABLES
        
        int opcio; // definimos la opcion del switch
        int atletasint = 0; // definimos el nombre de atletas introducidos (para saber la posicion en la matriz)
        int numeroatletas = 0; // definimos otro numero para los atletas introducidos antes de cambiarlo
        String nombreatleta=""; // para el nombre del atleta
        String apellidoatleta=""; // para el apellido del atleta
        String nombreclave=""; // para el codigo nombre
        String apellidoclave=""; // para el codigo apellido
        String sexoatleta; // para comprobar si sexo es correcto
        String sexo = ""; // para escribir el sexo en texto
        String edadatletast; // para introducir la edad como string
        int edadatleta; // para comparar la edad como int
        String categoriaatleta = ""; // variable para la categoria
        String categoriaatletacodigo = ""; // variable de la categoria para el codigo
        String quota; // la quota la fijamos en 17.5 y solo la cambiamos en caso de que tenga 18 años o mas
        boolean edadnum = true; // para comprobar si la edad es un numero
        String edadString; // para guardar la edad como string
        String codigopostal; // para guardar el codigo postal
        boolean codigonum = true; // para comprobar si el codigo postal es numerico
        String poblacion;// variable para guardar la poblacion
        String codigoatleta; // el codigo completo del atleta
        String[][] atletas = new String [0][8]; // definimos la matriz principal donde se almacenaran todos los atletas
        String[][] atletascopia = new String [0][8]; // definimos la matriz que guardara lo que habia en la matriz antes de aumentarla
        // abrimos bucle para que se repita el menu hasta que selecione la opcion de salir
        do {
        System.out.println("-----------------------------------");
        System.out.println("-    GESTION CLUB DE ATLETISMO    -");
        System.out.println("-----------------------------------");
        System.out.println("-                                 -");
        System.out.println("-(1) Introducir nuevo atleta      -");
        System.out.println("-(2) Mostrar lista de atletas     -");
        System.out.println("-(3) Modificar datos de un atleta -");
        System.out.println("-(4) Salir                        -");
        System.out.println("-----------------------------------");
        System.out.println("Introduce la opcion:");
        opcio = lector.nextInt();
        switch (opcio)
        {
        case 1:  // introducir un nuevo atleta
            quota = "17.5";
            	demanarNom(nombreatleta,apellidoatleta,nombreclave,apellidoclave);
            	
                // guardamos estas dos letras cambiadas en las variables "nombreclave" y "apellidoclave"
                // repetimos el bucle hasta que introduzca un valor igual a 0 o a 1, en otro caso saldra un mensaje y  
                // se volvera a pedir
                do{  
                System.out.println("Introduce el sexo del atleta (Hombre= 0  Mujer= 1) ");
                sexoatleta = lector.next();
                switch (sexoatleta){
                case hombre:
                    sexo = "Hombre";
                    break;
                case mujer:
                    sexo = "Mujer";
                    break;
                default:
                    System.out.println("-Indeterminada- (tiene que ser 0 o 1), introduce otra");
                    break;
                }
                }while(!(sexoatleta.equals("0") || sexoatleta.equals("1")));
                // ahora guardamos la edad, para esta se hace un if y en caso de que sea mas pequeño de 4 o mas grande de 150 no
                // dejara introducir mas datos y volvera al menu directamente sin añadir ninguna informacion de este
                // de otra forma si la edad introducida esta entre 5 y 149 esta se guardará y a su vez tambíen la categoria
                // segun su edad, y las dos primeras letras de este que las guardaremos como categoriaatletacodigo para el codigo
                do {
                    do {
                    System.out.println("Introduce la edad del atleta");
                    edadatletast = lector.next();
                    edadnum=comprobar(edadatletast);
                    
                    }while(edadnum);  
                edadatleta = Integer.parseInt(edadatletast);
                
                if (edadatleta < 4)
                {
                    System.out.println("Es demasiado joven! Introduce otra");
                }
                else
                {
                    if (edadatleta <= 7)
                    {
                        categoriaatleta = "MICROS";
                        categoriaatletacodigo = "MI";
                    }
                    else
                    {
                        if (edadatleta <= 9)
                        {
                            categoriaatleta = "BENJAMIN";
                            categoriaatletacodigo = "BE";
                        }
                        else
                        {
                            if (edadatleta <= 11)
                            {
                                categoriaatleta = "ALEVIN";
                                categoriaatletacodigo = "AL";
                            }
                            else
                            {
                                if (edadatleta <= 13)
                                {
                                    categoriaatleta = "INFANTIL";
                                    categoriaatletacodigo = "IN";
                                }
                                else
                                {
                                    if (edadatleta <= 15)
                                    {
                                        categoriaatleta = "CADETE";
                                        categoriaatletacodigo = "CA";
                                    }
                                    else
                                    {
                                        if (edadatleta <= 17)
                                        {
                                            categoriaatleta = "JUVENIL";
                                            categoriaatletacodigo = "JU";
                                        }
                                        else
                                        {
                                            if (edadatleta <= 150)
                                            {
                                                categoriaatleta = "SENIOR";
                                                categoriaatletacodigo = "SE";
                                                quota = "23.7"; // al tener mas de 18 años le cambiamos la quota
                                            }
                                            else {
                                                System.out.println("Es demasiado mayor! Introduce otra");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                }while (!(edadatleta>3 && edadatleta<=150));
            
                // ahora dejamos que introduzca el codigo postal
                edadString = Integer.toString(edadatleta);
                do{
                System.out.println("Introduce el codigo postal del atleta (tiene que tener 5 numeros)");
                codigopostal = lector.next(); // guardamos el codigo postal
                // segun el codigo postal con un switch comprobamos si corresponde a una de las siguientes poblaciones
                // en caso de que no, la poblacion saldra como indeterminada
                codigonum = comprobar(codigopostal);
                char cp1 = codigopostal.charAt(0);
                char cp2 = codigopostal.charAt(1);
                if (!(codigopostal.length()==5)){
                     System.out.println("Tiene que tener 5 digitos, introducelo de nuevo");
                     System.out.println("");
                     codigonum = true;
                }
                else
                {
                    if(!(cp1=='0' && cp2=='8')){
                        System.out.println("El codigo postal tiene que estar entre el 08000 y el 08999, introducelo de nuevo");
                        System.out.println("");
                        codigonum = true;
                    }
                }
                
                }while(codigonum);
                switch (codigopostal){
                case Palleja:
                    poblacion = "Palleja";
                    break;
                case Cornella:
                    poblacion = "Cornellà";
                    break;
                case Gava:
                    poblacion = "Gava";
                    break;
                case Santmarti:
                    poblacion = "Sant Martí";
                    break;
                case Poblenou:
                    poblacion = "Poblenou";
                    break;
                case Pedralbes:
                    poblacion = "Pedralbes";
                    break;
                default:
                    poblacion = "Indeterminada";
                    break;
                }
                // A continuacion juntamos los codigos de nombre y apellido con la edad y el codigo de la categoria
                // de esta forma obtenemos el codigo del atleta
                codigoatleta = nombreclave+apellidoclave+edadatleta+categoriaatletacodigo;
                // ahora lo bueno; si hemos llegado hasta aqui significa que los datos introducidos son correctos, por lo que  
                // podemos añadir ya el nuevo atleta. primero aumentamos el numero de atletas que hay
                numeroatletas++;
                // ahora reiniciamos la matriz de los atletas con las filas que correspondan a cada atleta introducido
                atletas = new String [numeroatletas][8];
                atletas = rellenar(codigoatleta, nombreatleta, apellidoatleta, sexo, edadString, poblacion, categoriaatleta, quota, numeroatletas, atletasint);
                // y ahora copiamos el contenido de la copia (la primera vez vacia) a la matriz principal.
                for (int x=0;x<atletascopia.length;x++){
                    for (int i = 0; i < atletascopia[0].length; i++) {
                        atletas[x][i] = atletascopia[x][i];
                    }   
                }
                // una vez copiado el contenido anterior, le ponemos la nueva informacion, en la posicion que corresponda a cada atleta
                // ahora reiniciamos la matriz de la copia o matriz auxiliar
                atletascopia = new String [numeroatletas][8];
                // y copiamos la matriz principal con su nuevo contenido en la copia tambien
                for (int x=0;x<atletas.length;x++){
                    for (int i = 0; i < atletas[0].length; i++) {
                        atletascopia[x][i] = atletas[x][i];
                    }   
                }
                // por ultimo se la mostramos al usuario (le mostramos los datos del ultimo atleta introducido)
                System.out.print((atletasint+1)+"[ ");
                    for (int j = 0; j < atletas[0].length; j++) {
                        System.out.print(atletas[atletasint][j]+" - ");
                    }
                System.out.println(" ]");
                // y aumentamos la variable que define la posicion de los atletas
                atletasint++;
                break;
        case 2:
            // Mostrar todos los atletas
            if (numeroatletas>0){
             System.out.println(" ");
              System.out.println("Estos son los atletas introducidos");
                 System.out.println(" ");
                 //realizamos el bucle para la matriz principal con dos for para las filas y las columnas y mostramos el contenido
                for (int i = 0; i < atletasint; i++) {
                    System.out.print((i+1)+"[ ");
                    for (int j = 0; j < atletas[0].length; j++) {
                        System.out.print(atletas[i][j]+"  ");
                    }
                     System.out.println(" ]");
                }
            }
            else
            {
                 System.out.println("No hay ningun atleta introducido aun");
            }
              break;
        case 3:  
            //modificar atleta
            // Primero se los volvemos a mostrar para que vea cuales hay y que vea los codigos
            if (numeroatletas>0){
            System.out.println(" ");
              System.out.println("Estos son los atletas introducidos");
                 System.out.println(" ");
                for (int i = 0; i < atletasint; i++) {
                    System.out.print((i+1)+"[ ");
                    for (int j = 0; j < atletas[0].length; j++) {
                        System.out.print(atletas[i][j]+"  ");
                    }
                     System.out.println(" ]");
                }
                 System.out.println(" ");
                 // una vez mostrados le preguntamos cual quiere modificar (le pedimos el codigo)
             System.out.println("Que atleta quieres modificar? (introduce su codigo)");
             String mod = lector.next(); //guardamos el codigo que entra
             int mod2=-1; //inicializamos una variable a -1 para comparar  
            //realizamos un for que analize cada valor de las filas de la matriz en la columna 0 la cual corresponde a el codigo
             for (int i = 0; i < atletas.length; i++) {
                if (mod.equals(atletas[i][0])){ //en caso de que el valor entrado corresponda a un codigo de la matriz
                    mod2=i; // la variable la cambiamos por la posicion correspondiente a ese codigo
                    break;
                }
            }
             if (mod2<0){ // si el numero es mas pequeño que 0 (o sea que no se ha cambiado porque ningun codigo es igual al introducido)
                 System.out.println("Ese no esta en la lista"); // mostramos un aviso y salimos
                 break;
             }
             else  // en caso contrario, realizaremos todo el primer paso exactamente igual, pero sin aumentar el numero de atletas
                 // sencillamente cambiando solo la posicion entrada
             {
                 quota = "17.5";
                 		demanarNom(nombreatleta,apellidoatleta,nombreclave,apellidoclave);
                        // guardamos estas dos letras cambiadas en las variables "nombreclave" y "apellidoclave"
                        // repetimos el bucle hasta que introduzca un valor igual a 0 o a 1, en otro caso saldra un mensaje y  
                        // se volvera a pedir
                        do{  
                        System.out.println("Introduce el sexo del atleta (Hombre= 0  Mujer= 1) ");
                        sexoatleta = lector.next();
                        switch (sexoatleta){
                        case hombre:
                            sexo = "Hombre";
                            break;
                        case mujer:
                            sexo = "Mujer";
                            break;
                        default:
                            System.out.println("-Indeterminada- (tiene que ser 0 o 1), introduce otra");
                            break;
                        }
                        }while(!(sexoatleta.equals("0") || sexoatleta.equals("1")));
                        // ahora guardamos la edad, para esta se hace un if y en caso de que sea mas pequeño de 4 o mas grande de 150 no
                        // dejara introducir mas datos y volvera al menu directamente sin añadir ninguna informacion de este
                        // de otra forma si la edad introducida esta entre 5 y 149 esta se guardará y a su vez tambíen la categoria
                        // segun su edad, y las dos primeras letras de este que las guardaremos como categoriaatletacodigo para el codigo
                        do {
                            do {
                            System.out.println("Introduce la edad del atleta");
                            edadatletast = lector.next();
                            edadnum=comprobar(edadatletast);
                            }while(edadnum);  
                        edadatleta = Integer.parseInt(edadatletast);
                        
                        if (edadatleta < 4)
                        {
                            System.out.println("Es demasiado joven! Introduce otra");
                        }
                        else
                        {
                            if (edadatleta <= 7)
                            {
                                categoriaatleta = "MICROS";
                                categoriaatletacodigo = "MI";
                            }
                            else
                            {
                                if (edadatleta <= 9)
                                {
                                    categoriaatleta = "BENJAMIN";
                                    categoriaatletacodigo = "BE";
                                }
                                else
                                {
                                    if (edadatleta <= 11)
                                    {
                                        categoriaatleta = "ALEVIN";
                                        categoriaatletacodigo = "AL";
                                    }
                                    else
                                    {
                                        if (edadatleta <= 13)
                                        {
                                            categoriaatleta = "INFANTIL";
                                            categoriaatletacodigo = "IN";
                                        }
                                        else
                                        {
                                            if (edadatleta <= 15)
                                            {
                                                categoriaatleta = "CADETE";
                                                categoriaatletacodigo = "CA";
                                            }
                                            else
                                            {
                                                if (edadatleta <= 17)
                                                {
                                                    categoriaatleta = "JUVENIL";
                                                    categoriaatletacodigo = "JU";
                                                }
                                                else
                                                {
                                                    if (edadatleta <= 150)
                                                    {
                                                        categoriaatleta = "SENIOR";
                                                        categoriaatletacodigo = "SE";
                                                        quota = "23.7"; // al tener mas de 18 años le cambiamos la quota
                                                    }
                                                    else {
                                                        System.out.println("Es demasiado mayor! Introduce otra");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        }while (!(edadatleta>3 && edadatleta<=150));
                        // ahora dejamos que introduzca el codigo postal
                        edadString = Integer.toString(edadatleta);
                        codigonum = true;
                        do{
                            System.out.println("Introduce el codigo postal del atleta (tiene que tener 5 numeros)");
                            codigopostal = lector.next(); // guardamos el codigo postal
                            // segun el codigo postal con un switch comprobamos si corresponde a una de las siguientes poblaciones
                            // en caso de que no, la poblacion saldra como indeterminada
                            codigonum = comprobar(codigopostal);
                            char cp1 = codigopostal.charAt(0);
                            char cp2 = codigopostal.charAt(1);
                            if (!(codigopostal.length()==5)){
                                 System.out.println("Tiene que tener 5 digitos, introducelo de nuevo");
                                 System.out.println("");
                                 codigonum = true;
                            }
                            else
                            {
                                if(!(cp1=='0' && cp2=='8')){
                                    System.out.println("El codigo postal tiene que estar entre el 08000 y el 08999, introducelo de nuevo");
                                    System.out.println("");
                                    codigonum = true;
                                }
                            }
                            
                            }while(codigonum);
                        switch (codigopostal){
                        case Palleja:
                            poblacion = "Palleja";
                            break;
                        case Cornella:
                            poblacion = "Cornellà";
                            break;
                        case Gava:
                            poblacion = "Gava";
                            break;
                        case Santmarti:
                            poblacion = "Sant Martí";
                            break;
                        case Poblenou:
                            poblacion = "Poblenou";
                            break;
                        case Pedralbes:
                            poblacion = "Pedralbes";
                            break;
                        default:
                            poblacion = "Indeterminada";
                            break;
                        }
                        // A continuacion juntamos los codigos de nombre y apellido con la edad y el codigo de la categoria
                        // de esta forma obtenemos el codigo del atleta
                        codigoatleta = nombreclave+apellidoclave+edadatleta+categoriaatletacodigo;
                        // ahora lo bueno; si hemos llegado hasta aqui significa que los datos introducidos son correctos, por lo que  
                        // podemos añadir ya el nuevo atleta. primero aumentamos el numero de atletas que hay
                        // una vez copiado el contenido anterior, le ponemos la nueva informacion, en la posicion que corresponda a cada atleta
                        String [] atletasarray = modificar(codigoatleta, nombreatleta, apellidoatleta, sexo, edadString, poblacion, categoriaatleta, quota, numeroatletas, mod2);
                        // y copiamos la matriz principal con su nuevo contenido en la copia tambien
                        
                        for (int j=0; j<atletasarray.length;j++){
                            atletas[mod2][j]= atletasarray [j];
                        }
                        
                        
                        for (int x=0;x<atletas.length;x++){
                            for (int i = 0; i < atletas[0].length; i++) {
                                atletascopia[x][i] = atletas[x][i];
                            }   
                        }
                        // por ultimo se la mostramos al usuario (le mostramos los datos del ultimo atleta introducido)
                        System.out.print((mod2+1)+"[ ");
                            for (int j = 0; j < atletas[0].length; j++) {
                                System.out.print(atletas[mod2][j]+" - ");
                            }
                        System.out.println(" ]");        
            }
            }
            else
            {
                System.out.println("No hay ningun atleta introducido aun");
            }
            break;
        case 4:
            break;
        default:
            System.out.println("Valor no valido, solo puede ser 1, 2, 3 o 4");
        } //cierra switch
         
       }while (opcio!=4);
    }
    // funcion que comprueba si un string es numerico  
    public static boolean comprobar(String a) {
        if (a == null || a.isEmpty()){
            System.out.println("La edad tiene que ser numerica! introducela otra vez");
            return true;
        }
        int i = 0;
        if (a.charAt(0) == '-'){
            if (a.length() > 1){
                i++;
            } else {
                System.out.println("La edad tiene que ser numerica! introducela otra vez");
                return true;
            }
        }
        for (; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))){
                System.out.println("La edad tiene que ser numerica! introducela otra vez");
                return true;
            }
        }
            return false;
    }
  
    public static void demanarNom(String nombreatleta, String apellidoatleta,String nombreclave,String apellidoclave){
    	Scanner lector = new Scanner(System.in);
    	String nombre1="",nombre2,apellido1,apellido2;
    	do{
            System.out.println("Introduce el nombre del atleta (tiene que estar formado por 2 caracteres minimo)");
            nombreatleta = lector.next(); // guardamos el nombre del atleta
            System.out.println("Introduce el apellido del atleta (tiene que estar formado por 2 caracteres minimo)");
            apellidoatleta = lector.next(); // guardamos el apellido
            // lo siguiente sirve para seleccionar solamente las dos primeras letras del nombre y el apellido y ponerlas en
            // mayuscula o minuscula segun corresponde para el codigo de atleta que mas adelante formaremos
            if (nombreatleta.length()<2 || apellidoatleta.length()<2){
                System.out.println("Tiene que tener minimo 2 caracteres! Introducelo de nuevo");
                System.out.println("");
            }
        }while(nombreatleta.length()<2 || apellidoatleta.length()<2);
    	
        nombre1 = nombreatleta.substring(0,1);
        nombre2 = nombreatleta.substring(1,2);
        nombreclave = nombre1.toUpperCase()+nombre2.toLowerCase();
        apellido1 = apellidoatleta.substring(0,1);
        apellido2 = apellidoatleta.substring(1,2);
        apellidoclave = apellido1.toUpperCase()+apellido2.toLowerCase();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // funcion que crea una nueva matriz con los valores introducidos
    public static String[][] rellenar(String a, String b, String c, String d, String e, String f, String g, String h, int y, int z) {
        String[][] matriz = new String [y][8];
        matriz[z][0] = a;
        matriz[z][1] = b;
        matriz[z][2] = c;
        matriz[z][3] = d;
        matriz[z][4] = e;
        matriz[z][5] = f;
        matriz[z][6] = g;
        matriz[z][7] = h;
            return matriz;
    }
    // funcion que crea un array nou amb els valors introduits
    public static String[] modificar(String a, String b, String c, String d, String e, String f, String g, String h, int y, int z) {
        String[] array = new String [8];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;
        array[4] = e;
        array[5] = f;
        array[6] = g;
        array[7] = h;
            return array;
    }
}
    


