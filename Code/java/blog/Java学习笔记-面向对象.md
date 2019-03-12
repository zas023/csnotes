### 一 Java构造器（构造方法）
>java中的构造方法是一种特殊类型的方法，用于初始化对象。Java构造函数在对象创建时被调用。 它构造值，即提供对象的数据，这是为什么它被称为构造函数。

    创建java构造函数的规则:

- 构造函数名称必须与其类名称相同
- 构造函数必须没有显式返回类型

>有两种类型的构造函数：

    1. 默认构造函数(无参数构造函数)
    2. 参数化构造函数

#### 1. 默认构造函数(无参数构造函数)

``` Java
//没有参数的构造函数称为默认构造函数。默认构造函数的语法如下：
<class_name>(){}

//默认构造函数的示例：
class Bike {
    Bike() {
        System.out.println("Bike is created");
    }

    public static void main(String args[]) {
        Bike b = new Bike();
    }
}

//上面的示例代码运行结果如下 -
Bike is created
```

    规则：
    1. 如果类中没有构造函数，编译器会自动创建一个默认构造函数。
    2. 默认构造函数根据类型为对象提供默认值，如：0，null等。 
    3. 构造函数返回当前类的实例(不能指定返回值类型，但它会返回一个值)。

#### 2. 构造函数和方法之间的区别

|构造函数|Java方法|
 :-: | -: |
构造器用于初始化对象的状态(数据)。|	方法用于暴露对象的行为。
构造函数不能有返回类型。|	方法一般都有返回类型。
构造函数隐式调用。|	方法要显式调用。
如果没有指定任何构造函数，java编译器提供一个默认构造函数。|	在任何情况下编译器都不会提供默认的方法调用。
构造函数名称必须与类名称相同。|	方法名称可以或可以不与类名称相同(随意)。

### 二 Java 继承
>继承是java面向对象编程技术的一块基石，因为它允许创建分等级层次的类。继承可以理解为一个对象从另一个对象获取属性的过程。

    Java中的继承是一种机制，表示为一个对象获取父对象的所有属性和行为。

- 在Java中继承是：可以创建基于现有类构建新的类。 当您从现有类继承时，就可以重复使用父类的方法和字段，也可以在继承的新类中添加新的方法和字段。

- 继承表示IS-A关系，也称为父子关系，是说:一个对象是另一个对象的一个分类。

---
    如果类A是类B的父类，而类B是类C的父类，我们也称C是A的子类，类C是从类A继承而来的。在Java中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类

    继承中最常使用的两个关键字是extends和implements。

    这两个关键字的使用决定了一个对象和另一个对象是否是IS-A(是一个)关系。

    通过使用这两个关键字，我们能实现一个对象获取另一个对象的属性。

    所有Java的类均是由java.lang.Object类继承而来的，所以Object是所有类的祖先类，而除了Object外，所有类必须有一个父类。

#### 1. 为什么在java中使用继承？
    对于方法覆盖(因此可以实现运行时的多态性)，提高代码可重用性。在Java中，子类可继承父类中的方法，而不需要重新编写相同的方法。但有时子类并不想原封不动地继承父类的方法，而是想作一定的修改，这就需要采用方法的重写(覆盖)。

#### 2. 继承的语法

```
class Subclass-name extends Superclass-name  
{  
   //methods and fields  
}
```

    extends关键字表示正在从现有类派生创建的新类。 “extends”的含义是增加功能。在Java的术语中，继承的类称为父类或超类，新类称为子或子类。

#### 3. java继承类型

##### 3.1. 单一继承示例

``` Java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class TestInheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.bark();
        d.eat();
    }
}

//执行上面代码得到以下结果 

barking...
eating...
```

##### 3.2 多级继承示例
``` Java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class BabyDog extends Dog {
    void weep() {
        System.out.println("weeping...");
    }
}

class TestInheritance2 {
    public static void main(String args[]) {
        BabyDog d = new BabyDog();
        d.weep();
        d.bark();
        d.eat();
    }
}

//执行上面代码得到以下结果 -

weeping...
barking...
eating...
```

##### 3.3 多级继承示例

``` Java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("meowing...");
    }
}

class TestInheritance3 {
    public static void main(String args[]) {
        Cat c = new Cat();
        c.meow();
        c.eat();
        // c.bark();//C.T.Error
    }
}

//执行上面代码得到以下结果 -

meowing...
eating...
```

>为什么在Java中不支持多重继承？

    为了降低复杂性并简化语言，Java中不支持多重继承。想象一个：A，B和C是三个类。 C类继承A和B类。 如果A和B类有相同的方法，并且从子类对象调用它，A或B类的调用方法会有歧义。
 
```
class A {
    void msg() {
        System.out.println("Hello");
    }
}

class B {
    void msg() {
        System.out.println("Welcome");
    }
}

class C extends A,B
{//suppose if it were  

 Public Static

    void main(String args[]) {
        C obj = new C();
        obj.msg();// Now which msg() method would be invoked?
    }
}
```
      编译时错误比运行时错误好，如果继承2个类，java会在编译时报告错误。 所以无论子类中是否有相同的方法，都会有报告编译时错误。例如下面的代码是编译出错的。

### 三 聚合
>如果一个类有一个类的实体引用(类中的类)，则它称为聚合。 聚合表示HAS-A关系。

    何时使用聚合？
    
- 当没有is-a关系时，通过聚合也能最好地实现代码重用。
- 只有在所涉及的对象的整个生命周期内维持关系为is-a时，才应使用继承; 否则，聚合是最好的选择。

``` Java
//Address.java
public class Address {
    String city, province;

    public Address(String city, String province) {
        this.city = city;
        this.province = province;
    }

}

//Emp.java
public class Emp {
    int id;
    String name;
    Address address;

    public Emp(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(id + " " + name);
        System.out.println(address.city + " " + address.province);
    }

    public static void main(String[] args) {
        Address address1 = new Address("广州", "广东");
        Address address2 = new Address("海口", "海南");

        Emp e = new Emp(111, "Wang", address1);
        Emp e2 = new Emp(112, "Zhang", address2);

        e.display();
        e2.display();

    }
}

//执行上面代码，得到以下结果 -

111 Wang
广州 广东
112 Zhang
海口 海南
```

### 四 重写(Override)与重载(Overload)

#### 1.重写
>如果子类中具有与父类中声明相同的方法，在java中称为方法覆盖。换句话说，如果子类提供了由其父类提供的其中一个方法的特定实现，则它被称为方法覆盖。所以方法覆盖有两个前提条件：继承和子父类中方法名称相同。

    Java方法覆盖的用法

- 方法重写用于提供有别于超类提供的方法的特定实现。
- 方法重写用于运行时多态性。

---  
    Java方法覆盖的规则

- 方法必须与父类中的名称相同。
- 方法必须具有与父类中相同的参数。
- 必须是IS-A关系(继承)。

##### 1.1 理解没有方法覆盖的问题
``` Java
//如果在程序中不使用方法覆盖可能面临的问题。

class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {

    public static void main(String args[]) {
        Bike obj = new Bike();
        obj.run();
    }
}

//执行上面代码，输出结果如下 -

Vehicle is running
```
    问题是，必须在子类中提供一个run()方法，这就是为什么要使用方法覆盖。
``` Java
//方法覆盖的示例
//在下面的这个例子中，在父类中和子类中都定义了run方法，但子类中有一些特定的实现。 方法的名称和参数是相同的，并且类之间有IS-A关系，因此这里run方法被覆盖了。

class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike2 extends Vehicle {
    void run() {
        System.out.println("Bike is running safely");
    }

    public static void main(String args[]) {
        Bike2 obj = new Bike2();
        obj.run();
    }
}

//执行输出结果如下 -

Bike is running safely
```

>可以覆盖静态方法吗？

    这是不可以的，静态方法不能被覆盖。
    因为静态方法是绑定类，而实例方法绑定对象。 静态属于类区域，实例属于堆区域。

#### 2. 重载
>如果一个类中有多个具有相同名称但参数不同的方法，则称为方法重载。如果只需要执行一个操作，具有相同的方法名称将增加程序的可读性。
假设必须执行给定数值的添加操作(求和)，但是参数的数量不固定，如果为两个参数编写add1(int，int)方法，为三个参数编写add2(int，int，int)方法，可能对其他程序员来说很难理解这样的方法的行为，因为它的名称不同。
因此，执行方法重载能比较容易理解程序含义。

    方法重载的优点

- 方法重载提高了程序的可读性。
- 重载方法不同的方式

---
    在java中重载方法有两种方式，它们分别是：

- 通过改变参数的数量
- 通过更改数据类型

---
    注意：在java中，只通过更改方法的返回类型来实现方法重载是不可以的。


``` Java
class Adder {
    static int add(int a, int b) {
        return a + b;
    }
    static int add(int a, int b, int c) {
        return a + b + c;
    }
    static double add(double a, double b) {
        return a + b;
    }
}

class TestOverloading2 {
    public static void main(String[] args) {
        System.out.println(Adder.add(11, 11));
        System.out.println(Adder.add(12.3, 12.6));
    }
}

//上面代码执行后，输出结果如下 -

22
24.9
```

>为什么方法重载不能通过更改方法的返回类型？

    在java中，只通过改变方法的返回类型来实现方法重载是不可能的，因为这样具有模糊性。 让我们来看看模糊性是怎么样发生的：

``` Java
class Adder {
    static int add(int a, int b) {
        return a + b;
    }

    static double add(int a, int b) {
        return a + b;
    }
}

class TestOverloading3 {
    public static void main(String[] args) {
        System.out.println(Adder.add(11, 11));// ambiguity
    }
}

//上面代码执行后，输出结果如下 -

Compile Time Error: method add(int,int) is already defined in class Adder
Java
```

System.out.println(Adder.add(11,11));//这里，java如何确定应该调用哪个sum()方法？

    注意：编译时错误优于运行时错误。 所以，如果你声明相同的方法具有相同的参数，java编译器渲染编译器时间错误。

>可以重载java main()方法吗？

    这是完全可以的。 可以通过方法重载在类中有任意数量的main方法。 但是JVM调用main()方法，它只接收字符串数组作为参数。 让我们来看一个简单的例子：

``` Java
class TestOverloading4{  
    public static void main(String[] args){System.out.println("main with String[]");}  
    public static void main(String args){System.out.println("main with String");}  
    public static void main(){System.out.println("main without args");}  
}

//上面代码执行后，输出结果如下 -

main with String[]
```

#### 方法重载和方法重写的区别
|方法重载|方法重写|
 :-: | -: |
方法重载用于提高程序的可读性。|	方法重写用于提供已经由其超类提供的方法的特定实现。
方法重载在类内执行。|	方法重写发生在具有IS-A(继承)关系的两个类中。
在方法重载的情况下，参数必须不同。|	在方法重写的情况下，参数必须相同。
方法重载是编译时多态性的例子。|	方法重写/覆盖是运行时多态性的例子。
方法重载不能仅通过改变方法的返回类型来执行。方法重载中的返回类型可以相同或不同。 但是必须更改参数类型。|	在方法重写/覆盖中返回类型必须相同或协变。

### 五 多态
>多态是同一个行为具有多个不同表现形式或形态的能力。

    多态性是对象多种表现形式的体现。

    比如我们说"宠物"这个对象，它就有很多不同的表达或实现，比如有小猫、小狗、蜥蜴等等。那么我到宠物店说"请给我一只宠物"，服务员给我小猫、小狗或者蜥蜴都可以，我们就说"宠物"这个对象就具备多态性。

``` Java
//例子
public interface Vegetarian{}
public class Animal{}
public class Deer extends Animal implements Vegetarian{}
```

    因为Deer类具有多重继承，所以它具有多态性。以上实例解析如下：

- 一个 Deer IS-A（是一个） Animal
- 一个 Deer IS-A（是一个） Vegetarian
- 一个 Deer IS-A（是一个） Deer
- 一个 Deer IS-A（是一个）Object

---
    在Java中，所有的对象都具有多态性，因为任何对象都能通过IS-A测试的类型和Object类。

    1. 访问一个对象的唯一方法就是通过引用型变量。

    2. 引用型变量只能有一种类型，一旦被声明，引用型变量的类型就不能被改变了。

    3. 引用型变量不仅能够被重置为其他对象，前提是这些对象没有被声明为final。还可以引用和它类型相同的或者相兼容的对象。它可以声明为类类型或者接口类型。

``` Java
//当我们将引用型变量应用于Deer对象的引用时，下面的声明是合法的：

Deer d = new Deer();
Animal a = d;
Vegetarian v = d;
Object o = d;
//所有的引用型变量d,a,v,o都指向堆中相同的Deer对象。
```

#### 虚方法
>当子类对象调用重写的方法时，调用的是子类的方法，而不是父类中被重写的方法。

    要想调用父类中被重写的方法，则必须使用关键字super。

``` Java
public class Employee
{
   private String name;
   private String address;
   private int number;
   public Employee(String name, String address, int number)
   {
      System.out.println("Constructing an Employee");
      this.name = name;
      this.address = address;
      this.number = number;
   }
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + this.name
       + " " + this.address);
   }
   public String toString()
   {
      return name + " " + address + " " + number;
   }
   public String getName()
   {
      return name;
   }
   public String getAddress()
   {
      return address;
   }
   public void setAddress(String newAddress)
   {
      address = newAddress;
   }
   public int getNumber()
   {
     return number;
   }
}
```

``` Java
public class Salary extends Employee
{
   private double salary; //Annual salary
   public Salary(String name, String address, int number, double
      salary)
   {
       super(name, address, number);
       setSalary(salary);
   }
   public void mailCheck()
   {
       System.out.println("Within mailCheck of Salary class ");
       System.out.println("Mailing check to " + getName()
       + " with salary " + salary);
   }
   public double getSalary()
   {
       return salary;
   }
   public void setSalary(double newSalary)
   {
       if(newSalary >= 0.0)
       {
          salary = newSalary;
       }
   }
   public double computePay()
   {
      System.out.println("Computing salary pay for " + getName());
      return salary/52;
   }
}
```

    现在我们仔细阅读下面的代码，尝试给出它的输出结果：

``` Java
public class VirtualDemo
{
   public static void main(String [] args)
   {
      Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
      Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
      System.out.println("Call mailCheck using Salary reference --");
      s.mailCheck();
      System.out.println("\n Call mailCheck using Employee reference--");
      e.mailCheck();
    }
}

//以上实例编译运行结果如下：
Constructing an Employee
Constructing an Employee
Call mailCheck using Salary reference --
Within mailCheck of Salary class
Mailing check to Mohd Mohtashim with salary 3600.0

Call mailCheck using Employee reference--
Within mailCheck of Salary class
Mailing check to John Adams with salary 2400.0
```

    例子中，我们实例化了两个Salary对象。一个使用Salary引用s，另一个使用Employee引用。
    编译时，编译器检查到mailCheck()方法在Salary类中的声明。

    在调用s.mailCheck()时，Java虚拟机(JVM)调用Salary类的mailCheck()方法。

    因为e是Employee的引用，所以调用e的mailCheck()方法则有完全不同的结果。

    当编译器检查e.mailCheck()方法时，编译器检查到Employee类中的mailCheck()方法。

    在编译的时候，编译器使用Employee类中的mailCheck()方法验证该语句， 但是在运行的时候，Java虚拟机(JVM)调用的是Salary类中的mailCheck()方法。

    该行为被称为虚拟方法调用，该方法被称为虚拟方法。

    Java中所有的方法都能以这种方式表现，借此，重写的方法能在运行时调用，不管编译的时候源代码中引用变量是什么数据类型。

### 六 抽象类
>在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。

    抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
    
    由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。也是因为这个原因，通常在设计阶段决定要不要设计抽象类。
    
    父类包含了子类集合的常见的方法，但是由于父类本身是抽象的，所以不能使用这些方法。

### 七 封装
>在面向对象程式设计方法中，封装（英语：Encapsulation）是指，一种将抽象性函式接口的实作细节部份包装、隐藏起来的方法。

    封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。

    要访问该类的代码和数据，必须通过严格的接口控制。

    封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。

### 八 接口
>接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。

    接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。类描述对象的属性和方法。接口则包含类要实现的方法。

    除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。

    接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。另外，在Java中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象。

---
    接口与类相似点：

- 一个接口可以有多个方法。
- 接口文件保存在.java结尾的文件中，文件名使用接口名。
- 接口的字节码文件保存在.class结尾的文件中。
- 接口相应的字节码文件必须在与包名称相匹配的目录结构中。 

---
    接口与类的区别：
- 接口不能用于实例化对象。
- 接口没有构造方法。
- 接口中所有的方法必须是抽象方法。
- 接口不能包含成员变量，除了static和final变量。
- 接口不是被类继承了，而是要被类实现。
- 接口支持多重继承。

#### 8.1 接口的声明

```
[可见度] interface 接口名称 [extends 其他的类名] {
        // 声明变量
        // 抽象方法
}

public interface NameOfInterface
{
   //任何类型 final, static 字段
   //抽象方法
}
```
    接口有以下特性：
- 接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
- 接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键子。
- 接口中的方法都是公有的。

#### 8.2 接口的实现
>当类实现接口的时候，类要实现接口中所有的方法。否则，类必须声明为抽象的类。

    类使用implements关键字实现接口。在类声明中，Implements关键字放在class声明后面。

``` Java
//实现一个接口的语法，可以使用这个公式：

... implements 接口名称[, 其他接口, 其他接口..., ...] ...

//实例：
public class MammalInt implements Animal{

   public void eat(){
      System.out.println("Mammal eats");
   }

   public void travel(){
      System.out.println("Mammal travels");
   } 

   public int noOfLegs(){
      return 0;
   }

   public static void main(String args[]){
      MammalInt m = new MammalInt();
      m.eat();
      m.travel();
   }
} 

//以上实例编译运行结果如下:
Mammal eats
Mammal travels
```
    重写接口中声明的方法时，需要注意以下规则：

- 类在实现接口的方法时，不能抛出强制性异常，只能在接口中，或者继承接口的抽象类中抛出该强制性异常。
- 类在重写方法时要保持一致的方法名，并且应该保持相同或者相兼容的返回值类型。
- 如果实现接口的类是抽象类，那么就没必要实现该接口的方法。

---
    在实现接口的时候，也要注意一些规则：

- 一个类可以同时实现多个接口。
- 一个类只能继承一个类，但是能实现多个接口。
- 一个接口能继承另一个接口，这和类之间的继承比较相似。

#### 8.3 接口的继承
>一个接口能继承另一个接口，和类之间的继承方式比较相似。接口的继承使用extends关键字，子接口继承父接口的方法。

    在Java中，类的多重继承是不合法，但接口允许多重继承，。

``` Java
//在接口的多重继承中extends关键字只需要使用一次，在其后跟着继承接口:

public interface Hockey extends Sports, Event
```
#### 8.4 标记接口
>最常用的继承接口是没有包含任何方法的接口。

    标识接口是没有任何方法和属性的接口.它仅仅表明它的类属于一个特定的类型,供其他代码来测试允许做一些事情。

    标识接口作用：简单形象的说就是给某个对象打个标（盖个戳），使对象拥有某个或某些特权。

``` Java
//例如：java.awt.event包中的MouseListener接口继承的java.util.EventListener接口定义如下：
package java.util;
public interface EventListener
{}
```

    没有任何方法的接口被称为标记接口。标记接口主要用于以下两种目的：

- 建立一个公共的父接口：
        
        正如EventListener接口，这是由几十个其他接口扩展的Java API，你可以使用一个标记接口来建立一组接口的父接口。例如：当一个接口继承了EventListener接口，Java虚拟机(JVM)就知道该接口将要被用于一个事件的代理方案。

- 向一个类添加数据类型：
    
        这种情况是标记接口最初的目的，实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，但是该类通过多态性变成一个接口类型。
