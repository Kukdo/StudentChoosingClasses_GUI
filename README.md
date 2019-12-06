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
##### 注：在登陆界面的基础上增加了一个管理员登陆的操作

---
#### Main funtion: Using Gui to realize the aim of Student choosing classes( Ps.Teachers can also use admin's account to create classes for students to choose)
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
### 0. Login mode 
#### 执行Login程序，如果是学生则选中Student，若是老师则选中Teacher，学生如果已经Create账号直接Login即可，未注册的学生需要先进行Create；老师通过管理员给的账号密码登陆，不可自己创建具有管理权限的账号；
##### 核心代码（登陆部分）如下：
~~~ 
//登陆成功触发事件
if(Number.getText().trim().equals(verify[j])&&
new String(Passwords.getPassword()).trim().equals(verify[j+1])){
JOptionPane.showMessageDialog(null, "Login Successfully");
setVisible(false);
Index index = new Index();
index.setVisible(true);	
}
~~~
##### Login mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Login.PNG)
---
### 分支1 老师登陆
##### Admin 登陆成功示例图：
###### 注：默认设定管理员的账号和密码都2018310781
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Admin_Login.PNG)
##### Admin 登陆输入为空示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Admin_null_login.PNG)
##### Admin 登陆失败示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Admin_loginfail.PNG)
##### Admin 创建失败示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Admin_create_fail.PNG)
### 1-1 进入Create mode，在对应的文本框填入对应信息之后点击Create Lessons即可创建成功，之后退出系统
##### 注：一次只能创建一门课，如果还需再创建请重新登陆系统的管理员账号
#### 核心代码（建立标签和文本框，获取输入信息部分）如下：
~~~
		// Create textField
		Label label_1 = new Label("Class Name: ");
		label_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		contentPane.add(label_1, gbc_label_1);
		
		TextField textField_1 = new TextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		//读取输入信息模块
		public void actionPerformed(ActionEvent e) {
				String s= textField.getText();
				String s1= textField_1.getText();
				String s2= textField_2.getText();
				String s3= textField_3.getText();
				String s4= textField_4.getText();
				String s5= textField_5.getText(); // get infos
				String s6 = "Number: "+ s + " Name: "+ s1 +" Place: "+ s2 +" Time: " + s3 +" Credit: "+ s4 + " Teacher: "+ s5+ ";"; //add together
//				System.out.println(s6);
				if(textField.getText().trim().length()==0||textField_1.getText().trim().length()==0||textField_2.getText().trim().length()==0||
						textField_3.getText().trim().length()==0||textField_4.getText().trim().length()==0||textField_5.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "内容不能为空");
				}
~~~
##### Create mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Create.PNG)
##### 创建课程成功进行选课操作 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Chose_after_create.PNG)
---
### 分支2 学生登陆
##### Student创建成功 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Student_create_account.PNG)
##### Student 登陆成功 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Student_Login.PNG)
##### Student 登陆输入为空 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Student_null_login.PNG)
##### Student 登陆失败 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Student_loginfail.PNG)
### 2-0 进入Index mode，可选择三个mode，Chose，Exit以及Print；
##### Index mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Index.PNG)
#### 核心代码（引入各个模块部分）如下：
~~~
//import Exit mode
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(0, 107, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Exit exit = new Exit();
				exit.setVisible(true);
			}
		});
		//import Chose mode
		JButton btnNewButton_1 = new JButton("Chose");
		btnNewButton_1.setBounds(339, 107, 97, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Chose chose = new Chose();
				chose.setVisible(true); 
			}
		});
		//import Print mode
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.setBounds(175, 107, 97, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.setVisible(true);
			}
~~~
##### 注：若无选择课程，则无法打印课程以及退课，因此应该优先进行选课操作
---
### 2-分支1 进入Chose mode
##### 通过鼠标点击选择课程，然后点击Select即可选课成功
#### 核心代码（获取用户选定的课程信息部分）如下：
~~~
			public void actionPerformed(ActionEvent e) {
				String chosen = (String)list.getSelectedValue()+";"; //Object to String with ";"
				//System.out.println(chosen);
				 FileWriter writer; // writer
			        try {
			        	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\numbers.txt"));
			            String Student_num = br.readLine();
			            br.close();
			            writer = new FileWriter("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\" + Student_num +".txt",true);		            
			            writer.append(chosen); // + append
			            writer.flush();
			            writer.close();
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
					JOptionPane.showMessageDialog(null, "Successfully choose!"); //Tips
				    System.exit(0);
	}
		});
~~~
##### Chose mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Chose.PNG)
##### 选课成功示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Chose_Successfully.PNG)
---
### 2-分支2 进入Exit mode
##### 通过鼠标点击选择要退的课程，然后点击Quit即可选课成功
#### 核心代码（获取用户选定的退课对象部分）如下：
~~~
			public void actionPerformed(ActionEvent e) { // delete element from Lists
				DefaultListModel model = (DefaultListModel) list.getModel(); 
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex); // remove it
				} 
				String[] rewrite = new String[20]; //set String arrays
				for(int i = 0; i< list.getModel().getSize();i++){
		            //System.out.println(list.getModel().getElementAt(i));
		            rewrite[i] = (String) list.getModel().getElementAt(i);
		        } //write list's elements into rewrite String[]
~~~
##### Exit mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Exit%20mode.PNG)
##### 选中退出课程示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Exit_Chosen.PNG)
##### 退课成功示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Exit_Successfully.PNG)
---
### 2-分支3 进入Print mode
##### 系统自动展示(打印)所有已经选择课程，点击OK或者右上角的叉都可退出Print mode以及选课系统
#### 核心代码（输出信息部分）如下：
~~~
    	DefaultListModel listModel=new DefaultListModel(); 
	        	JList list = new JList(listModel);
	        	contentPanel.add(list);
	             String [] demoarray = demo.split(";");
	             for (int i=0; i<demoarray.length ;i++) {
	            	 //把读出来的课程信息添加到Jlist中
	         		listModel.addElement(demoarray[i]);
	             }
~~~
##### Print mode 示例图：
![image](https://github.com/Kukdo/StudentChoosingClasses_GUI/blob/master/src/pics/Print.PNG)
---
### 实验感想
#### 本次实验主要是针对GUI以及IO的实验，通过本次实验我掌握了GUI的编写（运用WindowsBuilder插件可大大提高设置效率），能够灵活的运用IO操作进行文件读取和输出操作，以及字符串的匹配，索引查询有了进一步的了解。其实本次实验如果运用数据库的话，可能会变得简单一些。除此之外，我个人对于异常的处理也更加的熟练了。相信通过本次综合性实验，对于今后的数据处理以及管理会有很大的益处。本次实验较为复杂，但是在理清基本思路之后便能大概构思出实现对应功能所需要的方法和函数。
#### 个人认为无论是什么编程语言，最基本的还是逻辑，还需要开阔自己的思路，想要实现一个功能但不知道如何实现就应该去网上收集资料，在理清总体思路之后，再进行实际编程操作，以免手忙脚乱。再针对实际编程中的问题不断调试和优化，最终到达自己想要实现的目的。
---
### 学习感想
#### Java是一门面向对象性的语言，它所具有的封装性，继承性和多态性是关键所在。以及了解它的历史和它与C++的不同也是很重要的一部分。对于程序员来说，其实掌握Java的基础也是走向是未来的必经之路。经过了这几周的学习以及实验课，我对于如何完成一个项目有了更好的理解，其实本质上与平常解决问题无异，只是把自己的思想转化成了编程语言而已。我个人认为编写代码其实就是一个流程。首先，分析所需；第二，模拟思路；第三，上机写代码并进行调试；第四，针对出现的问题进行修正（通过各种渠道获取自己想要的材料，修正后达到的目的）；第五，验证代码是否符合要求，进行多次调试，如果还有问题再回到第四步，直至完成。通过Python的学习我得到的不仅仅是知识的巩固，更重要的其实是自主学习能力，分析能力，解决问题能力以及逻辑思考能力。比如未达到实验效果，然后出了问题，了解问题所在之后如何解决，用什么途径解决，需要借助什么资源去解决问题，是否解决问题，是否需要再次验证等。总的来说，更为重要的是独立思考能力，时代在进步，技术也在提升。关于Java的学习也要继续努力，遇到不会的要及时通过各种途径去学习，全球视野，终身学习。
#### 最后还是要感谢教了我近一个学期的Java老师，学习期间有困惑的时候老师都亲切并且耐心地告诉了我如何解决。在这之后虽然Java已经结课，考试也结束了。但总归还是有那么一句话：“师傅领进门，修行靠个人"。
---
### Author
#### Kukdo 
#### Update Time: 2019-12-06 5:00 PM
