package dsa.Math;

public class LC231 {
    public boolean isPowerOfTwo(int n) {
        while (n > 1){
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return n == 1;
    }

    public void runTest(int n){
        System.out.println(isPowerOfTwo(n));
    }
}
