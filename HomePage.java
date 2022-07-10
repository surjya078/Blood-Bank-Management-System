 package BloodBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 573);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("fhvnv");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Donor");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add New Donor");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewDonor obj= new addNewDonor();
				obj.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmAllDonorDetails = new JMenuItem("Update Details");
		mnNewMenu.add(mntmAllDonorDetails);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("All Donor Details");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Search Blood Donor");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Location");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Blood Group");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Stock");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Increase");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Decrease");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Details");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_3 = new JMenu("Delete Donor");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Delete Donor");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Exit");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Logout");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin obj= new AdminLogin();
				obj.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Exit Application");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar.add(menuBar_3);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar.add(menuBar_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
