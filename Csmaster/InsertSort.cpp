#include <iostream>

using namespace std;

//define 直接插入排序
void insert1(int a[] , int n);
//define 输出函数
void printArray(int a[],int n);

int main(int argc, char const *argv[])
{
	int a[6]={4,2,3,1,5,6};

	printArray(a,6);

	insert1(a,6);

	printArray(a,6);

	return 0;
}

//直接插入排序
void insert1(int a[] , int n){
	int i,j,temp;    //非c++11标准不允许for循环类声明变量
	for (i = 1; i < n; ++i)    //以此将a1-an插入到前面已排好的序列
	{
		if (a[i]<a[i-1])    //关键字小于前驱，则需要向前插入
		{
			temp=a[i];

			for (j = i; j>0 && temp<a[j-1] ; j--)    //从后向前查找插入的位置
				a[j]=a[j-1];    //顺序后移

			a[j]=temp;    //找到位置并插入
		}
	}
}


//输出函数
void printArray(int a[],int n)
{
	for (int i = 0; i < n; ++i)
		cout<<a[i]<<" ";
	cout<<endl;
}