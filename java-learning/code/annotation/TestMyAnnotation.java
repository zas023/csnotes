import java.lang.annotation.*;
/**
*自定义注解
*/
@MyAnnotation
public class TestMyAnnotation{

	//@MyAnnotation //错误: 注释类型不适用于该类型的声明
	public static void main(String[] args) {
		System.out.println("TestMyAnnotation.main");
	}
}

@Target(ElementType.TYPE)  
@interface MyAnnotation /* extends Annotation */{
	String value() default "";   
}
/*
1. 使用 @interface 自定义注解，自动继承java.lang.annotation.Annotation接口

2. 要点：
   - 注解的每一个方法其实是声明一个参数
     方法名就是参数名，返回类型只能是基本类型、Class、String、enum，可以通过default声明参数默认值。

*/ 