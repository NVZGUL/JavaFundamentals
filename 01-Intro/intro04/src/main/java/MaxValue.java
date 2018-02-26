public class MaxValue {
    private double[] arr;
    MaxValue(int n) {
        arr = new double[2*n];
    }
    public double findMax() {
        int left = 0;
        int right = arr.length - 1;
        double max = arr[left] + arr[right];
        while (left < right) {
            if (arr[left] + arr[right] > max) {
                max = arr[left] + arr[right];
            }
        }
        return max;
    }
}
