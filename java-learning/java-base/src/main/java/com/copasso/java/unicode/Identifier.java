package com.copasso.java.unicode;

/*
*测试标识符
*/
public class Identifier{
	public static void main(String[] args) {
		int a=1;
		int _a=2;
		int $a=3;
		int $=3;

		//int 123a = 1;
		//int a# = 1;

		int 汉字=1;

		System.out.println(a);
	}
}

/*命名规则：
1.标识符必须以字母、下划线、美元符开头
2.标识符其他部分可以是字母、下划线、美元符、数字的任意组合
3.Java标识符大小敏感，且长度无限制
4.不可是Java关键字
*/

//注：Java不采用常用的ASCII字符集，而采用的unicode这样的标准的国际通用字符集
//    即上处的字母表示英文和汉字等等；

/*字符集：
1. ISO8859-1 西欧字符集
2. BIG5 台湾大五码，表示繁体汉字
3. GB2312 大陆最早、最广的简体中文字符集
4. GBK GB2312的扩展，可以表示繁体汉字
5. GB18030 GBK的扩展，可以表示汉字、维吾尔文、藏文等中华名族字符集
6. Unicode 国际通用字符集
*/