/**
*题目描述：
*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
*假设压入栈的所有数字均不相等。
*例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
*但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
*/
import java.util.ArrayList;

public class Solution {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(0==pushA.length||0==popA.length)
            return false;

        int index=0;

        ArrayList<Integer> list = new ArrayList<>();
        //用ArrayList代替Stack
        for(int i=0;i<pushA.length;i++){
            //入栈
            list.add(pushA[i]);
            //当栈顶元素于出栈顺序当前元素相同时出栈
            while((0<list.size())&&(list.get(list.size()-1)==popA[index])){
                list.remove(list.size()-1);
                index++;
            }
        }

        return list.isEmpty();
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        int [] pushA={1,2,3,4,5};
        // int [] popA={4,5,3,2,1};
        int [] popA={4,3,5,1,2};

        System.out.println(s.IsPopOrder(pushA,popA));
    }
}