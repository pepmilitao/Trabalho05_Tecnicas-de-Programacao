package tools.concretes;
import tools.abstracts.Strategy;

public class HeapSort implements Strategy {

   // Método destinado à criação e manutenção da propriedade Heap de máximo
   private void Heap (Double[] arr, int head, int size) {

      // Definindo variáveis de apoio
      int l = 2 * head + 1;
      int r = 2 * head + 2;
      int max = head;
      Double temp;

      // Caso l >= size, então o índice observado não está no array, logo, não deve ser considerado
      // Caso l < size e arr[l] <= arr[max], então o elemento de índice l não é maior de todos os verificados
      if (l < size && arr[l] > arr[max]) {

         // O filho esquerdo é o maior dentre ele mesmo e o elemento considerado o maior de todos os verificados
         max = l;
      }

      // Para r, os casos são análogos
      if (r < size && arr[r] > arr[max]) {

         max = r;
      }

      // Se necessário, a troca de elementos é feita
      if (max != head) {

         temp = arr[head];
         arr[head] = arr[max];
         arr[max] = temp;

         // Como a chave de um dos filhos diminuiu, é possível que a propriedade Heap foi quebrada nos maiores índices
         Heap(arr, max, size);
      }
   }

   // Implementação do método da interface Strategy
   public Double[] sortEntities(Double[] arr) {

      int n = arr.length;

      // Heap é criado em arr
      for (int i = n / 2 - 1; i >= 0; --i) {

         Heap(arr, i, n);
      }

      // Operação do HeapSort
      Double temp;
      for (int i = n - 1; i > 0; --i) {

         // Para cada iteração, o maior elemento vai ser trocado com o elemento da posição i
         // Isso será feito até i = 0, já que isso indica que o Heap possui apenas 1 elemento
         temp = arr[i];
         arr[i] = arr[0];
         arr[0] = temp;
         
         // Operação de manutenção da propriedade Heap para obtenção do próximo elemento
         Heap(arr, 0, i);
      }

      return arr;
   }
}