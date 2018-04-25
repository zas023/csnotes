/**
求两个已排序数组的中位数
*/
#include <iostream>
#include <vector>
using namespace std;

double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int m=nums1.size();
    int n=nums2.size();
    vector<int> a;
    int i=0,j=0;
    while(true){
        if(i<m){
            if(j<n){
                if(nums1[i]<=nums2[j]){
                    a.push_back(nums1[i++]);
                }
                else{
                    a.push_back(nums2[j++]);
                }
            }else{
               a.push_back(nums1[i++]); 
            }
        }else if(j<n){
            a.push_back(nums2[j++]);
        }else{
            break;
        }
    }
    if((m+n)%2==0){
        return (double)(a[(m+n)/2]+a[(m+n)/2-1])/2.0;
    }
    return (double)a[(m+n)/2];
}

int main() {
    vector<int> n1;
    vector<int> n2;
    n1.push_back(1);
    n1.push_back(2);
    n2.push_back(1);
    n2.push_back(2);
    cout << findMedianSortedArrays(n1,n2);
}