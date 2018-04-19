/**
*输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
*例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

	public String PrintMinNumber(int [] numbers) {
		int n= numbers.length;
		ArrayList<Integer> list= new ArrayList<Integer>(n);
		for(int i=0;i<n;i++){
			list.add(numbers[i]);
		}

		String s="";
		Collections.sort(list, new Comparator<Integer>(){
			public int compare(Integer str1,Integer str2){
				String s1=str1+""+str2;
				String s2=str2+""+str1;
				return s1.compareTo(s2);
			}
		});
		for(int i:list){
			s+=i;
		}
		return s;
	}


	public static void main(String[] args) {
		Solution s=new Solution();
		int [] array={3,32,321};
		System.out.println(s.PrintMinNumber(array));
	}
}

/*
对vector容器内的数据进行排序，按照 将a和b转为string后
若 a＋b<b+a  a排在在前 的规则排序,
如 2 21 因为 212 < 221 所以 排序后为 21 2 
to_string() 可以将int 转化为string
*/