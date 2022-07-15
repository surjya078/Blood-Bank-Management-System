package BloodBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import net.proteanit.*;
import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel StockIncrease = new JLabel("Stock (Increase)");
		StockIncrease.setBounds(110, 11, 217, 35);
		StockIncrease.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		contentPane.add(StockIncrease);
		
		JLabel lblNewLabel = new JLabel("Blood Group");
		lblNewLabel.setBounds(10, 58, 90, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 57, 90, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setBounds(232, 57, 40, 17);
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUnits);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 57, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 536, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 85, 536, 14);
		contentPane.add(separator_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(293, 331, 86, 23);
		contentPane.add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 407, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		contentPane.add(table);
		scrollPane.setViewportView(table);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms","root","hapi2001@");
			Statement st = con.createStatement();
			String q= "select * from stock";
			ResultSet rs = st.executeQuery(q);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			System.out.print(e);
		}
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
				
			try
		        {
					String BloodGroup=textField.getText();
					String Units=textField_1.getText();
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root","hapi2001@");
		            Statement s=con.createStatement();
		            String query="insert into stock values('"+BloodGroup+"','"+Units+"')";
		            int x=s.executeUpdate(query);
		            if(x==0) {
		            	JOptionPane.showMessageDialog(btnNewButton, "Already Exist");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(btnNewButton, "You have successfully inserted");
		            }
		            
		        }
		        
		            catch(Exception ea)
		            {
		            	System.out.println(ea);
		            }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(50, 331, 89, 23);
		contentPane.add(btnNewButton);
	}
}
