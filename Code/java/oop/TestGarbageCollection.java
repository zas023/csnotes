
/**
*Garbage Collection :垃圾回收机制
*/

public class TestGarbageCollection{

	public static void main(String[] args) {
		
	}
}

/*垃圾回收

1. 对象空间分配
   使用new关键字创建对象即可

2. 对象空间释放
   将对象赋值null即可，(使堆中对象没有被引用)。垃圾回收器将负责回收所有”不可达“对象的内存空间

3. 注：
   3.1 程序员无权调用垃圾回收器
   3.2 程序员可以通过System.gc()通知GC运行，但是Java规范不能确保立刻运行
   3.3 finalize方法，是Java提供给程序员用来释放对象资源的方法，尽量少用。

*/