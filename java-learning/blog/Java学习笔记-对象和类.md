### Java 对象和类
>Java作为一种面向对象语言。支持以下基本概念：
    1. 多态
    2. 继承
    3. 封装
    5. 抽象
    6. 类
    7. 对象
    8. 实例
    9. 方法
    10. 消息解析


- 对象：对象是类的一个实例，有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。
- 类：类是一个模板，它描述一类对象的行为和状态。

---
#### 1. Java中的对象
>具有状态和行为的实体可称为对象(女朋友也可以叫对象)。 椅子，自行车，标记，笔，桌子，汽车等。它可以是物理或逻辑(有形和无形)。 无形对象的例子是银行系统。

    一个对象有三个特点：

- 状态： 表示一个对象的数据(值)。
- 行为： 表示对象的行为(功能)，例如：存款，取款等。
- 标识： 对象标识通常通过唯一ID实现。该ID的值对外部用户不可见。 但是，它由JVM内部使用来唯一地标识每个对象。

    例如： 汽车是一个对象。它的名字是：捷达，颜色是白色等这些就是它的状态(数据值)。它用于跑路，所以跑路就是它的行为。

>对象是类的一个实例。 类是创建对象的模板或蓝图。 所以对象是一个类的实例。

    对象定义：

- 对象是一个现实世界的实体。
- 对象是一个运行时实体。
- 对象是具有状态和行为的实体。
- 对象是类的一个实例。

---

#### 2. Java中的类
>类是具有共同属性的一组对象。它是创建对象的模板或蓝图。它是一个逻辑实体。 它不能是物理存在的实体。

    Java中的类可以包含：

- 字段
- 方法
- 构造函数
- 代码块
- 嵌套类和接口

``` Java
//声明一个类的语法：
class <class_name>{  
    field;  
    method;  
}
```

##### 2.1. Java中的实例变量
>实例变量在类内部，但在方法外部定义的变量称为实例变量。 实例变量在编译时不获取内存。 它在运行时获取对象(实例)创建时的内存。 这是为什么，它被称为实例变量。

##### 2.2. Java中的方法
>在java中的方法类似函数，用于暴露对象的行为。

    方法的优点

- 代码可重用性
- 代码优化

##### 2.3. Java中的new关键字
>new关键字用于在运行时分配内存。所有对象在堆内存区域中获取内存。

#### 2.4构造方法
>每个类都有构造方法。如果没有显式地为类定义构造方法，Java编译器将会为该类提供一个默认构造方法。

    在创建一个对象的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。

``` Java
//下面是一个构造方法示例：
public class Puppy{
   public Puppy(){
   }

   public Puppy(String name){
      // 这个构造器仅有一个参数：name
   }
}
```

#### 2.5创建对象
    对象是根据类创建的。在Java中，使用关键字new来创建一个新的对象。创建对象需要以下三步：

- 声明：声明一个对象，包括对象名称和对象类型。
- 实例化：使用关键字new来创建一个对象。
- 初始化：使用new创建对象时，会调用构造方法初始化对象。

``` Java
//下面是一个创建对象的例子：
public class Puppy{
   public Puppy(String name){
      //这个构造器仅有一个参数：name
      System.out.println("Passed Name is :" + name ); 
   }
   public static void main(String []args){
      // 下面的语句将创建一个Puppy对象
      Puppy myPuppy = new Puppy( "tommy" );
   }
}

//编译并运行上面的程序，会打印出下面的结果：
Passed Name is :tommy
```

#### 在Java中创建对象的不同方法有哪些？
    在java中有很多方法可以用来创建对象。它们分别是：

- 通过new关键字
- 通过newInstance()方法
- 通过clone()方法
- 通过反序列化
- 通过工厂方法等
- 在接下来的章节中，将学习这些方法用来创建对象。

#### 匿名对象
    匿名只是表示没有名。没有引用的对象(也就是不使用实例变量)称为匿名对象。它只能在创建对象时使用。如果只需要使用一个对象，匿名对象是一个很好的方法。 例如：

``` Java
new Puppy();//匿名对象
Puppy p = new Puppy();// 使用实例变量，所以不是匿名对象
```

---

### 源文件声明规则
>当在一个源文件中定义多个类，并且还有import语句和package语句时，要特别注意这些规则。

- 一个源文件中只能有一个public类
- 一个源文件可以有多个非public类
- 源文件的名称应该和public类的类名保持一致。例如：源文件中public类的类名是Employee，那么源文件应该命名为Employee.java。
- 如果一个类定义在某个包中，那么package语句应该在源文件的首行。
- 如果源文件包含import语句，那么应该放在package语句和类定义之间。如果没有package语句，那么import语句应该在源文件中最前面。
- import语句和package语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。
- 类有若干种访问级别，并且类也分不同的类型：抽象类和final类等。这些将在访问控制章节介绍。

    除了上面提到的几种类型，Java还有一些特殊的类，如：内部类、匿名类。

---
### Java包
>包主要用来对类和接口进行分类。当开发Java程序时，可能编写成百上千的类，因此很有必要对类和接口进行分类。

---
### Import语句
>在Java中，如果给出一个完整的限定名，包括包名、类名，那么Java编译器就可以很容易地定位到源代码或者类。Import语句就是用来提供一个合理的路径，使得编译器可以找到某个类。

``` Java
//例如，下面的命令行将会命令编译器载入java_installation/java/io路径下的所有类
import java.io.*;
```

### 一个简单的例子

``` Java
class Employee{
    String name;
    int age;
    String designation;
    double salary;
    // Employee 类的构造器
    public Employee(String name){
        this.name = name;
    }
    // 设置age的值
    public void empAge(int empAge){
        age =  empAge;
    }
    /* 设置designation的值*/
    public void empDesignation(String empDesig){
        designation = empDesig;
    }
    /* 设置salary的值*/
    public void empSalary(double empSalary){
        salary = empSalary;
    }
    /* 打印信息 */
    public void printEmployee(){
        System.out.println("Name:"+ name );
        System.out.println("Age:" + age );
        System.out.println("Designation:" + designation );
        System.out.println("Salary:" + salary);
    }
}

public class EmployeeExample {

    public static void main(String args[]){
        /* 使用构造器创建两个对象 */
        Employee empOne = new Employee("James Smith");
        Employee empTwo = new Employee("Mary Anne");

        // 调用这两个对象的成员方法
        empOne.empAge(26);
        empOne.empDesignation("Senior Software Engineer");
        empOne.empSalary(1000);
        empOne.printEmployee();

        empTwo.empAge(21);
        empTwo.empDesignation("Software Engineer");
        empTwo.empSalary(500);
        empTwo.printEmployee();
    }
}

//运行结果：
Name:James Smith
Age:26
Designation:Senior Software Engineer
Salary:1000.0
Name:Mary Anne
Age:21
Designation:Software Engineer
Salary:500.0
```

