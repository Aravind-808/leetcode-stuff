
class NumMatrix {

    int[][] prefixmat;
    public NumMatrix(int[][] matrix) {

        // define 2d prefix matrix dims
        int n = matrix.length;
        int m = matrix[0].length;

        this.prefixmat = new int[n][m];

        for(int i = 0;i<n;i++){
            // init prefix for current row
            int prefix = 0;

            for(int j = 0;j<m;j++){
                prefix = matrix[i][j];

                if(i>0){
                    prefix+=prefixmat[i-1][j]; // add prev row's sum
                }

                if(j>0){
                    prefix+=prefixmat[i][j-1]; // add prev column's sum
                }

                if(i>0 && j > 0){
                    prefix -= prefixmat[i-1][j-1]; // subtract overlapping value 
                }

                prefixmat[i][j] = prefix;
            }

        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = prefixmat[row2][col2];

        // the formula to get the sum of a given submatrix (r1, c1, r2, c2) is:
        // sum = mat[r2][c2] - mat[r2][c1-1] - mat[r1-1][c2] + mat[r1-1][c1-1] (adding the last one bc its subtracted twice)
        // this is called the inclusion exclusion principle

        if(col1 > 0) res-= prefixmat[row2][col1-1];
        if(row1 > 0) res-= prefixmat[row1-1][col2];
        if(row1 > 0 && col1 > 0) res+=prefixmat[row1-1][col1-1];
        
        return res ;

    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // 12
    }
}
