/**
*题目描述：
*用两个栈来实现一个队列，完成队列的Push和Pop操作。 
*队列中的元素为int类型。
*/
import java.util.Stack;

//先进先出与先进后出
public class Solution {
	//保存push进入的元素
	Stack<Integer> stack1 = new Stack<Integer>();
	//保存pop将出的元素
	Stack<Integer> stack2 = new Stack<Integer>();

	//如果stack2为空，则将stack1所有元素转移到stack2

	//stack1只管进，stack2只管出

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {

		while(!stack2.isEmpty()){
			return stack2.pop();
		}

		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}

		return stack2.pop();
	}

	public static void main(String[] args) {

		Solution s=new Solution();

		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(4);
		System.out.println(s.pop());
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}