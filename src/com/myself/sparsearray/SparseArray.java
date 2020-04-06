package com.myself.sparsearray;

/**
 * @Description: TODO
 * @Author: wanghailin
 * @Date: 2020/3/24
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for(int[] row: chessArr1){
            for(int data: row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for(int[] row: chessArr1){
            for(int data: row){
                if(data!=0){
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //count 用于记录是第几个非0数据
        int count = 1;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");

        for(int[] row: sparseArr){
            for(int data: row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        //将稀疏数组 --》 恢复成 原始的二维数组
        /*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }



    }

}
