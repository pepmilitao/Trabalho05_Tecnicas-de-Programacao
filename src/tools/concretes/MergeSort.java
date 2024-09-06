package tools.concretes;
import tools.abstracts.Strategy;

public class MergeSort implements Strategy {

    // Método para a mescla de dois arrays ordenados
    private Double[] Merge (Double arr[], int l, int m, int r) {

        // Criação de variáveis auxiliares
        int i, j, k;

        // Os tamanhos dos arrays 1 e 2 são determinados pelo índice esquerdo, direito e central
        int n1 = m - l + 1;
        int n2 = r - m;

        // Arrays auxiliares criados e preenchidos
        Double[] A1 = new Double[n1];
        Double[] A2 = new Double[n2];

        for (i = 0; i < n1; ++i) {

            A1[i] = arr[l + i];
        }

        for (j = 0; j < n2; ++j) {

            A2[j] = arr[m + j + 1];
        }

        // Verificação individual dos elementos de cada array
        i = 0; j = 0; k = l;

        // Enquanto não verificamos um dos arrays por completo, o laço é executado
        while (i < n1 && j < n2) {
            
            // O maior elemento é inserido no array de retorno
            if (A1[i] <= A2[j]) {

                arr[k] = A1[i];
                ++i;
            } else {

                arr[k] = A2[j];
                ++j;
            }

            ++k;
        }

        // Após o laço anterior, o restante dos elementos do outro array auxiliar são simplesmente inseridos no array de retorno
        while (i < n1) {

            arr[k] = A1[i];
            ++i; ++k;
        }

        while (j < n2) {

            arr[k] = A2[j];
            ++j; ++k;
        }

        return arr;
    }
    
    // Parte recursiva do algoritmo
    private void RecMergeSort (Double arr[], int l, int r) {

        // Se l não for menor que r, então l == r, já que não é possível que r > l
        // Isso implica que o array possui somente 1 elemento, não podendo ser dividido
        if (l < r) {

            int m = l + (r - l) / 2;

            // Porção esquerda é ordenada
            RecMergeSort(arr, l, m);

            // Porção direita é ordenada
            RecMergeSort(arr, m + 1, r);

            // Duas porções são mescladas
            Merge(arr, l, m, r);
        }
    }

    // Implementação do método da interface Strategy
    public Double[] sortEntities (Double[] arr) {
        
        int n = arr.length;
        RecMergeSort(arr, 0, n - 1);
        return arr;
    }
}