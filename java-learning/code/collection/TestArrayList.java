import java.util.*;
import java.io.*;
/**
*ArrayList：列表
*/
public class TestArrayList{

	public static void main(String[] args) {


		MyArrayList list=new MyArrayList();

		for (int i=20;i>0;i--){
			list.add(i);
		}
		System.out.println(list.size());
		System.out.println(list.toString());

		list.remove(5);
		System.out.println(list.toString());

		list.add(new Date());  //存储的是new Date()对象，代表当前时间，每次运行都不一样

		System.out.println(list.toString());
	}
}

//自己实现ArrayList
class MyArrayList{

	private Object[] elementData;

	private int size; 

	public MyArrayList(){
		this(10);
	}

	public MyArrayList(int initSize){

		if (initSize<0) {
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		elementData=new Object[initSize];
	}

	public int size(){
		return size;
	}

	//添加
	public void add(Object o){
		ensureSize();
		elementData[size++]=o;
	}

	//移除指定位置对象
	public void remove(int index){

		fastremove(index);
	}

	//移除指定对象
	public void remove(Object o){

		for (int i=0; i<elementData.length ;i++ ) {
			if (o.equals(elementData[i])) {
				fastremove(i);
				return;
			}
		}
	}

	public String toString(){
		String str="";
		for (int i=0;i<elementData.length;i++){
			str=str+elementData[i];
		}
		return str;
	}

	//数组扩容
	private void ensureSize(){
		if (size==elementData.length) {
			Object[] newArray=new Object[size*2+1];
			System.arraycopy(elementData,0,newArray,0,elementData.length);
			elementData=newArray;
		}
	}

	//移除指定位置对象
	private void fastremove(int index){

		int numMoved=size-index-1;

		if (numMoved>0) {
			System.arraycopy(elementData,index+1,elementData,index,numMoved);
		}

		elementData[--size]=null;
	}

}