package exp3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Number;
	private JPasswordField Passwords;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Student");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 0;
		contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Teacher");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 0;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		  
		JLabel lblNewLabel = new JLabel("Number");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		Number = new JTextField();
		GridBagConstraints gbc_Number = new GridBagConstraints();
		gbc_Number.gridwidth = 2;
		gbc_Number.gridheight = 2;
		gbc_Number.insets = new Insets(0, 0, 5, 0);
		gbc_Number.fill = GridBagConstraints.BOTH;
		gbc_Number.gridx = 1;
		gbc_Number.gridy = 1;
		contentPane.add(Number, gbc_Number);
		Number.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Passwords = new JPasswordField();
		GridBagConstraints gbc_Passwords = new GridBagConstraints();
		gbc_Passwords.gridwidth = 2;
		gbc_Passwords.gridheight = 2;
		gbc_Passwords.insets = new Insets(0, 0, 5, 0);
		gbc_Passwords.fill = GridBagConstraints.BOTH;
		gbc_Passwords.gridx = 1;
		gbc_Passwords.gridy = 3;
		contentPane.add(Passwords, gbc_Passwords);
		Passwords.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= Number.getText();
			// get infos
				 if(Number.getText().trim().length()==0||new String(Passwords.getPassword()).trim().length()==0){
						JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
						return;
						}
				String s0 = s + "]" + new String(Passwords.getPassword()) + ";"; //add together
//				System.out.println(s0);
			    FileWriter writer;
			    // File operate
		        try {

		            writer = new FileWriter("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\accounts.txt",true);
		            writer.append(s0); // + append 
		            writer.flush();
		            writer.close();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				JOptionPane.showMessageDialog(null, "Successfully Create Account!");
			    System.exit(0);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							try {
							    FileWriter numbers;
							    String s= Number.getText();
//							    String pass = new String(Passwords.getPassword());
					            numbers = new FileWriter("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\numbers.txt");
					            numbers.write(s); // + overwrite 
					            numbers.flush();
					            numbers.close();
					            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\accounts.txt"));
					            String demo = br.readLine();
					            br.close();
					            String [] demoarray = demo.split(";"); //use ; to split each sentence
					            if(Number.getText().trim().length()==0||new String(Passwords.getPassword()).trim().length()==0){
									JOptionPane.showMessageDialog(null, "Number&Password can't be empty");
									return;
								}
					            if(!(Number.getText().trim().length()==0)&&!(new String(Passwords.getPassword()).trim().length()==0)){
				        		if(rdbtnNewRadioButton.isSelected()){
				        		if(Number.getText().trim().equals("2018310781")&&
				        				new String(Passwords.getPassword()).trim().equals("2018310781")){					 				        	
								JOptionPane.showMessageDialog(null, "Admin login successfully");
								   setVisible(false);
						           Create create = new Create();
						           create.setVisible(true);						           
				        		}
				        		else {
				        			JOptionPane.showMessageDialog(null, "Admin Login fail");
				        		}
				        		}
				        		if(rdbtnNewRadioButton_1.isSelected()){
				        		jzp:
					            for (int i=0; i<demoarray.length ;i++) {
//					            	System.out.println(demoarray[i]); 
					        		String [] verify = demoarray[i].split("]");					        		
					        		 for (int j=0; j<verify.length ;j=j+2) {
//					            	System.out.println(verify[j]);
					        			if(Number.getText().trim().equals(verify[j])&&
					        					new String(Passwords.getPassword()).trim().equals(verify[j+1])){					 				        	
										JOptionPane.showMessageDialog(null, "Login Successfully");
										setVisible(false);
							            Index index = new Index();
							            index.setVisible(true);	
							            break jzp;
					        			}
					        			if(j == verify.length-2) {
							        		 JOptionPane.showMessageDialog(null, "Name or Password Error");
							        		 return;
					        			}
					            }
							}					        
					    }
							}
							}
						catch (IOException e1) {
							      e1.printStackTrace();
					        }
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
