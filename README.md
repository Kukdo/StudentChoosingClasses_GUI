# 计182 2018310781 姜志鹏
## 实验名称：学生选课系统设计
---
### 实验目的
#### 分析学生选课系统
#### 使用GUI窗体及其组件设计窗体界面
#### 完成学生选课过程业务逻辑编程
#### 基于文件保存并读取数据
#### 处理异常

---
### 业务要求
#### 1、	设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
#### 2、	基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
#### 3、	针对操作过程中可能会出现的各种异常，做异常处理
#### 4、	基于输入/输出编程，支持学生、课程、教师等数据的读写操作。

---
#### Main funtion: Using Gui to realize the aim of Student choosing class(ps.Teachers can also use admin's account to create classes for students to choose)
---
### 编译环境
#### java version "12.0.1" 2019-04-16
#### Java(TM) SE Runtime Environment (build 12.0.1+12)
#### Java HotSpot(TM) 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing)
---
#### Eclipse IDE for Enterprise Java Developers.
#### Version: 2019-06 (4.12.0)
#### Build id: 20190614-1200
---
### 操作步骤及核心代码：
#### 1.执行Login程序，如果是学生则选上Student，若是老师则选上Teacher，学生如果已经Create账号直接Login即可，未注册的学生需要先进行Create；老师通过管理员给的账号密码登陆，不可自己创建具有管理权限的账号；
##### 打开Eclipse，在顶部工具栏中选择Run，再选择Run Configuration，最后在Arugements中添加字符串（数组），之后在运行的时候编译器就会把字符串的内容传递给args，然后即可调用，传参位置如下：
~~~ 
public static void main(String[] args) 
~~~
##### 示例图：
![image1](https://github.com/Kukdo/Seven-words-poem/blob/master/images/1.PNG)
#### 2.利用循环将诗歌进行切片操作，并且添加标点符号
##### 主要利用循环操作，每七个字切片一次，然后加上逗号或者句号，实现代码如下：
~~~
//split model
	public static void printsplit(String strsplit) {
		for (int i = 0; i<strsplit.length(); i = i+7) {
			if( i%2 == 0 ){
				String split = strsplit.substring(i, i+7);
				System.out.print(split+ "，");			
			} 
			if( i%2 == 1 ){
				String split = strsplit.substring(i, i+7);
				System.out.print(split+ "。" + "\n");			
			} 
		}	
	}
~~~
##### 输出示例图：
![image2](https://github.com/Kukdo/Seven-words-poem/blob/master/images/2.PNG)
#### 3.根据用户输入的词统计词频
##### 输入通过BufferedReader的函数，而统计主要利用String的IndexOf和substring的方法，进而达到统计词出现的次数的功能，实现代码如下：
~~~
    	// input and Exception model
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        String str = null;
        while(true){
            try {
                System.out.println("Please type the word or words you want to count: " );
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("IO's type error!");
            }
            //System.out.print(str+"\n");
            break;
        }
        
	//count model
	public static int count(String srcStr, String findStr) {
		int count = 0;
		int index = 0;
		while ((index = srcStr.indexOf(findStr, index)) != -1) {// if key exists in str
			index = index + findStr.length();
			count++; // +1
		}
		return count;
	}
~~~
##### 例1：查找“三”出现的次数
![image3](https://github.com/Kukdo/Seven-words-poem/blob/master/images/3.PNG)
##### 例2：查找“三千”出现的次数
![image4](https://github.com/Kukdo/Seven-words-poem/blob/master/images/4.PNG)
##### 例3：查找“从此”出现的次数
![image5](https://github.com/Kukdo/Seven-words-poem/blob/master/images/5.PNG)

---
### 实验感想
#### 本次实验主要是针对字符串的实验，通过本次实验我掌握了字符串的部分操作，能够灵活的运用切片对字符串进行分割，以及对于字符串的子串的索引查询有了进一步的了解。相信通过本次实验，对于今后的数据处理操作会有很大的益处。本次实验较为简单，在理清基本思路之后便能大概构思出实现对应功能所需要的方法和函数。
#### 个人认为无论是什么编程语言，最基本的还是逻辑，然后才是各种语言的语法和方法。只要逻辑清晰，思路正确，代码的大体便成了型。再通过不断地调试，不断地改进，最终总会达到想要的效果。实际上每一次实验，每一次课程设计都是锻炼思维逻辑以及强化知识储备的过程。
---
### Author
#### Kukdo 
##### Ps. First time creating my own repository
#### Update Time: 2019-11-16 4:00 PM
