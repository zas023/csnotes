import java.util.*;
/**
*Set：集合（数学意义上）
*/
public class TestSet{

	public static void main(String[] args) {
		Set set=new HashSet();
		set.add("a");
		set.add(new String("a"));

		System.out.println(set.size());  //size=1:无需不可重复

		System.out.println(set.contains("a"));

		MySet s=new MySet();
		s.add("a");

		System.out.println(s.size());
	}
}

/*Set: 底层通过Map实现，map.put(obj,PRESENT),将添加的obj作为key，而value是一个常量
                      利用Map键不可重复实现Set的值不可重复

1. Set接口是Collection接口的子接口，Set接口没有提供额外的方法，
   Set接口的特性是容器类中的元素是没有顺序的，且不可重复

2. Set容器可以与数学中的"集合"的概念相对应

3. Java所提供的Set容器类有HashSet,TreeSet等 
*/

//Set的实现

class MySet{

	private HashMap map;

	private static final Object PRESENT=new Object();

	public MySet(){
		map=new HashMap();
	}

	public void add(Object obj){
		map.put(obj,PRESENT);
	}

	public int size(){
		return map.size();
	}

}