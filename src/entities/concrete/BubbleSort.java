package entities.concrete;
import entities.abstracts.Strategy;

public class BubbleSort implements Strategy {

    public Double[] sortEntities(Double[] arr) {

        int i, j, n = arr.length;
        boolean swap;
        Double temp;
        for (i = 0; i < n - 1; ++i) {

            swap = false;
            for (j = 0; j < n - i - 1; ++j) {

                if (arr[j] < arr[j + 1]) {

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