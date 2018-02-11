### 一、Java 简介
>Java是由Sun Microsystems公司于1995年5月推出的Java面向对象程序设计语言和Java平台的总称。由James Gosling和同事们共同研发，并在1995年正式推出。

##### （一）Java分为三个体系：

- JavaSE(J2SE)(Java2 Platform Standard Edition，java平台标准版)
- JavaEE(J2EE)(Java 2 Platform,Enterprise Edition，java平台企业版)
- JavaME(J2ME)(Java 2 Platform Micro Edition，java平台微型版)

2005年6月，JavaOne大会召开，SUN公司公开Java SE 6。此时，Java的各种版本已经更名以取消其中的数字"2"：J2EE更名为Java EE, J2SE更名为Java SE，J2ME更名为Java ME。

---
##### （二）主要特性

- Java语言是简单的：
- Java语言的语法与C语言和C++语言很接近，使得大多数程序员很容易学习和使用。另一方面，Java丢弃了C++中很少使用的、很难理解的、令人迷惑的那些特性，如操作符重载、多继承、自动的强制类型转换。特别地，Java语言不使用指针，而是引用。并提供了自动的废料收集，使得程序员不必为内存管理而担忧。
- Java语言是面向对象的：
Java语言提供类、接口和继承等原语，为了简单起见，只支持类之间的单继承，但支持接口之间的多继承，并支持类与接口之间的实现机制（关键字为implements）。Java语言全面支持动态绑定，而C++语言只对虚函数使用动态绑定。总之，Java语言是一个纯的面向对象程序设计语言。

- Java语言是分布式的：
Java语言支持Internet应用的开发，在基本的Java应用编程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程方法激活）机制也是开发分布式应用的重要手段。

- Java语言是健壮的：
Java的强类型机制、异常处理、垃圾的自动收集等是Java程序健壮性的重要保证。对指针的丢弃是Java的明智选择。Java的安全检查机制使得Java更具健壮性。

- Java语言是安全的：
Java通常被用在网络环境中，为此，Java提供了一个安全机制以防恶意代码的攻击。除了Java语言具有的许多安全特性以外，Java对通过网络下载的类具有一个安全防范机制（类ClassLoader），如分配不同的名字空间以防替代本地的同名类、字节代码检查，并提供安全管理机制（类SecurityManager）让Java应用设置安全哨兵。

- Java语言是体系结构中立的：
Java程序（后缀为java的文件）在Java平台上被编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个Java平台的任何系统中运行。这种途径适合于异构的网络环境和软件的分发。

- Java语言是可移植的：
这种可移植性来源于体系结构中立性，另外，Java还严格规定了各个基本数据类型的长度。Java系统本身也具有很强的可移植性，Java编译器是用Java实现的，Java的运行环境是用ANSI C实现的。

- Java语言是解释型的：
如前所述，Java程序在Java平台上被编译为字节码格式，然后可以在实现这个Java平台的任何系统中运行。在运行时，Java平台中的Java解释器对这些字节码进行解释执行，执行过程中需要的类在联接阶段被载入到运行环境中。

- Java是高性能的：
与那些解释型的高级脚本语言相比，Java的确是高性能的。事实上，Java的运行速度随着JIT(Just-In-Time）编译器技术的发展越来越接近于C++。

- Java语言是多线程的：
在Java语言中，线程是一种特殊的对象，它必须由Thread类或其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为Thread(Runnable)的构造子将一个实现了Runnable接口的对象包装成一个线程，其二，从Thread类派生出子类并重写run方法，使用该子类创建的对象即为线程。值得注意的是Thread类已经实现了Runnable接口，因此，任何一个线程均有它的run方法，而run方法中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java语言支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为synchronized）。

- Java语言是动态的：
Java语言的设计目标之一是适应于动态变化的环境。Java程序需要的类能够动态地被载入到运行环境，也可以通过网络来载入所需要的类。这也有利于软件的升级。另外，Java中的类有一个运行时刻的表示，能进行运行时刻的类型检查。

##### （三）C++ VS Java
性质| C++| Java
- | :-: | :-: 
平台相关|C++是平台相关的|Java是平台无关的
主要用于|C++主要用于系统编程|Java主要用于应用程序编程。它广泛应用于窗口，基于Web，企业和移动应用
Goto|C++支持goto语句|Java不支持goto语句
多继承|C++支持多重继承|Java不支持通过类的多继承，它可以通过java中的接口实现
操作符重载|C++支持操作符重载|Java不支持运算符重载
指针|C++支持指针，可以在C++中编写指针的程序|Java在内部支持指针。但是不能在java中编写指针程序。这意味着在Java中限制了指针支持
编译器和解释器|C++仅使用编译器|Java使用编译器和解释器
按值调用和通过引用调用|C++支持按值调用和按引用调用|Java仅支持按值调用，在java中没有通过引用调用。
结构体和联合体|C++支持结构体和联合体	|Java不支持结构体和联合体
线程支持|C++没有内置的线程支持。它依赖于第三方库来支持线程。|Java有内置线程支持。
文档注释|C++不支持文档注释	Java支持文档注释，可使用(/** ... */)来创建|Java源代码的文档。
virtual 关键字|C++支持virtual关键字，这样可以用于决定是否覆盖一个函数。|Java没有virtual关键字。默认情况下，可以覆盖所有非静态方法。换句话说，非静态方法默认是虚拟的。
无符号右移>>>|C++不支持>>>运算符|Java支持无符号右移>>>运算符，在顶部为负数填充零。对于正数，它的工作原理与>>运算符相同。
继承树|C++总是创建一个新的继承树|Java总是使用单继承树，因为所有类都是Java类中的Object类的子类。Object类是java中的继承树的根。


---
### 二、Java 开发环境配置
 
>环境的配置重点在于系统环境变量的配置，网上这方面的教程很多。
 
JDK安装完成后，在"系统变量"中设置3项属性，JAVA_HOME,PATH,CLASSPATH(大小写无所谓),若已存在则点击"编辑"，不存在则点击"新建"。

##### 环境变量设置参数如下：

- 变量名：JAVA_HOME
变量值：C:\Program Files (x86)\Java\jdk1.8.0_141        // 要根据自己的实际路径配置
- 变量名：CLASSPATH
变量值：.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;         //记得前面有个"."
- 变量名：Path
变量值：%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

##### 测试

1.  "开始"->"运行"，键入"cmd"，或者键入“win"+"x"，在选择命令提示符；

2. 键入命令: java -version、java、javac 几个命令；

---
### 三、开发工具
>使用sublime或者类似的文本编辑器以及Idea等IDE。

---
### 四、Hello World

>第一个java程序

```
public class Hello {

    public static void main(String []args) {
       System.out.println("Hello World");
    }
} 
```
    1. 将文件保存为Hello.java;
    2. 打开cmd，进入文件所在目录；
    3. 在命令行窗口键入 javac Hello.java  ，回车编译代码。
    4. 再键入java Hello ，回车就可以运行程序。
  
  运行结果：
```
Hello World
```
