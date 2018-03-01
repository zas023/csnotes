import java.util.*;

/**
*Iterator :迭代器
*/
public class TestIterator{

	public static void main(String[] args) {
		Set set=new HashSet();

		set.add("张三");
		set.add("李四");
		set.add("王婆");

		Iterator iter=set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}

/*Iterator

1. 所有实现了Collection接口的容器类都实现了一个iterator方法以返回一个
   实现了Iterator接口对象

2. Iterator对象称作迭代器，用于方便对容器内元素的遍历

3. Iterator接口定义如下方法：
   3.1 boolen hasNext();  //判断是否有元素没有被遍历
   3.2 Object next();     //返回游标当前的元素，并将游标移向下一个位置
   3.3 void remove();     //删除游标左面的元素，在执行完next之后
                          //该方法只能执行一次(只能移除刚刚遍历的那个对象，有个标志lastRet)

*/

//使用迭代器后不能使用Collection的remove,因为调用自己的remove后无法更新或调整迭代器当前位置