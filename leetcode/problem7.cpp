/**
反转x
*/
#include <iostream>
#include <vector>
using namespace std;

int reverse(int x) {
    int result=0;
    int temp;
    while( x != 0){
        temp = x%10;
        if (result > INT_MAX/10 || result < INT_MIN/10){
             return 0;
        }
        result = result*10 + temp;
        x =x/10;
    }
    return result;
}

int main() {
    cout << reverse(123);
}