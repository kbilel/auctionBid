package tn.esprit.auction.gui.DeliveryMan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JMenu;

public class EspaceDeliveryMan extends JFrame {

	private JPanel contentPane;
	
	JScrollPane scrollPane = new JScrollPane();
	EspaceAjoutOrder espaceAjoutOrder=new EspaceAjoutOrder();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceDeliveryMan frame = new EspaceDeliveryMan();
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
	public EspaceDeliveryMan() {
scrollPane.setViewportView(espaceAjoutOrder);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 564);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAjout = new JMenu("Ajout");
		menuBar.add(mnAjout);
		
		JMenu mnWatch = new JMenu("watch");
		menuBar.add(mnWatch);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 595, 483);
		contentPane.add(scrollPane);
	}

}
