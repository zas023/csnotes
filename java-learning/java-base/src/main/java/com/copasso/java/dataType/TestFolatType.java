package com.copasso.java.dataType;

/*
*浮点数类型
*/
public class TestFolatType{

	public static void main(String[] args) {
		double d = 3.14;  //浮点类型默认double
		double d2=314e-2;  //科学记数法

		//float f = 3.14;  //报错
		float f = 3.14F;

		float f1=0.1f;
		double d1=1.0/10;
		//避免在比较中使用浮点数
		System.out.println(f1==d1);  //输出false，因为浮点数有误差
	}
}


/*浮点型：
1. float类型又称单精度类型，位数可精确到7位有效数字，很多情况下难以满足需求
2. double类型精确度是float的两倍，又称双精度浮点数，绝大多数程序采用double

*/

//float的范围为-2^128 ~ +2^128，也即-3.40E+38 ~ +3.40E+38；
//double的范围为-2^1024 ~ +2^1024，也即-1.79E+308 ~ +1.79E+308。

//浮点数默认为double类型，要将其变为float,需要在后面加"f"或"F"

//浮点数存在舍入误差，很多数不能被精确表示
//如需产生精确的浮点数，需要使用BigDecimal类。

//避免在比较中使用浮点数