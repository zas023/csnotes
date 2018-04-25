/**
Determine whether an integer is a palindrome. Do this without extra space.
判断是否是回文
*/ 
#include <iostream>
#include <string>
#include <sstream>
using namespace std;

bool isPalindrome(int x) {

	stringstream ss;
    string str;
    ss<<x;
    ss>>str;

	int n=str.length();
	for(int i=0;i<n;i++){
		if (str[i]!=str[n-i-1])
		{
			return false;
		}
	}

	return true;
}

int main() {

    cout << isPalindrome(1221);
}