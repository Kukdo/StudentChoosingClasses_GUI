package exp3;
//@author Kukdo
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Chose extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chose frame = new Chose();
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
	public Chose() {
		setTitle("Chose Classes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{185, 136, 0};
		gbl_contentPane.rowHeights = new int[]{51, 86, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Label label = new Label("Select Lesson\n\"You can only choose one class every time.\"");
		label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		DefaultListModel listModel=new DefaultListModel(); //new Model
		JList list = new JList(listModel); // new list
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0; // layout
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);
		//reader
		try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\classes_teachers.txt"));
            String demo = br.readLine();
            br.close();
            String [] demoarray = demo.split(";"); //use ; to split each sentence
            for (int i=0; i<demoarray.length ;i++) {
        		listModel.addElement(demoarray[i]); //roop to add into lists
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
		JButton btnNewButton = new JButton("Select");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
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
}
	}
