/**
*题目描述：
*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
*例如，如果输入如下矩阵： 
*1  2  3  4 
*5  6  7  8 
*9  10 11 12 
*13 14 15 16 
*则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/

import java.util.ArrayList;
public class Solution {

    //每次打印第一行，然后删除第一行并逆时针转动
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(null==matrix)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        //循环代替递归
        while (row != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            if (row == 1)
                break;
            matrix = turn(matrix);
            row = matrix.length;
        }
        return list;
    }

    //数组逆时针旋转90°
    private int[][] turn(int[][] matrix) {

        int col = matrix[0].length;
        int row = matrix.length;
        int[][] newMatrix = new int[col][row - 1];
        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col-j-1][i-1] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        int [][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list =s.printMatrix(matrix);

        for (int i:list) 
            System.out.print(i+" ");
    }
}