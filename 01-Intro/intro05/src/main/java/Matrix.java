public class Matrix {
    public int[][] generateMatrix(int r) {
        int[][] res = new int[r][r];
        for(int i = 0; i < r; i++){
            res[i][i] = 1;
            res[i][r-i-1] = 1;
        }
        return res;
    }
}
