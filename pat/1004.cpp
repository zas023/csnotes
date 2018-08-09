/*福尔摩斯的约会 

大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很

 快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是

 第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、

 以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，

 请帮助福尔摩斯解码得到约会的时间。

输入描述:
输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。


输出描述:
在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期

四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。

输入例子:
3485djDkxh4hhGE

2984akDfkkkkggEdsb

s&hgsfdk

d&Hyscvnm

输出例子:
THU 14:04
*/

#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

int main()
{
	int flag=0;
	int day=0,hour=0,time=0;
	char str1[70],str2[70],str3[70],str4[70];
	gets(str1);
	gets(str2);
	gets(str3);
	gets(str4);

	int len=strlen(str1);
	int len1=strlen(str2);

	for(int i=0;i<len&&i<len1;++i){
		if((str1[i]>='A'&&str1[i]<='G')&&str1[i]==str2[i]&&flag==0){
			flag=1;
			day=str1[i]-'A'+1;
		}
		else if(flag==1&&str1[i]==str2[i]&&((str1[i]>='0'&&str1[i]<='9')
			||(str1[i]>='A'&&str1[i]<='N'))){

			if(str1[i]>='0'&&str1[i]<='9')
				hour=str1[i]-'0';
			else if(str1[i]>='A'&&str1[i]<='N')
				hour=str1[i]-'A'+10;
			break;
		}
	}

	len=strlen(str3);
	len1=strlen(str4);
	for(int i=0;i<len&&i<len1;++i){
		if(str3[i]==str4[i]){
			if((str3[i]>='a'&&str3[i]<='z')||(str3[i]>='A'&&str3[i]<='Z')){
				time=i;
				break;
			}
		}
	}
	switch(day){
		case 1:printf("MON ");break;
		case 2:printf("TUE ");break;
		case 3:printf("WED ");break;
		case 4:printf("THU ");break;
		case 5:printf("FRI ");break;
		case 6:printf("SAT ");break;
		case 7:printf("SUN ");break;
	}

	printf("%02d:%02d\n",hour,time);

	return 0;
}