package BloodBank;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passTxt;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 10, 748, 372);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(275, 10, 170, 45);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 53, 748, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("USER ID :-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(214, 94, 117, 32);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setBounds(350, 94, 208, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(214, 169, 117, 32);
		panel.add(lblNewLabel_2);
		
		passTxt = new JPasswordField();
		passTxt.setForeground(Color.RED);
		passTxt.setBackground(Color.WHITE);
		passTxt.setBounds(350, 172, 208, 32);
		panel.add(passTxt);
		passTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try
		        {
					Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root","hapi2001@");
		            Statement s=con.createStatement();
		            String query="select * from login where admin_id='"+textField.getText()+"'";
		            ResultSet rs=s.executeQuery(query);
		            String password="";
		            String pass= String.valueOf(passTxt.getPassword());
		            while(rs.next()) {
		                password=rs.getString("pass");
		            }
		            if(pass.equals(password)) {
		            	 JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
		            	 dispose();
		            	 HomePage obj=new HomePage();
		            	 obj.setVisible(true);
		             }
		             else {
		            	  JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
		             }
		        }
		        
		            catch(Exception ea)
		            {
		            	System.out.println(ea);
		            }
		        }
			
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(257, 252, 117, 32);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnNewButton_1 ) {
					textField.setText("");
					passTxt.setText("");
				}
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(567, 252, 104, 32);
		panel.add(btnNewButton_1);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(Color.ORANGE);
		btnExit.setBounds(413, 252, 117, 32);
		panel.add(btnExit);
	}
}
