package tools.concretes;
import tools.abstracts.Strategy;

public class BubbleSort implements Strategy {

    // Implementação do método da interface Strategy
    public Double[] sortEntities(Double[] arr) {

        // Definindo variáveis de apoio
        int i, j, n = arr.length;
        boolean swap;
        Double temp;

        // Verificando todos os elementos do array, do menor ao maior índice
        for (i = 0; i < n - 1; ++i) {

            swap = false; // Se não acontecer troca de elementos, então o array já está ordenado

            for (j = 0; j < n - i - 1; ++j) {

                // Para cada elemento do array, se ele for maior do que seu sucessor, então eles deverão ser trocados de posição
                if (arr[j] > arr[j + 1]) {

                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }

            if (!swap) break;
        }

        return arr;
    }
}