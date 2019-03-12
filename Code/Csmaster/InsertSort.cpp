#include <iostream>

using namespace std;

//define 直接插入排序
void insort1(int a[] , int n);

//define 折半插入排序
void insort2(int a[] , int n);

//define 希尔排序
void shellsort(int a[], int n);

//define 输出函数
void printArray(int a[],int n);

int main(int argc, char const *argv[])
{
	int a[6]={4,2,3,1,5,6};

	printArray(a,6);

	// insort1(a,6);

	// insort2(a,6);

	shellsort(a,6);

	printArray(a,6);

	return 0;
}

//直接插入排序
void insort1(int a[] , int n){
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

		printArray(a,n);
	}
}


//折半插入排序
void insort2(int a[] , int n){
	int i,j,temp,low,high,mid;
	for (i = 1; i < n; ++i)    //以此将a1-an插入到前面已排好的序列
	{

		temp=a[i];
		low=0;
		high=i-1;

		while(low<=high){

			mid=(low+high)/2;

			if (a[mid]>temp)
				high=mid-1;
			else
				low=mid+1;
		}

		for (int j=i; j>high+1; --j)
			a[j]=a[j-1];

		a[high+1]=temp;

		printArray(a,n);
	}
}


/**
直接插入排序每趟进行了两项工作，
一是从前面已排序子表中查找待插元素的位置
二是给待插元素腾出位置，该算法中是边比较，边移动元素。

折半插入排序通过折半查找插入到已排序的序列的适当位置。

不难看出折半法仅仅减少了比较的次数，约O(nlogn)，而移动次数不变O(n^2)

二者均是稳定的排序方法
*/

//希尔排序(缩小增量排序)
void shellsort(int a[], int n){
	int i,j,dk,temp;
	for (dk=n/2; dk>=1; dk=dk/2)
	{
		//对增量子表进行直接插入排序
		for (i = dk; i < n; ++i)
		{
			if (a[i]<a[i-dk])    //需要将ai插入有序增量子表
			{
				temp=a[i];
				for (j=i-dk; j>=0&&temp<a[j]; j=j-dk)
					a[j+dk]=a[j];

				a[j+dk]=temp;
			}
		}

		printArray(a,n);
	}
}

/** https://www.cnblogs.com/chengxiao/p/6104371.html

把记录按步长 gap 分组，对每组记录采用直接插入排序方法进行排序。
随着步长逐渐减小，所分成的组包含的记录越来越多，
当步长的值减小到 1 时，整个数据合成为一组，构成一组有序记录，则完成排序。

其最坏时间复杂度依然为O(n2)，
经过优化的增量序列如Hibbard经过复杂证明可使得最坏时间复杂度为O(n3/2)。

希尔排序不稳定，且比较次数和移动次数都要比直接插入排序少，当N越大时，效果越明显。   
*/


//输出函数
void printArray(int a[],int n)
{
	for (int i = 0; i < n; ++i)
		cout<<a[i]<<" ";
	cout<<endl;
}


