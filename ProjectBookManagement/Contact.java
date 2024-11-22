package ProjectBookManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Contact extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfname;
	private JTextField tfnumber;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact frame = new Contact();
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
	public Contact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("Name");
		lblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblname.setBounds(10, 39, 130, 14);
		contentPane.add(lblname);
		
		JLabel lblcontact = new JLabel("Contact");
		lblcontact.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontact.setBounds(167, 11, 130, 14);
		contentPane.add(lblcontact);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumber.setBounds(10, 69, 130, 14);
		contentPane.add(lblNumber);
		
		tfname = new JTextField();
		tfname.setBounds(71, 36, 185, 20);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		tfnumber = new JTextField();
		tfnumber.setColumns(10);
		tfnumber.setBounds(71, 66, 185, 20);
		contentPane.add(tfnumber);
		
		JButton add = new JButton("ADD");
		add.setBounds(10, 100, 89, 23);
		contentPane.add(add);
		
		JButton delete = new JButton("DELETE");
		delete.setBounds(208, 100, 89, 23);
		contentPane.add(delete);
		
		JButton sort = new JButton("SORT");
		sort.setBounds(307, 100, 89, 23);
		contentPane.add(sort);
		
		JButton edit = new JButton("EDIT");
		edit.setBounds(109, 100, 89, 23);
		contentPane.add(edit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 154, 257, 96);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Contact"
			}
		));
		scrollPane.setColumnHeaderView(table);
	}
}
