package tn.esprit.auction.gui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JTextArea;

public class AddNewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField tfProdName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewProduct frame = new AddNewProduct();
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
	public AddNewProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setForeground(new Color(178, 34, 34));
		lblAddProduct.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblAddProduct.setVerticalAlignment(SwingConstants.TOP);
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		tfProdName = new JTextField();
		tfProdName.setColumns(10);
final JSpinner spQuantity = new JSpinner();
final  String photoUrl;
final  Byte[] photoP;
		final JSpinner spPrice = new JSpinner();
		final JComboBox cbCat = new JComboBox();
		final JTextArea taDescription = new JTextArea();
		cbCat.setModel(new DefaultComboBoxModel(new String[] {"Antiques", "Cell Phones & Accessories", "Electronics", "Home", "Music"}));
		JLabel lblDt = new JLabel("DT");
		
		JLabel lbPhoto = new JLabel("Photo:");
		lbPhoto.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		JEditorPane epPhoto = new JEditorPane();
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				   
			       
				final JFileChooser jFileChooser = new JFileChooser();
	            int returnVal = jFileChooser.showOpenDialog(AddNewProduct.this);
	            File file = jFileChooser.getSelectedFile();
	            if(returnVal == JFileChooser.APPROVE_OPTION){
	            	 try{   
	      		       
	   		          
	   		          FileInputStream fis=new FileInputStream(file);
	   		           ByteArrayOutputStream bos=new ByteArrayOutputStream();
	   		            byte[] buf=new byte[1024];
	   		            for(int readNum;(readNum=fis.read(buf))!=-1;){
	   		                bos.write(buf,0,readNum);
	   		                
	   		            }
	   		           byte[]  photoP = bos.toByteArray() ;
	   		            
	   		       }
	   		catch(Exception e1){
	   		    JOptionPane.showMessageDialog(null,e1);
	   		    
	   		}
	                
	               String photoUrl = file.getName();
	            }
	        
		    
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product product = new Product();
				product.setName(tfProdName.getText());
				product.setCategory(cbCat.getSelectedItem().toString());
				product.setPrice((Integer)spPrice.getValue());
				product.setQuantity((Integer)spQuantity.getValue());
				product.setDescription(taDescription.getText());
				product.setImageByte(null);
				product.setImageUrl("NULL");
				
				GestionProductDelegate.doAddProduct(product);
			}
		});
		btnAdd.setIcon(new ImageIcon(AddNewProduct.class.getResource("/tn/esprit/auction/gui/manager/tickokjpg.jpg")));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(AddNewProduct.class.getResource("/tn/esprit/auction/gui/manager/cancel.jpg")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		
		 
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProductName)
								.addComponent(lblCategory)
								.addComponent(lblPrice)
								.addComponent(lblDescription)
								.addComponent(lblQuantity))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(taDescription)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(cbCat, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tfProdName, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(spPrice, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addComponent(lblDt))
									.addComponent(spQuantity, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbPhoto, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(116))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(epPhoto, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(40))
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
							.addGap(82)))
					.addGap(108))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(191)
					.addComponent(lblAddProduct)
					.addContainerGap(355, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(368, Short.MAX_VALUE)
					.addComponent(btnUpload)
					.addGap(256))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddProduct)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductName)
						.addComponent(tfProdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbPhoto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(epPhoto, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnUpload))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCategory)
								.addComponent(cbCat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPrice)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(spPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDt)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantity)
								.addComponent(spQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescription)
								.addComponent(taDescription, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
							.addGap(68)))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
