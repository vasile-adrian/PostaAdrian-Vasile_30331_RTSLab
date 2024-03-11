package Exercise2;

public class Main {

    public static void main(String[]Args){
        int [][]R1 = {
                {2,3,1},
                {7,1,6},
                {9,2,4}
        };
        int [][]R2 = {
                {8,5,3},
                {3,9,2},
                {2,7,3}
        };
        System.out.println("Addition result: ");
        printMatrix(add(R1,R2));
        System.out.println();
        System.out.println("Multiplication result: ");
        printMatrix(mult(R1,R2));
    }

    public static int[][] add(int[][]R1, int[][]R2){
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                R1[i][j] += R2[i][j];
            }
        }
        return R1;
    }

    public static int[][] mult(int[][]R1, int[][]R2) {
        int [][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
                for(int k=0;k<3;k++){
                    result[i][j] += R1[i][k]*R2[k][j];
                }
            }
        }
        return result;
    }

    static void printMatrix(int[][]r){
        for (int i=0;i<3;i++){
            for (int j=0; j<3;j++){
                System.out.print(r[i][j]+", ");
            }
            System.out.println();
        }

    }

}
