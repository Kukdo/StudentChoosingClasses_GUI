package exp3;

/**

 * @Author Kukdo

 * @Version 1.0

 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JList;
// print mode
public class Print extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Print dialog = new Print();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public Print() {
		setTitle("Print Classes");
		setBounds(100, 100, 650, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		//read infos from specific file
		{   	try {
			BufferedReader brs = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\numbers.txt"));
            String Student_num = brs.readLine();
            brs.close();
	        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kukdo\\Desktop\\Java\\Java实验\\实验5\\" + Student_num +".txt"));
	        String demo = br.readLine();
       	    br.close();
	        JLabel lblNewLabel = new JLabel("You have chosen classes below:");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
			contentPanel.add(lblNewLabel);
	        {   
	        	DefaultListModel listModel=new DefaultListModel(); 
	        	JList list = new JList(listModel);
	        	contentPanel.add(list);
	             String [] demoarray = demo.split(";");
	             for (int i=0; i<demoarray.length ;i++) {
	            	 //把读出来的课程信息添加到Jlist中
	         		listModel.addElement(demoarray[i]);
	             }
	        }
	        //System.out.println("读取txt文件数据：" + demo);
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
			});
		}
	}
	}
}
