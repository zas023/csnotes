import java.util.*;
/**
*实现HashMap
*/
public class TestHashMap{

	public static void main(String[] args) {
		
		MyHashMap map=new MyHashMap();
		map.put("name","anshun");
		map.put("age",20);
		map.put("name","xiaowang");
		System.out.println(map.get("name"));
	}
}

//底层实现：数组+链表

class MyHashMap{
	private final int NUM=1000;

	private LinkedList[] arr=new LinkedList[NUM];
	private int size;

	//添加
	public void put(Object key, Object value){

		int hashCode=key.hashCode()%NUM;

		if (arr[hashCode]==null) {
			LinkedList list=new LinkedList();
			list.add(new Entry(key,value));
			arr[hashCode]=list;
		}else{
			LinkedList list=arr[hashCode];
			//遍历
			for (int i=0;i<list.size() ;i++ ) {
				Entry e=(Entry) list.get(i);
			    //当有相同健时替换值
				if (key.equals(e.key)) {
					e.value=value;
					size++;
					return;
				}
			}
			arr[hashCode].add(new Entry(key,value));
		}

		size++;
	}

	//查找
	public Object get(Object key){

		int hashCode=key.hashCode()%NUM;

		if (arr[hashCode]!=null) {
			LinkedList list=arr[hashCode];
			for (int i=0;i<list.size() ;i++ ) {
				if (key.equals(((Entry)list.get(i)).key)) {
					return ((Entry)list.get(i)).value;
				}
			}
		}

		return null;
	}

	//移除
	public Object remove(Object key){
		//类似ArrayList的实现

		return null;
	}

	//大小
	public int size(){
		return size;
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