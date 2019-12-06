# 计182 2018310781 姜志鹏
## 综合实验名称：学生选课系统设计
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
#### 1.Login mode 执行Login程序，如果是学生则选上Student，若是老师则选上Teacher，学生如果已经Create账号直接Login即可，未注册的学生需要先进行Create；老师通过管理员给的账号密码登陆，不可自己创建具有管理权限的账号；
##### 核心代码如下：
~~~ 
public static void main(String[] args) 
~~~
##### Login mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Login.PNG)
#### 分支1 老师登陆成功
##### Admin Login 示例图
###### 注：默认设定的账号和密码都2018310781
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Admin_Login.PNG)
#### 1-1 进入Create mode，在对应的文本框填入对应信息之后点击Create Lessons即可创建成功，之后退出系统
##### 注：一次只能创建一门课，如果还需再创建请重新登陆系统的管理员账号
#### 核心代码如下：
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
##### Create mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Create.PNG)
##### 创建课程成功进行选课操作 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Chose_after_create.PNG)
#### 分支2 学生登陆成功
##### Student Login 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Student_Login.PNG)
#### 2-1. 进入Index mode，可选择三个mode，Chose，Exit以及Print；
##### Index mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Index.PNG)
##### 注：若无选择课程，则无法打印课程以及退课，因此应该优先进行选课操作
##### 2-分支1 进入Chose mode
##### 通过鼠标点击选择课程，然后点击Select即可选课成功
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
##### Chose mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Chose.PNG)
##### 选课成功示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Chose_Successfully.PNG)
##### 2-分支2 进入Exit mode
##### 通过鼠标点击选择要退的课程，然后点击Quit即可选课成功
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
##### Exit mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Exit.PNG)
##### 选中退出课程示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Exit_Chosen.PNG)
##### 退课成功示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Exit_Successfully.PNG)
##### 2-分支3 进入Print mode
##### 系统自动展示所有已经选择课程，点击OK或者右上角的叉都可退出Print mode以及选课系统
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
##### Print mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Print.PNG)
---
### 实验感想
#### 本次实验主要是针对GUI以及IO的实验，通过本次实验我掌握了GUI的设定（运用WindowsBuilder插件可大大提高设置效率），能够灵活的运用IO操作进行文件读取和输出操作，以及字符串的匹配，索引查询有了进一步的了解。除此之外，对于异常的处理也更加的熟练了。相信通过本次实验，对于今后的数据处理操作会有很大的益处。本次实验较为复杂，但是在理清基本思路之后便能大概构思出实现对应功能所需要的方法和函数。
#### 个人认为无论是什么编程语言，最基本的还是逻辑，然后才是各种语言的语法和方法。只要逻辑清晰，思路正确，代码的大体便成了型。再通过不断地调试，不断地改进，最终总会达到想要的效果。实际上每一次实验，每一次课程设计都是锻炼思维逻辑以及强化知识储备的过程。
---
### Author
#### Kukdo 
#### Update Time: 2019-12-6 4:00 PM
