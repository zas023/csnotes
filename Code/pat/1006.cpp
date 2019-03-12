/*部分A+B (15)

题目描述
正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。
 
 现给定A、DA、B、DB，请编写程序计算PA + PB。

输入描述:
输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 1010。


输出描述:
在一行中输出PA + PB的值。

输入例子:
3862767 6 13530293 3

输出例子:
399
*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
	string str1,str2;    //直接按照字符串类型接收
	int n1,n2;
	long long num1=0,num2=0;    //别忘了初始化

	cin>>str1>>n1>>str2>>n2;

	for (int i = 0; i < str1.size(); ++i){
		if (str1[i]-'0'==n1)    //字符转整型
			num1=num1*10+(str1[i]-'0');
	}

	for (int i = 0; i < str2.size(); ++i){
		if (str2[i]-'0'==n2)
			num2=num2*10+(str2[i]-'0');
	}

	cout<<num1+num2<<endl;

	return 0;
}