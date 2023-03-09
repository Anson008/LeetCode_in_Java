package dsa.Sort;

public class LC215 {
    public int findKthLargest(int[] nums, int k){
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k){
        int pivot = partition(nums, left, right);
        final int count = pivot - left + 1;
        if (count == k)
            return nums[pivot];
        if (count > k)
            return quickSelect(nums, left, pivot - 1, k);
        return quickSelect(nums, pivot + 1, right, k - count);

    }

    private int partition(int[] nums, int left, int right){
        final int pivotIdx = getRandomPivotIndex(left, right);
        swap(nums, pivotIdx, right);
        final int pivot = nums[right];

        int wall = left;
        for (int i = left; i < right; i++){
            if (nums[i] >= pivot)
                swap(nums, wall++, i);
        }
        swap(nums, wall, right);
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
