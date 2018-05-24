import java.io.*;
/**
*file
*/
public class TestFile{

	//File对象是不可变的。创建后，它始终表示相同的路径名。当我们重命名文件时，旧的File对象仍然代表原始的路径名。

    //File对象表示路径名，而不是文件系统中的实际文件。

	public static void main(String[] args) throws IOException{
		// Create a File object
		File file = new File("dummy.txt");
		// Create a Dir object
		File newDir  = new File("\\temp");
		if (!newDir.exists()) {
			newDir.mkdir();
		}
        // Check for the file"s existence
		if (file.exists()) {
			System.out.println("The dummy.txt  file exists.");

		} else {
			System.out.println("The dummy.txt  file does  not  exist.");
			//创建文件
			boolean fileCreated  = file.createNewFile();
		}

		//我们还可以在默认的临时文件目录或目录中创建一个临时文件。
		//要在默认临时目录中创建临时文件，请使用File类的createTempFile()静态方法，该方法接受前缀和后缀以生成临时文件名。
		File  tempFile = File.createTempFile("abc", ".txt");

		//删除文件
		file..delete();
	}
}

/*File:

1. File类的对象是文件或目录的路径名的抽象表示。

2. 创建文件
   我们可以从中创建一个 File 对象

   - 路径名
     父路径名和子路径名
     URI（统一资源标识符）
     我们可以使用File类的以下构造函数之一创建一个文件：

     File(String pathname)
     File(File parent, String child)
     File(String parent, String child)
     File(URI uri)

     如果我们有一个文件路径名字符串test.txt，我们可以创建一个抽象路径名作为下面的代码。

     File dummyFile = new File("test.txt");
     名为test.txt的文件不必存在，以使用此语句创建File对象。

     dummyFile对象表示抽象路径名，它可能指向或可能不指向文件系统中的真实文件。

     File类有几个方法来处理文件和目录。

     使用File对象，我们可以创建新文件，删除现有文件，重命名文件，更改文件的权限等。

     File类中的isFile()和isDirectory()告诉File对象是否表示文件或目录。

   - 当前工作目录
     JVM的当前工作目录是根据我们如何运行java命令来设置的。

     我们可以通过读取user.dir系统属性来获取JVM的当前工作目录，如下所示：

     String  workingDir = System.getProperty("user.dir");
     使用System.setProperty()方法更改当前工作目录。

     System.setProperty("user.dir", "C:\\myDir");
     要在Windows上指定C:\\ test作为user.dir系统属性值，我们运行如下所示的程序：

     java -Duser.dir=C:\test your-java-class

   - 文件的存在
     我们可以使用File类的exists()方法检查File对象的抽象路径名是否存在。

     boolean fileExists = dummyFile.exists();

3. 路径
   绝对路径在文件系统上唯一标识文件。规范路径是唯一标识文件系统上文件的最简单路径。
   我们可以使用getAbsolutePath()和getCanonicalPath()方法来分别获得由File对象表示的绝对路径和规范路径。

4. 文件分隔符
   不同的操作系统使用不同的字符来分隔路径名中的两个部分。

   例如，Windows在路径名中使用反斜杠（\）作为名称分隔符，而UNIX使用正斜杠（/）。
   
   File类定义了一个名为分隔符Char的常量，它是系统相关的名称分隔符。

   我们可以使用File.separator Char常量来获取名称分隔符作为字符。

   File.separator 常量将我们的名称分隔符作为String。

   在程序中使用名称分隔符将使您的Java代码在不同的平台上工作。
*/