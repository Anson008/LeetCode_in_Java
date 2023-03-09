import dsa.Sort.LC215;

public class HelloAlgorithm {
    public static void main(String[] args){
        int[] arr1 = {12, 4, 576, -1, -90, 0, 78};
        LC215 solution = new LC215();
        System.out.println(solution.findKthLargest(arr1, 3));
    }
}
