
/**
*LinkedList
*/
public class TestLinkedList{

	public static void main(String[] args) {
		MyLinkedList list=new MyLinkedList();

		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list.size());

		list.remove(1);
		System.out.println(list.size());
		System.out.println(list.get(1));
		//System.out.println(list.toString());
	}
}

//自己实现链表

//根据索引查找时，可将索引与中间值判断是从头部还是从尾部开始检索
class MyLinkedList{

	private Node first;  //链表头部
	private Node last;  //链表尾部

	private int size;

	//添加
	public void add(Object o){
		if (first==null) {
			//第一个为空，此时只有一个元素
			last=first=new Node(null,o,null);
		}else {
			//第一个不为空，接到最后一个后面
			Node n=new Node(last,o,null);

			last.setNext(n);

			last=n;
		}

		size++;
	}

	//获取指定位置
	public Object get(int index){  //index=2
		//0 1 2 3 4
		Node temp=getNode(index);
		if (temp==null) {
			return null;
		}

		return temp.getObj();
	}

	//移除指定位置
	public void remove(int index){
		
		Node temp=getNode(index);
		if (temp!=null) {
			//获取指定位置节点的前后节点tempNext
			Node tempPre = temp.getPre();
			Node tempNext= temp.getNext();

			tempPre.setNext(tempNext);
			tempNext.setPre(tempPre);
		}

		size--;
	}

	//大小
	public int size(){
		return size;
	}

	//
	public String toString(){
		String str="";

		Node temp=first;

		while(temp.getNext()!=null){
			str=str+temp.getObj();
		}

		return str;
	}

	private Node getNode(int index){

		//还需越界判断

		Node temp=null;

		if(first!=null){
			temp=first;
			//获取到指定位置的对象
			for (int i=0;i<index;i++ ) {
				temp=temp.getNext();
			}
		}
		return temp;
	}
}

class Node{
	private Node pre;
	private Node next;

	private Object obj;

	public Node(){

	}

	public Node(Node pre, Object obj, Node next){
		super();
		this.pre=pre;
		this.obj=obj;
		this.next=next;
	}

	public void setPre(Node o){
		this.pre=o;
	}

	public Node getPre(){
		return pre;
	}

	public void setObj(Object o){
		this.obj=o;
	}

	public Object getObj(){
		return obj;
	}

	public void setNext(Node o){
		this.next=o;
	}

	public Node getNext(){
		return next;
	}
}
