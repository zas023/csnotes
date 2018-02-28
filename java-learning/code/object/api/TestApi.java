
/**
*Test Java Api
*@Author anshuzhou
*@version 1.0
*/
public class TestApi{

	public static void main(String[] args) {
		
	}

	/**
	*test
    *@param n  参数
    *@return  返回值
    */
	int test(int n){
		return n;
	}
}

/*生成自己的API文档

1. 特殊的注释
   文档注释：  /**

2. 使用JavaDoc生成API文档
   - 解决问题： 代码和文档的分离

3. 常用的Java注释标签
   - @Author  作者
   - @version  版本
   - @param  参数
   - @return  返回值含义
   - @throws  抛出异常描述
   - @deprecated  废弃，不建议用户使用该方法

命令：javadoc -d help -author -version TestApi.java
*/