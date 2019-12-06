package exp3;
//@author Kukdo
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setTitle("Index");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(0, 107, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Exit exit = new Exit();
				exit.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("Chose");
		btnNewButton_1.setBounds(339, 107, 97, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Chose chose = new Chose();
				chose.setVisible(true); 
			}
		});
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.setBounds(175, 107, 97, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.setVisible(true);
			}
		});
	}

}
