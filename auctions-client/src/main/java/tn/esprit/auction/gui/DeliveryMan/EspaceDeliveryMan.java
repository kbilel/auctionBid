package tn.esprit.auction.gui.DeliveryMan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EspaceDeliveryMan extends JFrame {

	private JPanel contentPane;
	JScrollPane 	 scrollPane = new JScrollPane();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 602);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("show");
		mnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelShowOrder panelOrder=new PanelShowOrder();
				scrollPane.setViewportView(panelOrder);
			}
		});
		
		menuBar.add(mnAdd);
		
		JMenu mnSho = new JMenu("ajout");
		mnSho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAjoutOrder panelAjoutOrder=new PanelAjoutOrder();
				scrollPane.setViewportView(panelAjoutOrder);
			}
		});
		menuBar.add(mnSho);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		scrollPane.setBounds(10, 11, 554, 429);
		contentPane.add(scrollPane);
		
		
	}

}
