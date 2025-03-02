import java.util.*;

public class twoDArray{

    public static void search(int [][]matrix, int item){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == item){
                    System.out.println("Item found at index: " + i + " " + j);
                    return;
                }
            }
        }
        System.out.println("Item not found");
    }

    public static void spiral(int [][]matrix){
        int firstRow = 0;
        int firstCol = 0;
        int lastRow = matrix.length-1;
        int lastCol = matrix[0].length-1;

        while(firstRow <= lastRow && firstCol <= lastCol){

            //top
            for(int i=0; i<=lastCol; i++){
                System.out.print(matrix[firstRow][i] + " ");
            }

            //right
            for(int i=firstRow+1; i<=lastRow; i++){
                System.out.print(matrix[i][lastCol] + " ");
            }

            //bottom
            for(int i=lastCol-1; i>=firstCol; i--){
                if(firstRow == lastRow){
                    break;
                }
                System.out.print(matrix[lastRow][i] + " ");
            }

            //left
            for(int i=lastRow-1; i>=firstRow; i--){
                if(firstRow == lastRow){
                    break;
                }
                System.out.print(matrix[i][firstCol] + " ");
            }


            firstRow++;
            firstCol++;
            lastRow--;
            lastCol--;
        }
    }

    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        int matrix[][] = new int[4][4];
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // search(matrix, 5);
        spiral(matrix);
    }
}
