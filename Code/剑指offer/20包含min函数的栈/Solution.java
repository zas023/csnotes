/**
*题目描述：
*定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
*/

import java.util.Stack;

public class Solution {
/*思路：
利用一个辅助栈来存放最小值
    栈  3，4，2，5，1
    辅助栈 3，3，2，2，1
每入栈一次，就与辅助栈顶比较大小，如果小就入栈，如果大就入栈当前的辅助栈顶
当出栈时，辅助栈也要出栈
这种做法可以保证辅助栈顶一定都当前栈的最小值
*/
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int node) {
        data.push(node);
        if(min.isEmpty())
            min.push(node);
        else{
            if(node<=min.peek())
                min.push(node);
        }
    }
    
    public void pop() {
        if(data.peek()==min.peek())
            min.pop();
        data.pop();
    }
    
    public int top() {
        return data.peek(); 
    }
    
    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        s.push(2);
        s.push(1);
        s.push(3);
        s.push(4);

        System.out.println(s.min());
        System.out.println(s.top());
    }
}