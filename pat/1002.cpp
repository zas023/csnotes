/* 数字分类

题目描述
给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：

A1 = 能被5整除的数字中所有偶数的和；

A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；

A3 = 被5除后余2的数字的个数；

A4 = 被5除后余3的数字的平均数，精确到小数点后1位；

A5 = 被5除后余4的数字中最大数字。

输入描述:
每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。


输出描述:
对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。

若其中某一类数字不存在，则在相应位置输出“N”。

输入例子:
13 1 2 3 4 5 6 7 8 9 10 20 16 18

输出例子:
30 11 2 9.7 9
*/

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int n;
	cin>>n;

	int num;
	int a[5]={0},nums[5]={0};
	for (int i = 0; i < n; i++)
	{
		cin>>num;
		if (num%5==0 && num%2==0){
			a[0]+=num;
			nums[0]++;
		}
		else if (num%5==1)
		{
			if (nums[1]%2==0)
				a[1]+=num;
			if (nums[1]%2==1)
				a[1]-=num;
			nums[1]++;
		}
		else if (num%5==2)
		{
			a[2]+=1;
			nums[2]++;
		}
		else if (num%5==3)
		{
			a[3]+=num;
			nums[3]++;
		}
		else if (num%5==4)
		{
			if(num>a[4])
				a[4]=num;
			nums[4]++;
		}


	}

	for (int i = 0; i < 5; i++)
	{
		if (nums[i]==0)
		{
			cout<<"N"<<" ";
		}else{
			if(i==3)
				cout<<fixed<<setprecision(1)<<(a[3]*1.0/nums[3])<<" ";
			else if(i==4)
				cout<<a[i];
			else
				cout<<a[i]<<" ";
		}
	}

	return 0;
}