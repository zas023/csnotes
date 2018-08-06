#include <stdio.h>

int main (){
    int A1=0,A2=0,A3=0,A5=0,n;
    int N,i,v=0;
    float A4=0,u=0,w=0;//A4
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&N);
        if(N%5==0&&N%2==0)
            A1+=N;
 
        if(N%5==1){
            v+=1;
            if(v%2==1)
                A2+=N;
            else
                A2-=N;
        }
        if(N%5==2)
            A3=A3+1;
        if(N%5==3)
        {
            w=w+1;
            u=u+N;
            A4=u/w;
        }
        if(N%5==4&&N>A5)
        {
            A5=N;
        }
    }
    if(A1!=0)
        printf("%d ",A1);
    else
        printf("%s ","N");
    if(A2!=0)
        printf("%d ",A2);
    else
        printf("%s ","N");
    if(A3!=0)
        printf("%d ",A3);
    else
        printf("%s ","N");
    if(A4!=0)
        printf("%.1f ",A4);
    else
        printf("%s ","N");
    if(A5!=0)
        printf("%d",A5);
    else
        printf("%s","N");
 
}