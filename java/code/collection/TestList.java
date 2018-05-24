import java.util.*;
/**
*List：列表
*/
public class TestList{

	public static void main(String[] args) {

		//建议使用List声明而非实现类，如ArrayList，便于以后替换

		List list=new ArrayList();  //内部是一个Object[]数组

		list.add(new Date());
		list.add(123);  //包装类，自动装箱

		System.out.println(list.size());

		List list2=new ArrayList();
		list2.add("1");
		list2.add("2");

		list.add(list2);

		System.out.println(list.size());

		list.remove(new Date());  //hashcode和equals判断相等,成功移除
		System.out.println(list);
	}
}

//List默认大小是10个元素

/*
ArrayList : 底层是数组，查询块，修改慢，线程不安全，效率高
LinkedList: 底层是链表，查询满，修改快，线程不安全，效率高
Vector : 底层是数组, 线程安全，效率低

*/