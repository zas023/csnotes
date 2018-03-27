import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=0,k=0,count=0;
        n = in.nextInt();
        k = in.nextInt();

        for(int i=k;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.println(i+","+j+","+(i%j>=k));
                if(i%j>=k)
                    count++;
            }
        }
        System.out.println(count);
    }
}