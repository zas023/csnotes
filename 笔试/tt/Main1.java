import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int c=in.nextInt();
            // int[] array=new int[c];
            for (int j=0;j<c ;j++ ) {
                int val=in.nextInt();
                if(j==0)
                    System.out.println(val);
            }
        }
    }
}