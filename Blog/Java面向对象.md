[TOC]

# 一、面向对象（OOP）

>本质是以类的方式组织代码，以对象的方式组织数据。

**面向过程Vs面向对象**

1. 区别
   - 面向过程：事物比较简单，可以用线性思维去解决（第一步做什么，接下来做什么...)
   - 面向对象：事物比较复杂，使用简单的线性思维无法解决
2. 共同点 
   - 面向过程和面向对象都是解决实际问题的一种思维方式
   - 二者相辅相成，并不是对立的。解决复杂问题，通过面向对象可以方便我们从宏观上把握复杂的关系，便于我们分析整个系统；具体到微观操作，仍然使用面向过程方式来处理。

# 二、类和对象

## 1. 类（Class)

> 类是具有共同属性的一组对象，是创建对象的模板或蓝图，是一个逻辑实体。



### 1.1 接口 (Interface)

> 接口：就是比“抽象类”还要抽象的“抽象类”，可以更加规范对子类进行约束。（接口就是规范，定义一组规则）
>
> 全面专业的实现：规范和具体实现的分离。

**面向接口编程 vs 实现接口编程**

项目的具体需求是多变的，我们必须以不变应万变才能从容开发。

**Example**

```java
public class TestInterface implements MyInterface{

	public void test(){
		System.out.println("TestInterface.test");
	}

	public static void main(String[] args) {

		MyInterface i=new TestInterface();

		i.test();
	}
}

interface A{
	
}

interface B{

}

//接口中只有常量、抽象方法，实现设计与实现的分离

interface MyInterface extends A,B{

	int NUM=100;
	//接口中上面语句等同于下面的语句，编译器添加 public static final
	public static final int NUM1=100;

    void test();
    //接口中，
	//void test() == public static void test()
}
```



**小结：**

- 子类通过implements来实现接口中的规范
- 接口不能创建实例，但可以用于声明引用变量类型
- 一个类实现了接口，必须实现该接口中的所有方法，且这些方法只能是public
- 接口支持多继承



#### 1.1.1. 回调 （CallBack）

> CallBack : Hook(钩子函数)

**回调的实现:**

1. Callback
2. Hook
3. 模板方法模式



### 1.2 抽象类 （Abstract)

> 抽象类只有声明，没有实现
>
> 抽象类是一种模板模式，抽象类为所有子类提供一个通用模板，子类可以拓展。
>
> 通过抽象类，我们可以严格的限制子类，使子类之间更加通用

```java
public class TestAbstract{
	
	public static void main(String[] args) {
		//Animal a=new Animal();  //错误: Animal是抽象的; 无法实例化

		Animal a=new Cat();
		a.breath();
		//a.voice();
	}
}

abstract class Animal{
	public abstract void voice();

	public void breath(){
		System.out.println("呼吸");
		//voice();
	}
}

class Cat extends Animal{
	public void voice(){
		System.out.println("喵喵喵");
		//breath();
	}
	//错误: Cat不是抽象的, 并且未覆盖Animal中的抽象方法voice()
}
 
```

**抽象类要点：**

- 有抽象方法的类只能定义成抽象类
- 抽象类不能实例化，即不能用new来实例化抽象类
- 抽象类可以包含属性、方法、构造器，但只能用来被子类调用
- 抽象类只能用于继承
- 抽象方法必须被子类实现



### 1.3 管理



#### 1.3.1 Java包 （Package）

- 为何使用Package :
  1. 解决类之间的重名问题
  2. 为了方便管理：合适的类位于合适的包名

- 如何使用 :
  1. 通常是类的第一句非注释语句
  2. 域名倒着写，再加上模块名，并于内部管理类



**注：**com.gao和com.gao.car,这两个包没有包含关系，是完全独立的。（只是逻辑上看似后者是前者的一部分）



#### 1.3.2 Import



#### 1.3.3 JDK中常用包

- **java.lang**（language)

  包含一些Java语言的核心类，如String，Math，Integer，System和Thread，提供常用功能

- **java.awt**

  包含抽象窗口工具集（abstract window toolkits）的多个类，这些类用来创建和管理程序的GUI

- **java.net**

  包含执行网络相关的操作类

- **java.io**

  包含能提供多种IO操作的类

- **java.util**

  包含一些实用的工具类，如定义系统特性，使用日期等



### 1.4 包含

- 字段

- 方法

- 构造函数

- 代码块

- 嵌套类和接口

example :

```java
class Student{
	String name;
	int age;
}
//每个编译单元（文件）都只能有一个public类.
//这表示，每个编译单元都有单一的公共接口，用public类来表现。
public class TestClass{

	public static void main(String[] args) {

		//通过加载器 Class Loader加载Student类，将类的信息存放在方法区
		Student stu=new Student();
		stu.name="enosh";
		stu.age=20;

		//"anshun"、20均是常量，存放到方法区中的常量池
		//而堆中对象的属性则存放对应的地址

		String str="enosh";
		System.out.println(str==stu.name);
		//结果为true，即str与name指向同一个内存地址
	}
}
```

#### 1.4.1 类的属性（Field）

> 属性：field，或者叫做成员变量

1. 属性用于定义该类或改对象包含的数据或者说静态属性。
2. 属性的作用范围是整个类体。
3. 在定义成员变量时可以对其初始化，如果不对其初始化，Java使用默认值初始化。

**类的变量类型**

- **局部变量**：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
- **成员变量**：成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
- **类变量**    ：类变量也声明在类中，方法体之外，但必须声明为static类型。



#### 1.4.2 类的方法 (Method)

> 在java中的方法类似函数，用于暴露对象的行为。

**方法的优点**

- 代码可重用性
- 代码优化

**方法的重载 （Overload）**

> 方法的重载是指一个类中可以定义有相同的名字，但参数不同的多个方法。调用时，会根据不同的参数表选择对应的方法。和普通方法一样，构造函数也可以重载。

两同三不同:

- 同一类，同一个方法名
- 参数表不同（类型、个数、顺序）

**方法的重写 （Override）**

- 子类中可以根据需要对基类中继承的方法进行重写
- 从写方法和被重写方法具有相同方法名、参数列表和返回类型
- 重写方法不能使用比被重写方法更严格的访问权限（由于多态）



#### 1.4.3 构造方法 (Constructor)

> 构造方法又称构造器，用于构建该类的实例

**Constructor是一种特殊的方法：**

- 通过new关键字调用
- 构造器虽然有返回值，但不能自定义返回值，返回类型是本类
- 如果我们没有定义构造器，则系统将会自动定义一个无参构造函数（如果已经添加构造器，则编译器不会添加）
- 构造器的方法名必须与类名一致

example:

```java
public class TestConstructor{

	public static void main(String[] args) {
		
		//Point p=new Point();  //错误: 无法将类 Point中的构造器 Point应用到给定类型;
		Point p=new Point(3.14,3.14);
	}
}

class Point{

	private double x,y;

	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
}
```



## 2. 对象（Object)

### 2.1 引用类型（Reference）

- Java语言中除了基本类型之外的变量类型都称之为引用类型
- Java中的对象通过引用对其进行操作

### 2.2 this

> 隐式参数 : 普通方法中默认传入一个参数，即this。
>
> 类初始化存储于方法区，所有该类对象共用这一份代码，调用时传入this，以确定哪个对象

- 普通方法中：this总是指向调用该方法的对象 
- 构造方法中：this总是指向正要初始化的对象
- this不能用于static方法（static方法不传递this参数）

**Example**

```java
class Student{
	String name;
	int id;

	public Student(){

	}

	public Student(String name){
		this();  //通过this调用其它方法
		this.name=name;
		//this();  //错误: 对this的调用必须是构造器中的第一个语句
	}

	public void study(/*Student this*/){   //传递隐式的参数this
		this.name="anshun";
		System.out.println(name+"学习");
	}

}
```

### 2.3 static

> 区分类的变量和对象的变量，static对象从属于类，创建对象时不会存储static成员。

1. 在类中，用static声明的成员变量称之为静态成员变量，或类属性、类变量
   * 它为该类的公共变量，属于类，被类的所有实例共享，在类被载入时被显示初始化
   * 对该类的所有对象来说，static成员变量只有一份，被该类所有对象共享
   * static变量存储于方法区中

2. 用static声明的方法称作静态方法
   - 不需要对象就可以直接调用
   - 在调用该方法时，不会将对象的引用传递给它，所以在static方法中不可访问非static的成员，而非static的成员可以访问和调用static成员。

**静态初始化块**

- 如果希望加载后，对整个类进行某些初始化操作，可以使用static初始化块
- 是类初始化时执行，不是创建对象时
- 静态初始化块不能访问非static成员
- 执行顺序：上溯到Object类，先执行Object的静态初始化块，再向下执行子类的静态初始化块。



### 2.4 Final

- **修饰变量：**常量，只能初始化一次，类似cpp中的constant
- **修饰方法：**改方法不可以被子类重写，但可以被重载
- **修饰类：**修饰的类不能有子类，即不能被继承，如Math、String

### 2.5 内存结构

> 待补充



# 三、三大基本特征

## 1. 继承 （Inherit)

> 1. 类是对对象的抽象，OOD,继承是对某一批类的抽象，从而实现对现实世界更好的建模
> 2. 提高代码的复用性，OOP
> 3. extends：拓展

**小结：**

- 子类继承父类，可以得到除父类构造方法以外的全部属性和方法
- Java中只有单继承，但可以用接口实现多继承
- 如果一个类没有调用extends，则它的父类是java.lang.Object

### 1.1 Object

### 1.2 Super

> super是直接父类对象的引用，可以通过super来访问父类中被子类覆盖的方法或属性

- 普通方法：没有顺序限制，可以随便调用
- 构造方法：任何类的构造函数中，若是构造函数第一行没有显式的调用super(..)，那么Java默认都会调用super()作为父类的初始化函数。

### 1.3 方法重写 （Override）

- 子类中可以根据需要对基类中继承的方法进行重写
- 从写方法和被重写方法具有相同方法名、参数列表和返回类型
- 重写方法不能使用比被重写方法更严格的访问权限（由于多态）

### 1.4 组合 

**继承 vs 组合：**

- is-a 关系使用继承
- has-a 关系使用组合



## 2. 封装 (Encapsulation )

**封装的作用及含义:**

- 隐藏对象内部的复杂性、只对外公开简单的接口，以便外界调用，从而提高系统的可拓展性、可维护性。

高聚合，低耦合:

- 高聚合就是类的内部数据操作细节自己完成，不允许外接干涉

**控制符**：

|           | 同一个类 | 同一个包 | 子类 | 所有类 |
| --------- | :------: | :------: | :--: | :----: |
| private   |    *     |          |      |        |
| default   |    *     |    *     |      |        |
| protected |    *     |    *     |  *   |        |
| public    |    *     |    *     |  *   |   *    |



## 3. 多态（polymorphism）

>  多态是OOP中的一个重要的特征，主要实现动态联编的，换句话说，就是程序的最终状态只有在执行过程中才被决定而非在编译期间。

**Java如何实现多态**

引用变量的两种类型：

- 编译时类型（模糊点，一般是一个父类）：由声明时的类型决定
- 执行时类型（运行时，具体是哪个子类就是那个子类）：由实际对象的类型决定
- 编译时，变量声明的什么类型就是什么类型，执行时，创建的什么类型对象就是什么类型

**多态的三个必要条件**

- 要有继承
- 要有方法重写
- 父类引用指向子类对象

**Example**

```java
public class TestPolymorphism{

    //不使用多态
	public static void testCat(Cat a){
		a.voice();
	}

	public static void testDog(Dog a){
		a.voice();
	}

	public static void testPig(Pig a){
		a.voice();
	}

	//使用多态
	public static void testAnimal(Animal a){
		a.voice();
	}
	
	public static void main(String[] args) {
		
		testCat(new Cat());

		Animal a=new Cat();
		//编译时，a声明的是Animal类型，就会去Animal类中查找相应的成员
		//       如果没有改成员，则编译无法通过
		//执行过程中，a指向的是一个Cat类的实例对象，则a的类型就是Cat

		//a.play();//如法通过编译
		((Cat)a).play();

		testAnimal(new Cat());  //父类的引用指向一个子类对象
		testAnimal(new Dog());
	}
}

class Animal{

	String str;

	public void voice(){
		System.out.println("普通动物叫声");
	}
}

class Cat extends Animal{

	public void voice(){
		System.out.println("喵喵喵");
	}

	public void play(){
		System.out.println("上树");
	}
}

class Dog extends Animal{

	public void voice(){
		System.out.println("汪汪汪");
	}
}

class Pig extends Animal{

	public void voice(){
		System.out.println("哼哼哼");
	}
}
```

