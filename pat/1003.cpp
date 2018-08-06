/*数素数

题目描述
令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。

输入描述:
输入在一行中给出M和N，其间以空格分隔。


输出描述:
输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。

输入例子:
5 27

输出例子:
11 13 17 19 23 29 31 37 41 43

47 53 59 61 67 71 73 79 83 89

97 101 103
*/

#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(int n);

int main()
{
	int  M, N;
	cin>>M>>N;

	int count=0, times=0;

	//穷举
	for (int i = 1; ; ++i)
	{
		if(isPrime(i)){
			times++;
			//计数，且判断是否为第M到第N个之间
			if (times>=M&& times<=N)
			{
				if(count!=0){
					cout<<" ";
				}
				cout<<i;
				count++;
				//10个换行
				if (count==10){
					cout<<"\n";
					count=0;
					continue;
				}
			}else if(times>N){
				break;
			}
		}
	}

	return 0;
}
//判断输入的正整数是否为素数
bool isPrime(int n)
{
	if (n==1)
		return false;
	if (n==2||n==3)
		return true;
	for (int i = 2; i <=sqrt(n); ++i)
	{
		if (n%i==0)
			return false;
	}

	return true;
}