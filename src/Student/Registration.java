package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registration {

	private JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField cont;
	private JTextField prog;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 744, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(10, 11, 708, 538);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setBounds(10, 153, 122, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Reg No");
		lblStudentId.setBounds(10, 115, 122, 27);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setForeground(new Color(255, 255, 255));
		panel.add(lblStudentId);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setBounds(10, 191, 122, 27);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContactNo.setForeground(new Color(255, 255, 255));
		panel.add(lblContactNo);
		
		JLabel lblNewLabel_2_1 = new JLabel("Program");
		lblNewLabel_2_1.setBounds(10, 229, 122, 27);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_2_1);
		
		name = new JTextField();
		name.setBounds(127, 153, 189, 27);
		panel.add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setBounds(127, 115, 189, 27);
		id.setColumns(10);
		panel.add(id);
		
		cont = new JTextField();
		cont.setBounds(127, 191, 189, 27);
		cont.setColumns(10);
		panel.add(cont);
		
		prog = new JTextField();
		prog.setBounds(127, 229, 189, 27);
		prog.setColumns(10);
		panel.add(prog);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 57, 345, 431);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
						id.setText(model.getValueAt(i, 0).toString());
						name.setText(model.getValueAt(i, 1).toString());
						cont.setText(model.getValueAt(i, 2).toString());
						prog.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 120, 215), null, new Color(0, 120, 215), null), null));
		table.setForeground(SystemColor.textHighlightText);
		table.setBackground(new Color(0, 191, 255));
		model=new DefaultTableModel();
		Object[] column= {"Reg No","Name","Contact No","Program"};
		Object[] row= new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Student Registration");
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(81, 11, 301, 49);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(id.getText().equals("")|| name.getText().equals("")|| cont.getText().equals("")|| prog.getText().equals("")) {
	JOptionPane.showMessageDialog( null, "Please Enter Complete Details");
				}
else {
	row[0] =id.getText();
	row[1] =name.getText();
	row[2] =cont.getText();
	row[3] =prog.getText();
	model.addRow(row);
	id.setText(null);
	name.setText(null);
	cont.setText(null);
	prog.setText(null);
	JOptionPane.showMessageDialog( null, "Saved Successfully!");
}
				
		}
		});
		btnNewButton.setBounds(10, 355, 108, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =table.getSelectedRow();
				if(i>=0) {
				model.setValueAt(id.getText(), i, 0);
				model.setValueAt(name.getText(), i, 1);
				model.setValueAt(cont.getText(), i, 2);
				model.setValueAt(prog.getText(), i, 3);
				JOptionPane.showMessageDialog( null, "Updated Successfully!");
				}
				else {
					JOptionPane.showMessageDialog( null, "Please Select Data First!");
				}
				}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 410, 108, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =  table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog( null, "Deleted Successfully!");
				}
				else {
					JOptionPane.showMessageDialog( null, "Please Select The Data First!");
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(154, 355, 110, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("CLEAR");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText(null);
				name.setText(null);
				cont.setText(null);
				prog.setText(null);
				JOptionPane.showMessageDialog( null, "Cleared!");
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_2.setForeground(new Color(75, 0, 130));
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(154, 410, 110, 23);
		panel.add(btnNewButton_1_2);
	}
}
