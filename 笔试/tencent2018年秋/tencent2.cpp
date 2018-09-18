#include <iostream>
using namespace std;
int main() {
	int num,value,c;
    cin>>num;

    int array[num],sort[num];
    for (int i = 0; i < num; ++i)
    {
        cin>>value;
        array[i]=value;
        sort[i]=value;
    }

    cin>>c;

    //先排序
    for (int i = 0; i < num-1; ++i)
    {
        for (int j = 0; j < num-i-1; ++j)
        {
            if(sort[j]>sort[j+1])
            {
                int t=sort[j+1];
                sort[j+1]=sort[j];
                sort[j]=t;
            }
        }
    }

    for (int i = 0; i < c; ++i)
    {
        int temp=sort[i];
        if(temp>=0)
            break;

        for (int i = 0; i < num; ++i)
        {
            if (array[i]==temp)
            {
                array[i]=(-temp);
                break;
            }
        }
    }

    int sum = array[0];
    int currentMax = array[0];
    for (int i = 1; i < num; i++)
    {
        if(currentMax < 0)
            currentMax = array[i];
        else
            currentMax = currentMax + array[i];

        if(currentMax > sum)
        {
            sum = currentMax;
        }
    }

    cout<<sum;

}