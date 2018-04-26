/**
*在一个字符串(1<=字符串长度<=10000，全部由字母组成)中
*找到第一个只出现一次的字符,并返回它的位置
*/

import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        int[] map = new int[256];    //ASCII 256个
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) 
                return i;
        }
        return -1;
    }

	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.FirstNotRepeatingChar("zhouas666"));
	}
}