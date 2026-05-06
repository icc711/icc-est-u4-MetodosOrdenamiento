import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        int [] arreglo = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3};
        Insertion insertion = new Insertion();
        Shell shell = new Shell();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Menu del "Programa de Ordenamientos" !
        do {
            System.out.println("\n==== PROGRAMA DE ORDENAMIENTOS ====\n");
            System.out.println("1. Ejecutar Ordenamientos.");
            System.out.println("2. Salir.");
            System.out.println("\nSeleccione una opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    boolean ascInsercion = leerBooleano(sc, "¿Insercion ascendente? (true/false): ");
                    boolean ascShell = leerBooleano(sc, "¿Shell ascendente? (true/false): ");
                    System.out.println();

                    int [] resInsercion = insertion.sort(arreglo, ascInsercion);
                    System.out.println();
                    int [] resShell = shell.sort(arreglo, ascShell);

                    System.out.println("\n=======================================");
                    System.out.println("         Resumen de Resultados");
                    System.out.println("=========================================");
                    System.out.printf("%-20s %s%n", "Metodo", "Comparaciones / Cambios / Iteraciones");
                    System.out.println("-----------------------------------------");
                    System.out.printf("%-20s %d / %d / %d%n",
                        "Insercion", resInsercion[0], resInsercion[1], resInsercion[2]);
                    System.out.printf("%-20s %d / %d / %d%n",                        
                        "Shell", resShell[0], resShell[1], resShell[2]);
                    System.out.println("=========================================");
                    break;
                
                case 2:
                    System.out.println("\nPrograma finalizado");
                    break;
            
                default:
                    System.out.println("Opcion invalida. Ingrese opción 1 o 2.");
                    break;
            }
        } while (opcion != 2);
        sc.close();
        }            
        
        private static int leerEntero(Scanner sc){
            while (true) {
                if (sc.hasNext()){
                    return sc.nextInt();
                } else {
                    System.out.println("Entrada invalida. Ingrese un número: ");
                    sc.next();
                }               
            }
        }
        private static boolean leerBooleano(Scanner sc, String mensaje){
            while (true) {
                System.out.println(mensaje);
                String entrada = sc.next ().trim().toLowerCase();
                if (entrada.equals("true")) return true;
                if (entrada.equals("false")) return false;
                System.out.println("Entrada invalida. Ingrese 'true' o 'false'.");
            }
        }        
}
