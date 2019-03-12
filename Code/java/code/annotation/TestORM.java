import java.lang.annotation.*;
import java.lang.reflect.*;
import java.io.*;

/**
*ORM：Object Relationship Mapping
*/
public class TestORM{

	public static void main(String[] args) {
		
		//通过反射获取注解信息
		try{

			Class cl=Class.forName("Student");

			Annotation[] annotations=cl.getAnnotations();

			for (Annotation a:annotations ) {
				System.out.println(a);
			}

			Field f=cl.getDeclaredField("name");
			DBField dbFiled=(DBField) f.getAnnotation(DBField.class);
			System.out.println(dbFiled.name()+"--"+dbFiled.type()+"--"+dbFiled.length());


		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

@DBTable("Student")
class Student{

	@DBField(name="id",type="int",length=8)
	int id;

	@DBField(name="name",type="varchar",length=10)
	String name;

	@DBField(name="age",type="int",length=3)
	int age;
}

//表名注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DBTable {
	String value();   
}

//字段注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface DBField {
	String name();   
	String type();
	int length();
}


/*ORM

类和表的结构对应
属性和字段对应
对象和记录对应

*/