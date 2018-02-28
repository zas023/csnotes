import java.util.*;
/**
*Map基本操作
*/
public class TestMap{

	public static void main(String[] args) {
		Map map=new HashMap();

		map.put("name","anshun");
		map.put("age",20);
		map.put("name","xiaowang");
		System.out.println(map.get("name"));

		MyMap m=new MyMap();
		m.put("name","anshun");
		m.put("age",20);
		m.put("name","xiaowang");
		System.out.println(m.get("name"));
	}
}

/*
1. Map的实现类有HashMap和TreeMap
2. Map类中存储键值对，且通过健来标志，所以健不能重复
*/

//实现Map

class MyMap{

	private Entry[] arr=new Entry[100];

	private int size;

	//添加
	public void put(Object key, Object value){
		for (int i=0;i<size ;i++ ) {
			//当有相同健时替换值
			if (arr[i].key.equals(key)) {
				arr[i].value=value;
				return;
			}
		}
		arr[size++]=new Entry(key,value);
	}

	//查找
	public Object get(Object key){
		for (int i=0;i<size ;i++ ) {
			if (key.equals(arr[i].key)) {
				return arr[i].value;
			}
		}

		return null;
	}

	//移除
	public Object remove(Object key){
		//类似ArrayList的实现

		return null;
	}

}

class Entry{
	Object key;
	Object value;

	public Entry(Object key, Object value){
		super();
		this.key=key;
		this.value=value;
	}
}