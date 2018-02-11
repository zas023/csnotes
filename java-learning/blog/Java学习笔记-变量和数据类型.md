### Java 变量
>变量是在内存中分配的保留区域的名称。换句话说，它是内存位置的名称。这意味着它的值可以改变。

    在Java语言中，所有的变量在使用前必须声明。声明变量的基本格式如下：
```
type identifier [ = value][, identifier [= value] ...] ;
```
    格式说明：type为Java数据类型。identifier是变量名。可以使用逗号隔开来声明多个同类型变量。
    
```
int a=5;    // 这里 a就是一个变量。
```

#### 一、变量类型
    java中有三种类型的变量：
    
    1. 局部变量(Local)：在方法内声明的变量称为局部变量。
    2. 实例变量(Instance)：在类中声明但在方法外部的变量称为实例变量。但它不被声明为静态(未加static修辞符)。
    3. 静态变量(Static)：被声明为static的变量(加static修辞符)称为静态变量。它不能是局部的。
    
```
class A{  
    int a=5;//实例变量
    static int m=10;// 静态变量
    void method(){  
        int n=9;//局部变量
    }  
}
```
---
#### 二、局部变量
    1. 局部变量声明在方法、构造方法或者语句块中；
    2. 局部变量在方法、构造方法、或者语句块被执行的时候创建，当它们执行完成后，变量将会被销毁；
    3. 访问修饰符不能用于局部变量；
    4. 局部变量只在声明它的方法、构造方法或者语句块中可见；
    5. 局部变量是在栈上分配的。
    6. 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。

---
#### 三、实例变量
    1. 实例变量声明在一个类中，但在方法、构造方法和语句块之外；
    2. 当一个对象被实例化之后，每个实例变量的值就跟着确定；
    3. 实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
    4. 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息；
    5. 实例变量可以声明在使用前或者使用后；
    6. 访问修饰符可以修饰实例变量；
    7. 实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见；
    8. 实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
    9. 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObejectReference.VariableName。
    

---
#### 四、静态变量
>静态变量也称类变量，在类中以static关键字声明，但必须在方法、构造方法和语句块之外。
    
    1. 无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
    2. 静态变量除了被声明为常量外很少使用。常量是指声明为public/private，final和static类型的变量。常量初始化后不可改变。
    3. 静态变量储存在静态存储区。经常被声明为常量，很少单独使用static声明变量。
    4. 静态变量在程序开始时创建，在程序结束时销毁。
    5. 与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为public类型。
    6. 默认值和实例变量相似。数值型变量默认值是0，布尔型默认值是false，引用类型默认值是null。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
    7. 静态变量可以通过：ClassName.VariableName的方式访问。
    8. 类变量被声明为public static final类型时，类变量名称必须使用大写字母。如果静态变量不是public和final类型，其命名方式与实例变量以及局部变量的命名方式一致。

###Java 基本数据类型
>变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。
内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。
因此，通过定义不同类型的变量，可以在内存中储存整数、小数或者字符。

    数据类型表示要存储在变量中的不同类型的值。 在Java中，有两种类型的数据类型：
    1. **内置数据类型**
    2. **引用数据类型**

#### 一、内置数据类型
>Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
   

|数据类型         | 默认值           | 默认长度  |
| ------------- |:-------------:| -----:|
boolean|	false|	1 bit
char|	'\u0000'|	2 byte
byte|	0|	1 byte
short|	0|	2 byte
int|	0|	4 byte
long|	0L|	8 byte
float|	0.0f|	4 byte
double|	0.0d|	8 byte
   
###### (一) byte：

    byte数据类型是8位、有符号的，以二进制补码表示的整数；
      - 最小值是-128（-2^7）；
      - 最大值是127（2^7-1）；
      - 默认值是0；
      - byte类型用在大型数组中节约空间，主要代替整数，因为byte变量占用的空间只有int类型的四分之一；

###### (二) short：
    short数据类型是16位、有符号的以二进制补码表示的整数
    最小值是-32768（-2^15）；
    最大值是32767（2^15 - 1）；
    Short数据类型也可以像byte那样节省空间。一个short变量是int型变量所占空间的二分之一；
    默认值是0；
    
######(三) int：
    int数据类型是32位、有符号的以二进制补码表示的整数；
    最小值是-2,147,483,648（-2^31）；
    最大值是2,147,483,647（2^31 - 1）；
    一般地整型变量默认为int类型；
    默认值是0；
    
###### (四) long：
    long数据类型是64位、有符号的以二进制补码表示的整数；
    最小值是-9,223,372,036,854,775,808（-2^63）；
    最大值是9,223,372,036,854,775,807（2^63 -1）；
    这种类型主要使用在需要比较大整数的系统上；
    默认值是0L；
    exp: `long a = 100000L，long b = -200000L。`
    
###### (五) float：
    float数据类型是单精度、32位、符合IEEE 754标准的浮点数；
    float在储存大型浮点数组的时候可节省内存空间；
    默认值是0.0f；
    浮点数不能用来表示精确的值，如货币；

###### (六) double：
    double数据类型是双精度、64位、符合IEEE 754标准的浮点数；
    浮点数的默认类型为double类型；
    double类型同样不能表示精确的值，如货币；
    默认值是0.0d；

###### (七) boolean：
    boolean数据类型表示一位的信息；
    只有两个取值：true和false；
    这种类型只作为一种标志来记录true/false情况；
    默认值是false；

###### (八) char：
    char类型是一个单一的16位Unicode字符；
    最小值是’\u0000’（即为0）；
    最大值是’\uffff’（即为65,535）；
    char数据类型可以储存任何字符；

>注：为什么char在java中使用2个字节以及什么是\u0000 ？

    这是因为java使用Unicode系统而非ASCII码系统编码。 \u0000是Unicode系统的最低范围。

---
###### 案例
```
//测试原始数据类型
public class PrimitiveType{
    public static void main(String[] args) {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();
        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();
        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();
        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();
        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
            + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
            + (int) Character.MAX_VALUE);
    }
}  
```

```
//溢出
public class AddExample{  
    public static void main(String[] args){  
        int a=130;  
        byte b=(byte)a;  
        System.out.println(a);  //a=130
        System.out.println(b);  //b=-126
    }
}
```

```
//较低类型相加
public class AddExample{  
    public static void main(String[] args){  
        byte a=10;  
        byte b=10;  
        //byte c=a+b;
        //Compile Time Error: 因为a+b=20将会变成int类型 
        //错误: 不兼容的类型: 从int转换到byte可能会有损失
        byte c=(byte)(a+b);  
        System.out.println(c);  
    }
}
```

>实际上，JAVA中还存在另外一种基本类型void，它也有对应的包装类 java.lang.Void，不过我们无法直接对它们进行操作。

#### 二、引用类型
- 引用类型变量由类的构造函数创建，可以使用它们访问所引用的对象。这些变量在声明时被指定为一个特定的类型，比如Employee、Pubby等。变量一旦声明后，类型就不能被改变了。
- 对象、数组都是引用数据类型。
- 所有引用类型的默认值都是null。
- 一个引用变量可以用来引用与任何与之兼容的类型。

```
//例子：
Boy boy = new Boy(“Tom”);
```

---
### Java常量
    常量就是一个固定值。它们不需要计算，直接代表相应的值。

```
//常量指不能改变的量。 在Java中用final标志，声明方式和变量类似：
final double PI = 3.1415927;
```

    虽然常量名也可以用小写，但为了便于识别，通常使用大写字母表示常量。

```
//字面量可以赋给任何内置类型的变量。例如：
byte a = 68;
char a = 'A'
```

    byte、int、long、和short都可以用十进制、16进制以及8进制的方式来表示。

```
//当使用常量的时候，前缀0表明是8进制，而前缀0x代表16进制。例如：
int decimal = 100;
int octal = 0144;
int hexa =  0x64;
```
    和其他语言一样，Java的字符串常量也是包含在两个引号之间的字符序列。
```
//下面是字符串型字面量的例子：
"Hello World"
"two\nlines"
"\"This is in quotes\""
```

    字符串常量和字符常量都可以包含任何Unicode字符。
```
char a = '\u0001';
String a = "\u0001";
```

###### Java语言支持一些特殊的转义字符序列。

|符号         | 字符含义           |
| ------------- |:-------------:|
\n|	换行 (0x0a)
\r|	回车 (0x0d)
\f|	换页符(0x0c)
\b| 退格 (0x08)
\s|	空格 (0x20)
\t|	制表符
\"|	双引号
\'|	单引号
\ |反斜杠
\ddd| 八进制字符 (ddd)
\uxxxx|	16进制Unicode字符 (xxxx)
