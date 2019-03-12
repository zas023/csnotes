/*A除以B (20)

题目描述
本题要求计算A/B，其中A是不超过1000位的正整数，B是1位正整数。你需要输出商数Q和余数R，使得A = B * Q + R成立。

输入描述:
输入在1行中依次给出A和B，中间以1空格分隔。


输出描述:
在1行中依次输出Q和R，中间以1空格分隔。

输入例子:
123456789050987654321 7

输出例子:
17636684150141093474 3
*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
	string a;    //被除数
	int b,q,r;    //除数、商和余数

	cin>>a>>b;

	int length=a.size();

	//特殊情况
	if (length==1){
		cout<<(a[0]-'0')/b<<" "<<(a[0]-'0')%b;
		return 0;
	}

    //先用前两位去除，演算除法规则
	int temp = 10*(a[0]-'0')+(a[1]-'0');

	for (int i = 0; i < length-1; ++i){

		q=temp/b;
		r=temp%b;
		temp=r*10+(a[i+2]-'0');

		cout<<q;
	}

	cout<<" "<<r;

	return 0;
}