/**
*题目描述：
*请实现一个函数，将一个字符串中的空格替换成“%20”。
*例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/
public class Solution {

	//从前向后替换
    public String replaceSpace(StringBuffer str) {
        StringBuffer out=new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char b=str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                out.append("%20");
            }else{
                out.append(b);
            }
        }
        return out.toString();
    }

    //正则表达式（Rex)
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll("\\s","%20");
    }

    //字符串替换
    public static String replaceSpace3(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {
    	System.out.println(replaceSpace3(new StringBuffer("We Are Happy")));
    }

}