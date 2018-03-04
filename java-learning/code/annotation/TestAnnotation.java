
/**
*Annotation:注解
*/
public class TestAnnotation /*extends Object */{

	@Override
	public String toString(){
		return "TestAnnotation";
	}

	//错误: 方法不会覆盖或实现超类型的方法
	// @Override
	// public String tostring(){
	// 	return "TestAnnotation";
	// }

	public static void main(String[] args) {
		
	}
}

/*Annotation:

1. Annotation是JDK5.0开始引入的技术
   - 本事程序本身，可以对程序做出解释（这一点上和注释没有区别）
   - 可以被其他程序读取（如：编译器），注解信息处理流程是注解与注释的最大区别。

2. 注解是以"@注释名" 在代码中，还可以添加一些数据，如：@SuppressWarnings(value="all");

3. 注解可以附加在package、class、method、field等上，相当于给它们添加额外的辅助信息，
   我们可以通过反射机制编程实现对这些元数据的访问。

*/