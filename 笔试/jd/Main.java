import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(k);
    }
}

// public class Main {
//     public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//         int size = sc.nextInt();
//         for(int i = 0; i < size; i++){
//             int n=0,x=0,y=0;
//             n=sc.nextInt();
//             for(int k=1;k<n;k+=2){
//                 y=n/k;
//                 if((y%2)==0&&(y!=1)&& (k*y)==n)
//                     x=k;
//             }
//             if(x==0)
//                 System.out.println("No");
//             else
//                 System.out.println(x+" "+n/x);
//         }
//         // for(int i = 0; i < size; i++){
//         //     int n=0,x=0,y=0;
//         //     n=num[i];
//         //     for(int k=1;k<n;k+=2){
//         //         y=n/k;
//         //         if((y%2)==0&&(y!=1)&& (k*y)==n)
//         //             x=k;
//         //     }
//         //     if(x==0)
//         //         System.out.println("No");
//         //     else
//         //         System.out.println(x+" "+n/x);
//         // }
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int count=0;
//         for(int i = 0; i < n; i++){
//             String str=sc.next();
//             String[] strs=str.split(":");
//             if(strs[0].equals(strs[1]))
//                 count++;
//             else if((strs[0].charAt(0)==strs[0].charAt(1))&&(strs[1].charAt(0)==strs[1].charAt(1)))
//                 count++;
//             else if((strs[0].charAt(0)==strs[1].charAt(1))&&(strs[0].charAt(1)==strs[1].charAt(0)))
//                 count++;
//         } 

//         System.out.println(count);
//     }
// }