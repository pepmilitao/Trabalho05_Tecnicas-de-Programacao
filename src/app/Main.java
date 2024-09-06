package app;
import java.util.Scanner;
import tools.concretes.*;
import tools.context.Context;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;

        // Número de elementos do array
        System.out.println("Ordenador de array");
        System.out.print("Insira o número de elementos do array: ");
        n = sc.nextInt();

        // Criando array com n elementos
        Double[] arr = new Double[n];

        // Ocupando os espaços do array
        System.out.println("Insira os números presentes nesse array (a cada número inserido pressione a tecla Enter)");

        for (int i = 0; i < n; ++i) {

            arr[i] = sc.nextDouble();
        }

        // 3 estratégias diferentes para ordenar o array
        System.out.println("Há 3 formas de ordenar o array:");
        System.out.println("- Pressione B para ordenar usando BubbleSort");
        System.out.println("- Pressione H para ordenar usando HeapSort");
        System.out.println("- Pressione M para ordenar usando MergeSort");

        String input = sc.next();

        // Inicializando variável da classe Context com estratégia nula
        Context contesto = new Context(null);

        // Determinando a estratégia usada para a ordenação dos elementos
        boolean rightInput = false;
        while (!rightInput) {

            rightInput = true;
            switch (input) {
                case "B":
                    contesto = new Context(new BubbleSort());
                    break;

                case "H":
                    contesto = new Context(new HeapSort());
                    break;

                case "M":
                    contesto = new Context(new MergeSort());
                    break;

                default:
                    rightInput = false;
                    System.out.println("Entrada inválida!\nInsira um caractere válido");
                    break;
            }
        }

        // Realizando a ordenação desejada
        arr = contesto.execSort(arr);

        // Mostrando elementos ordenados para usuário
        System.out.println("Array ordenado");
        for (int i = 0; i < n; ++i) {

            System.out.println(arr[i]);
        }

        sc.close();
    }
}
