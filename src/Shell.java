public class Shell {

    public int[] sort(int[] array, boolean asc) {

        int[] arr = array.clone(); 
        int n = arr.length;

        int comparaciones = 0;
        int cambios = 0;
        int iteraciones = 0;

        System.out.println("===== METODO SHELL =====\n");
        System.out.print("Arreglo original:\n");
        imprimirArreglo(arr);
        System.out.println();

        // Shell
        int gap    = n / 2;
        int iterID = 1;

        while (gap > 0) {

            for (int i = gap; i < n; i++) {
                iteraciones++;
                int j = i;

                System.out.printf("I%-3d", iterID);
                imprimirArreglo(arr);

                // Primera comparación
                comparaciones++;
                boolean condicion = asc ? (arr[j] < arr[j - gap]) : (arr[j] > arr[j - gap]);

                System.out.printf(
                        "          gap=%-2d a=%-2d b=%-2d  [a]=%-6d [b]=%-6d cambio=%s%n",
                        gap, j - gap, j, arr[j - gap], arr[j],
                        condicion ? "si" : "no");

                // Desplazamiento con gap
                while (j >= gap && condicion) {
                    cambios++;
                    int temp    = arr[j];
                    arr[j]      = arr[j - gap];
                    arr[j - gap]= temp;

                    System.out.print("     ");
                    imprimirArreglo(arr);

                    j -= gap;

                    if (j >= gap) {
                        comparaciones++;
                        condicion = asc ? (arr[j] < arr[j - gap])
                                        : (arr[j] > arr[j - gap]);

                        System.out.printf(
                                "          gap=%-2d a=%-2d b=%-2d  [a]=%-6d [b]=%-6d cambio=%s%n",
                                gap, j - gap, j, arr[j - gap], arr[j],
                                condicion ? "si" : "no");
                    }
                }

                iterID++;
                System.out.println();
            }
            gap /= 2;
        }

        System.out.print("end  ");
        imprimirArreglo(arr);
        System.out.println();
        System.out.println("COMPARACIONES = " + comparaciones);
        System.out.println("ITERACIONES   = " + iteraciones);
        System.out.println("CAMBIOS       = " + cambios);

        return new int[]{ comparaciones, cambios, iteraciones };
    }

    private void imprimirArreglo(int[] arr) {
        for (int v : arr) {
            System.out.printf("%5d", v);
        }
        System.out.println();
    }
}
