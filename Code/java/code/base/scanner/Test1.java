import java.util.*; 
import java.math.*;

public class Test1 {

	public boolean Find(int [][] array,int target) {
		int row=0;
		int col=array[0].length-1;
		while(row<=array.length-1&&col>=0){
			if(target==array[row][col])
				return true;
			else if(target>array[row][col])
				row++;
			else
				col--;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] points =new int[2*n][4];
        for(int i = 0; i < 2*n; i++){
            for(int j = 0; j < 4; j++){
                points[i][j]=sc.nextInt();
            }
        } 

        int[][] edges =new int [n][3];
        for(int i = 0; i <n; i++){
            for(int j = 1; j < 4; j++){
                int x=points[2*i][j]-points[2*i][0];
                int y=points[2*i+1][j]-points[2*i+1][0];
                edges[i][j-1]=(x*x+y*y);
            }
        }
        int max=0,sum=0;
        for(int i = 0; i <n; i++){
            for(int j = 0; j < 3; j++){
                if(edges[i][j]>max)
                	max=edges[i][j];
                sum+=edges[i][j];
            }
            int avg=(sum-max)/2;
            if((2*avg)!=(sum-max))
            	System.out.println("No");
            else{
            	if(edges[i][0]==avg)
            		System.out.println("Yes");
            	else{
            		if(edges[i][1]==avg)
            			System.out.println("Yes");
            		else
            			System.out.println("No");
            	}
            }

            max=0;
            sum=0;
        }


	}
}
