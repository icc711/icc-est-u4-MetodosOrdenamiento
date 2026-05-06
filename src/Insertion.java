public class Insertion {

    public int[] sort(int[] array, boolean asc) {

        int[] arr = array.clone();
        int n = arr.length;

        int comparaciones = 0;
        int cambios = 0;
        int iteraciones = 0;

        System.out.println("===== METODO INSERCION =====\n");
        System.out.print("Arreglo original:\n");
        imprimirArreglo(arr);
        System.out.println();

        for (int i = 1; i < n; i++) {
            iteraciones++;
            int j = i;
            System.out.printf("I%-3d", i);
            imprimirArreglo(arr);

            while (j > 0) {
                comparaciones++;
                boolean condicion = asc ? (arr[j] < arr[j - 1]) : (arr[j] > arr[j - 1]);

                System.out.printf("          a=%-2d b=%-2d  [a]=%-6d [b]=%-6d cambio=%s%n", j - 1, j, arr[j - 1], arr[j], condicion ? "si" : "no");

                if (condicion) {
                    cambios++;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                    System.out.print("     ");
                    imprimirArreglo(arr);
                    j--;
                } else {
                    break;
                }
            }
            System.out.println();
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
