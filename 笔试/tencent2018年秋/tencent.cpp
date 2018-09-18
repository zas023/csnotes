#include <iostream>
using namespace std;
int main() {
	int n,num,a;
    cin>>n;    //获取用例数

    //处理每次用例
    while(n>0){
    	cin>>num;    //获取木棍数
    	int s[num];
    	for (int i = 0; i < num; ++i)
    	{
    		cin>>a;
    		s[i]=a;
    	}

    	//先排序
    	for (int i = 0; i < num-1; ++i)
    	{
    		for (int j = 0; j < num-i-1; ++j)
    		{
    			if(s[j]>s[j+1])
    			{
    				int t=s[j+1];
    				s[j+1]=s[j];
    				s[j]=t;
    			}
    		}
    	}

    	int count=0;  //计数三角形个数

    	//遍历穷举
    	for (int i = 0; i < num; ++i)
    	{
    		for (int j = i+1; j < num; ++j)
    		{
    			for (int k = j+1; k < num; ++k)
    			{

    				if ((s[i]+s[j])>s[k])
    				{
    					count++;
    				}
    			}
    		}
    	}

    	cout<<count<<endl;

    	n--;

    }


    // int s[6]={10,16,87,43,51,75};
    // num=6;

}