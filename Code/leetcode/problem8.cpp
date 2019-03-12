/**
Implementatoito convert a string to an integer.

Hint:Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes:It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
实现atoi
*/

#include <iostream>
#include <string>
using namespace std;

int myAtoi(string str) {
    int result = 0, sign = 1, i = str.find_first_not_of(' '), base = INT_MAX / 10;
    if (str[i] == '+' || str[i] == '-') sign = str[i++] == '+' ?: -1;
    while (isdigit(str[i])) {
        if (result > base || (result == base && str[i] - '0' > 7)) 
            return sign > 0 ? INT_MAX : INT_MIN;
        result = 10 * result + (str[i++] - '0');
    }
    return sign * result;
}

int main() {

    cout << myAtoi("-023");
}