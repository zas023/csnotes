# 一、Java 简介

> 1. Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。
>
> 2. Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等。

## Java 的三个体系

- **Java SE（Java Platform，Standard Edition）**：Java SE 以前称为 J2SE。它允许开发和部署在桌面、服务器、嵌入式环境和实时环境中使用的 Java 应用程序。Java SE 包含了支持 Java Web 服务开发的类，并为 Java Platform，Enterprise Edition（Java EE）提供基础。
- **Java EE（Java Platform，Enterprise Edition）：**Java EE 以前称为 J2EE。企业版本帮助开发和部署可移植、健壮、可伸缩且安全的服务器端 Java 应用程序。Java EE 是在 Java SE 的基础上构建的，它提供 Web 服务、组件模型、管理和通信 API，可以用来实现企业级的面向服务体系结构（service-oriented architecture，SOA）和 Web 2.0 应用程序。
- **Java ME（Java Platform，Micro Edition）：**Java ME以前称为 J2ME。Java ME 为在移动设备和嵌入式设备（比如手机、PDA、电视机顶盒和打印机）上运行的应用程序提供一个健壮且灵活的环境。Java ME 包括灵活的用户界面、健壮的安全模型、许多内置的网络协议以及对可以动态下载的连网和离线应用程序的丰富支持。基于 Java ME 规范的应用程序只需编写一次，就可以用于许多设备，而且可以利用每个设备的本机功能。

## Java 的主要特性

- **Java语言是简单的：**

  Java语言的语法与C语言和C++语言很接近，使得大多数程序员很容易学习和使用。另一方面，Java丢弃了C++中很少使用的、很难理解的、令人迷惑的那些特性，如操作符重载、多继承、自动的强制类型转换。特别地，Java语言不使用指针，而是引用。并提供了自动的废料收集，使得程序员不必为内存管理而担忧。

- **Java语言是面向对象的：**

  Java语言提供类、接口和继承等面向对象的特性，为了简单起见，只支持类之间的单继承，但支持接口之间的多继承，并支持类与接口之间的实现机制（关键字为implements）。Java语言全面支持动态绑定，而C++语言只对虚函数使用动态绑定。总之，Java语言是一个纯的面向对象程序设计语言。

- **Java语言是分布式的：**

  Java语言支持Internet应用的开发，在基本的Java应用编程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程方法激活）机制也是开发分布式应用的重要手段。

- **Java语言是健壮的：**

  Java的强类型机制、异常处理、垃圾的自动收集等是Java程序健壮性的重要保证。对指针的丢弃是Java的明智选择。Java的安全检查机制使得Java更具健壮性。

- **Java语言是安全的：**

  Java通常被用在网络环境中，为此，Java提供了一个安全机制以防恶意代码的攻击。除了Java语言具有的许多安全特性以外，Java对通过网络下载的类具有一个安全防范机制（类ClassLoader），如分配不同的名字空间以防替代本地的同名类、字节代码检查，并提供安全管理机制（类SecurityManager）让Java应用设置安全哨兵。

- **Java语言是体系结构中立的：**

  Java程序（后缀为java的文件）在Java平台上被编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个Java平台的任何系统中运行。这种途径适合于异构的网络环境和软件的分发。

- **Java语言是可移植的：**

  这种可移植性来源于体系结构中立性，另外，Java还严格规定了各个基本数据类型的长度。Java系统本身也具有很强的可移植性，Java编译器是用Java实现的，Java的运行环境是用ANSI C实现的。

- **Java语言是解释型的：**

  如前所述，Java程序在Java平台上被编译为字节码格式，然后可以在实现这个Java平台的任何系统中运行。在运行时，Java平台中的Java解释器对这些字节码进行解释执行，执行过程中需要的类在联接阶段被载入到运行环境中。

- **Java是高性能的：**

  与那些解释型的高级脚本语言相比，Java的确是高性能的。事实上，Java的运行速度随着JIT(Just-In-Time）编译器技术的发展越来越接近于C++。

- **Java语言是多线程的：**

  在Java语言中，线程是一种特殊的对象，它必须由Thread类或其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为Thread(Runnable)的构造子类将一个实现了Runnable接口的对象包装成一个线程，其二，从Thread类派生出子类并重写run方法，使用该子类创建的对象即为线程。值得注意的是Thread类已经实现了Runnable接口，因此，任何一个线程均有它的run方法，而run方法中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java语言支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为synchronized）。

- **Java语言是动态的：**

  Java语言的设计目标之一是适应于动态变化的环境。Java程序需要的类能够动态地被载入到运行环境，也可以通过网络来载入所需要的类。这也有利于软件的升级。另外，Java中的类有一个运行时刻的表示，能进行运行时刻的类型检查。

# 二、Java 基础语法

## 基础语法

- **大小写敏感**：Java是大小写敏感的，这就意味着标识符Hello与hello是不同的。
- **类名**：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 MyFirstJavaClass 。
- **方法名**：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- **源文件名**：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记Java是大小写敏感的），文件名的后缀为.java。（如果文件名和类名不相同则会导致编译错误）。
- **主方法入口**：所有的Java 程序由**public static void main(String args[])**方法开始执行。

## 标识符

> Java所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

**注意：**

1. 所有的标识符都应该以字母（A-Z或者a-z）,美元符（$）、或者下划线（_）开始
2. 首字符之后可以是任何字符的组合
3. 关键字不能用作标识符
4. 标识符是大小写敏感的

**Example:**

- 合法标识符举例：age、$salary、_value、__1_value
- 非法标识符举例：123abc、-salary

## 修饰符

> 像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：
>
> 1. **访问控制修饰符 :** default, public , protected, private
> 2. **非访问控制修饰符 :** final, abstract, static，synchronized 和 volatile

## 变量

> - 局部变量
> - 类变量（静态变量）
> - 成员变量（非静态变量）

## 数组

> 数组是储存在堆上的对象，可以保存多个同类型变量。

## 枚举

> Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的bug。



# 三、Java 数据类型

## 基本数据类型

> Java语言内置了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。

| 类型    | 最小值       | 最大值            | 默认值 | 说明                                   |
| ------- | ------------ | ----------------- | ------ | -------------------------------------- |
| byte    | -128（-2^7） | 127（2^7-1）      | 0      | 8位、有符号的，以二进制补码表示的整数  |
| short   | -2^15        | 2^15 - 1          | 0      | 16位、有符号的以二进制补码表示的整数   |
| int     | -2^31        | 2^31 - 1          | 0      | 32位、有符号的以二进制补码表示的整数   |
| long    | -2^63        | 2^63 -1           | 0L     | 64位、有符号的以二进制补码表示的整数   |
| float   |              |                   | 0.0f   | 单精度、32位、符合IEEE 754标准的浮点数 |
| double  |              |                   | 0.0d   | 双精度、64位、符合IEEE 754标准的浮点数 |
| boolean |              |                   | false  | 表示一位的信息                         |
| char    | '\u0000' (0) | '\uffff' (65,535) |        | 一个单一的16位Unicode字符              |

- 浮点数的默认类型为double类型，不能用来表示精确的值，如货币。但float在储存大型浮点数组的时候可节省内存空间。

- [Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

## 引用数据类型

> java为每种基本类型都提供了对应的封装类型，分别为：Byte、Short、Integer、Long、Float、Double、Character、Boolean。引用类型是一种对象类型,它的值是指向内存空间的引用，就是地址。

- 在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，变量一旦声明后，类型就不能被改变了。
- 基本数据类型的变量是存储在栈内存中，而引用类型变量存储在栈内存中，保存的是实际对象在堆内存中的地址，实际对象中保存这内容。
- 对象、String、数组都是引用数据类型。
- 所有引用类型的默认值都是null。
- 一个引用变量可以用来引用任何与之兼容的类型。

## 自动拆装箱

> Java 从 jdk1.5 开始引入自动装箱和拆箱,使得基本数据类型与引用类型之间相互转换变得简单。

- **自动装箱：**java自动将原始类型转化为引用类型的过程，自动装箱时编译器会调用valueOf()方法,将原始类型转化为对象类型。
- **自动拆箱：**java自动将引用类型转化为原始类型的过程，自动拆箱时编译器会调用intValue(),doubleValue()这类的方法将对象转换成原始类型值。

### 主要的发生情况

一是赋值时: 

```java
Integer a = 3; //自动装箱
int b = a; //自动拆箱
```

二是方法调用：

```java
public Integer query(Integer a){
   return a;
}
query(3); //自动装箱
int result = query(3); //自动拆箱
```

### 带来的问题

- **程序性能：**由于装箱会隐式地创建对象创建，因此千万不要在一个循环中进行自动装箱的操作，下面就是一个循环中进行自动装箱的例子，会额外创建多余的对象,增加GC的压力,影响程序的性能。

```java
Integer sum = 0;
 for(int i=0; i<1000; i++){
   sum+=i;
}
```

- **空指针异常：**

```java
Object obj = null;
int i = (Integer)obj;
```

### 对象比较(缓存池问题)

```java
Integer a = 120;
int b= 120;
Integer c = 120;
Integer d = new Integer(120);
System.out.println(a == b);   //true    t1
System.out.println(a == c);   //true    t2
System.out.println(a == d);   //false   t3

Integer e = 128;
Integer f = 128;
System.out.println(e == f);   //false   t4
```

1. t1产生的原因是编译器编译时会调用intValue()自动的将a进行了拆箱，结果肯定是true; 
2. t3结果无论如何都不会相等的，因为new Integer(120)构造器会创建新的对象。
3. 对于t2和t4，查看jdk的源码：

```java
public static Integer valueOf(int i) {
    assert IntegerCache.high >= 127;
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```

发现在 Java 8 中，Integer 缓存池的大小默认为 -128\~127，对于-128~127之间的值会取缓存中的引用,通过缓存经常请求的值而显著提高空间和时间性能。 这就能解释t2结果返回true，而t4由于128不在缓存区间内，编译器调用valueOf方法会重新创建新的对象，两个不同的对象返回false。

**基本类型对应的缓冲池**

- boolean values true and false
- all byte values
- short  and int values between -128 and 127
- char in the range \u0000 to \u007F

## 类型转换

> 整型、实型(常量)、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。

### 自动类型转换

> 数字表示范围小的数据类型可以自动转换成范围大的数据类型。

```java
int i = 200;
long l = i;
```

自动转换关系图：

![Snipaste_2019-03-19_21-39-43](assets/Snipaste_2019-03-19_21-39-43.png)

实线表示自动转换时不会造成数据丢失，虚线则可能会出现数据丢失问题。

**注意：**

- 自动转换也要小心数据溢出问题

```java
int count = 100000000;
int price = 1999;
long totalPrice = count * price;

//编译没任何问题，但结果却输出的是负数，
//这是因为两个 int 相乘得到的结果是 int, 相乘的结果超出了 int 的代表范围。
//这种情况，一般把第一个数据转换成范围大的数据类型再和其他的数据进行运算。

int count = 100000000;
int price = 1999;
long totalPrice = (long) count * price;
```

- **向下转换**时可以直接将 int 常量字面量赋值给 byte、short、char 等数据类型，而不需要强制转换，只要该常量值不超过该类型的表示范围都能自动转换。

### 强制类型转换

```java
short s = 199;
int i = s;// 199

double d = 10.24;
long ll = (long) d;// 10

//以上的转换结果都在我们的预期之内，属于正常的转换和丢失精度的情况，下面的例子就一样属于数据溢出的情况。

int ii = 300;
byte b = (byte)ii;
//300 已经超出了 byte 类型表示的范围，所以会转换成一个毫无意义的数字。
```

### 类型提升

> 所谓类型提升就是指在多种不同数据类型的表达式中，类型会自动向范围表示大的值的数据类型提升。

```java
long count = 100000000;
int price = 1999;
long totalPrice = price * count;

//price 为 int 型，count 为 long 型，运算结果为 long 型，运算结果正常，没有出现溢出的情况。
```

