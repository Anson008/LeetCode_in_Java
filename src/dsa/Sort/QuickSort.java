package dsa.Sort;


public class QuickSort {

    public int[] sort(int[] array){
        helper(array, 0, array.length - 1);
        return array;
    }

    private void helper(int[] array, int left, int right){
        if (left >= right)
            return;

        int pivot = partition(array, left, right);
        helper(array, left, pivot - 1);
        helper(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right){
        int pivotIdx = getRandomPivotIndex(left, right);
        swap(array, pivotIdx, right);
        int pivot = array[right];
        int wall = left;
        for (int i = left; i < right; i++){
            if (array[i] < pivot){
                swap(array, i, wall);
                wall++;
            }
        }
        swap(array, wall, right);
        return wall;
    }

    private int getRandomPivotIndex(int left, int right){
        return left + (int)(Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
