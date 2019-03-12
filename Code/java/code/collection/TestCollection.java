import java.util.*;
/**
*容器
*/
public class TestCollection{

	public static void main(String[] args) {
		Collection c;
	}
}

/*容器：

1. Collection表示一组对象，它是集中、收集的意思，就是把数据收集起来
2. Collection函数库是在java.util包下的一些接口和类。接口是访问数据的方式，类用来存放数据
3. Collection和数组的区别：
   3.1 数组的容量是有限制的，而Collection的容量没有这些限制，可以自动调节
   3.2 Collection函数库只能用来存放对象，而数组没有这样的限制
4. Collection接口是Collection层次结构中的根接口，它定义了一些最基本的访问方式，让我们通过它或它的子接口
   来访问数据
5. Collection代表一组对象，Collection函数库是Java中的集合框架，Collection接口是这个框架中的根接口
6. 存放的Collection中的数据，被称作元素。

*/

/*API-接口

1. Collection
   1.1 Set  :无序不可重复
       1.1.1 HashSet
   1.2 List :有序可重复，有序（ordered）代表有顺序存放，区别sorted

2. Map ：键值对
   1.1 HashMap

*/

//empty与null、remove与delete的区别