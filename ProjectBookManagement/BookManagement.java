package ProjectBookManagement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tftitle;
	private JTextField tfauthor;
	private JTextField tfprice;
	private JTextField tfquantity;
	private bookclass bookShop;
	private DefaultTableModel tableModel;
	private JTable table;
	
	private void clearTextFields() {
		tfid.setText("");
		tftitle.setText("");
		tfauthor.setText("");
		tfprice.setText("");
		tfquantity.setText("");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagement frame = new BookManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BookManagement() {
		
		bookclass bookShop = new bookclass(100, "C:\\Users\\user\\Desktop\\price.txt");

		
		setTitle("Book Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblprogram = new JLabel("BOOK MANAGEMENT");
		lblprogram.setHorizontalAlignment(SwingConstants.CENTER);
		lblprogram.setFont(new Font("Arial", Font.BOLD, 30));
		lblprogram.setBounds(335, 11, 314, 36);
		contentPane.add(lblprogram);
		
		JLabel lbltitle = new JLabel("Title :");
		lbltitle.setFont(new Font("Arial", Font.BOLD, 15));
		lbltitle.setBounds(22, 225, 90, 14);
		contentPane.add(lbltitle);
		
		JLabel lblauthor = new JLabel("Author :");
		lblauthor.setFont(new Font("Arial", Font.BOLD, 15));
		lblauthor.setBounds(22, 262, 90, 14);
		contentPane.add(lblauthor);
		
		JLabel lblprice = new JLabel("Price :");
		lblprice.setFont(new Font("Arial", Font.BOLD, 15));
		lblprice.setBounds(22, 300, 64, 14);
		contentPane.add(lblprice);
		
		JLabel lblid = new JLabel("Book ID :");
		lblid.setFont(new Font("Arial", Font.BOLD, 15));
		lblid.setBounds(22, 186, 90, 14);
		contentPane.add(lblid);
		
		JLabel lblquantity = new JLabel("Quantity :");
		lblquantity.setFont(new Font("Arial", Font.BOLD, 15));
		lblquantity.setBounds(22, 337, 107, 14);
		contentPane.add(lblquantity);
		
		tfid = new JTextField();
		tfid.setBounds(107, 181, 218, 26);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		tftitle = new JTextField();
		tftitle.setColumns(10);
		tftitle.setBounds(107, 220, 218, 26);
		contentPane.add(tftitle);
		
		tfauthor = new JTextField();
		tfauthor.setColumns(10);
		tfauthor.setBounds(107, 257, 218, 26);
		contentPane.add(tfauthor);
		
		tfprice = new JTextField();
		tfprice.setColumns(10);
		tfprice.setBounds(107, 295, 218, 26);
		contentPane.add(tfprice);
		
		tfquantity = new JTextField();
		tfquantity.setColumns(10);
		tfquantity.setBounds(107, 332, 218, 26);
		contentPane.add(tfquantity);
		
		
		tableModel = new DefaultTableModel();
		
		// Table
				tableModel = new DefaultTableModel();
				JTable table = new JTable(tableModel);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(364, 123, 596, 235);

				// Panel for table and buttons
				JPanel tablePanel = new JPanel();
				tablePanel.setBounds(0, 0, 984, 461);
				tablePanel.setLayout(null);
				tablePanel.add(scrollPane);

				// Add panels to the main frame
				getContentPane().add(tablePanel, BorderLayout.CENTER);
				
				JButton btndelete = new JButton("Delete Book");
				btndelete.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        int bookId = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the book ID to delete:"));
				        Stack<Integer> stack = new Stack<>();
				        for (int i = 0; i < tableModel.getRowCount(); i++) {
				            int id = (int) tableModel.getValueAt(i, 0);
				            if (id == bookId) {
				                stack.push(i);
				            }
				        }
				        if (!stack.isEmpty()) {
				            int rowIndex = stack.pop();
				            tableModel.removeRow(rowIndex);
				        }
				        clearTextFields();
				    }
				});


				btndelete.setBounds(364, 370, 126, 26);
				tablePanel.add(btndelete);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sort", "Sort by Title", "Sort by Price"}));
				comboBox.setBounds(811, 90, 149, 22);
				tablePanel.add(comboBox);
				
				JButton btnadd = new JButton("Add Book");
				btnadd.setBounds(196, 370, 130, 26);
				tablePanel.add(btnadd);
				btnadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int bookId = Integer.parseInt(tfid.getText());
						String title = tftitle.getText();
						String author = tfauthor.getText();
						double price = Double.parseDouble(tfprice.getText());
						int quantity = Integer.parseInt(tfquantity.getText());

						bookShop.addBook(bookId, title, author, price, quantity);

						// Add the book to the table
						Object[] rowData = { bookId, title, author, price, quantity };
						tableModel.addRow(rowData);

						clearTextFields();
						

					}
				});
				
				
				tableModel.addColumn("Book ID");
				tableModel.addColumn("Title");
				tableModel.addColumn("Author");
				tableModel.addColumn("Price");
				tableModel.addColumn("Quantity");
				
				comboBox.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	 String pilihan = (String) comboBox.getSelectedItem();
			                if (pilihan.equals("Sort by Title")) {
			                    tableModel = sortTableByTitle();
			                } else if (pilihan.equals("Sort by Price")) {
			                    tableModel = sortTableByPrice();
			                }
			                table.setModel(tableModel);
			            }
			        });

	}
	private int findRowIndexByBookId(int bookId) {
		for (int row = 0; row < tableModel.getRowCount(); row++) {
			int id = (int) tableModel.getValueAt(row, 0);
			if (id == bookId) {
				return row;
			}
		}
		return -1;
	}
	
		private DefaultTableModel sortTableByTitle() {
	        DefaultTableModel sortedTable = new DefaultTableModel();
	        sortedTable.addColumn("Book ID");
	        sortedTable.addColumn("Title");
	        sortedTable.addColumn("Author");
	        sortedTable.addColumn("Price");
	        sortedTable.addColumn("Quantity");

	        for (int i = 0; i < tableModel.getRowCount(); i++) {
	            Object[] row = new Object[5];
	            for (int j = 0; j < 5; j++) {
	                row[j] = tableModel.getValueAt(i, j);
	            }
	            sortedTable.addRow(row);
	        }
	        for (int i = 0; i < sortedTable.getRowCount() - 1; i++) {
	            for (int j = i + 1; j < sortedTable.getRowCount(); j++) {
	                if (((String) sortedTable.getValueAt(i, 1)).compareTo((String) sortedTable.getValueAt(j, 1)) > 0) {
	                	Object[] temp = new Object[] { tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 1), tableModel.getValueAt(i, 2),
	                			tableModel.getValueAt(i, 3), tableModel.getValueAt(i, 4) };
	                	
	                    sortedTable.removeRow(i);
	                    sortedTable.addRow(temp);
	                }
	            }
	        }

	        return sortedTable;
	    }
	        
	        private DefaultTableModel sortTableByPrice() {
	            DefaultTableModel sortedTable = new DefaultTableModel();
	            sortedTable.addColumn("Book ID");
	            sortedTable.addColumn("Title");
	            sortedTable.addColumn("Author");
	            sortedTable.addColumn("Price");
	            sortedTable.addColumn("Quantity");

	            for (int i = 0; i < tableModel.getRowCount(); i++) {
	                Object[] row = new Object[5];
	                for (int j = 0; j < 5; j++) {
	                    row[j] = tableModel.getValueAt(i, j);
	                }
	                sortedTable.addRow(row);
	            }

	            for (int i = 0; i < sortedTable.getRowCount() - 1; i++) {
	                for (int j = i + 1; j < sortedTable.getRowCount(); j++) {
	                    if (((Double) sortedTable.getValueAt(i, 3)).compareTo((Double) sortedTable.getValueAt(j, 3)) > 0) {
	                    	Object[] temp = new Object[] { tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 1),
	                    			tableModel.getValueAt(i, 2), tableModel.getValueAt(i, 3), tableModel.getValueAt(i, 4) };
	                    	
	                        sortedTable.removeRow(i);
	                        sortedTable.addRow(temp);
	                    }
	                }
	            }

	            return sortedTable;
	        }
}

