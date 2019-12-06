package exp3;
/**

 * @Author Kukdo

 * @Version 1.0

 */
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Button;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;

public class Exit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exit frame = new Exit();
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
	public Exit() {
		setTitle("Exit Classes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{809, 100, 0};
		gbl_contentPane.rowHeights = new int[]{53, 40, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Label label = new Label("Quit Lessons\n\"You can only quit one class every time.\"");
		label.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		label.setAlignment(Label.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		DefaultListModel listModel=new DefaultListModel(); 
		JList list = new JList(listModel);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);
		
		try {
			BufferedReader brs = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\numbers.txt"));
            String Student_num = brs.readLine();
            brs.close();
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\" + Student_num +".txt"));
            String demo = br.readLine();
            //System.out.println("读取txt文件数据：" + demo);
            br.close();
            String [] demoarray = demo.split(";");
            for (int i=0; i<demoarray.length ;i++) {
        		listModel.addElement(demoarray[i]);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

		Button button = new Button("Quit");
		button.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		contentPane.add(button, gbc_button);
		button.addActionListener(new ActionListener(){
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
				
				FileWriter writer; //writer
		        try {
		        	BufferedReader brs = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\numbers.txt"));
			        String Student_num = brs.readLine();
			        brs.close();
			        brs.close();
		        	File file =new File("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\" + Student_num +".txt");
		            if(!file.exists()) {
		                file.createNewFile();
		            }
		            FileWriter fileWriter =new FileWriter(file);
		            fileWriter.write(""); // overwrite
		            fileWriter.flush();
		            fileWriter.close();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
			       try {
			    	    BufferedReader brs = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\numbers.txt"));
			            String Student_num = brs.readLine();
			            brs.close();
			            brs.close();
			            writer = new FileWriter("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\" + Student_num +".txt",true);
			            for(int i = 0; i< rewrite.length; i++) {
			            	if(rewrite[i] != null) {
								//System.out.println(rewrite[i]);
								writer.append(rewrite[i]+";");
								}
			            }
				        writer.flush();
				        writer.close();
			       } catch (IOException e1) {
			             e1.printStackTrace();
			       }
				JOptionPane.showMessageDialog(null, "Successfully quit!"); //Tips
				System.exit(0);
	}
		});
	}

}
