package week8;

import org.junit.Test;

public class Practice2_PascalTriangle {

    /*
           1            (1,1)
          1 1           (2,1) (2,2)
         1 2 1          (3,1) (3,2) (3,3)
        1 3 3 1         (4,1) (4,2) (4,3) (4,4)

        col = 1 and col=row

        (row-1, col-1) + (row-1 + col)

     */

    @Test
    public void example1(){
        printPascalTriangle(5);
    }

    private void printPascalTriangle(int n){
        for(int row=1; row<=n; row++){
            for(int column=1; column<=row; column++){
                System.out.print(pascalTriangle(row,column));
            }
            System.out.println();
        }

    }

    private int pascalTriangle(int row, int column){
        if(column == 1 || column == row) return 1;
        return pascalTriangle(row-1,column) + pascalTriangle(row-1,column-1);
    }

}
