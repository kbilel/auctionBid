package tn.esprit.auction.gui.stockManager;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class PanelAddProduct extends JPanel {
	private JTextField tfProdName;
	private JTextField tfUrlPhotoProd;
	private JLabel lblPhotoProd;
	 byte[] imageProdByte=null;
	private String pathImg;
	private String imageUserPath;

	/**
	 * Create the panel.
	 */
	public PanelAddProduct() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "AddProduct", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 732, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		final JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setBounds(27, 43, 127, 14);
		panel.add(lblProductName);
		
		tfProdName = new JTextField();
		tfProdName.setBounds(121, 40, 189, 20);
		panel.add(tfProdName);
		tfProdName.setColumns(10);
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(27, 110, 85, 14);
		panel.add(lblCategory);
		
		final JComboBox cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"Antiques", "CellPhones & Accessories", "Electronics", "Home", "Music"}));
		cbCategory.setBounds(121, 107, 189, 20);
		panel.add(cbCategory);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(27, 172, 46, 14);
		panel.add(lblQuantity);
		
		final JSpinner spQuantity = new JSpinner();
		spQuantity.setBounds(121, 169, 62, 20);
		panel.add(spQuantity);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(27, 234, 46, 14);
		panel.add(lblPrice);
		
		final JSpinner spPrice = new JSpinner();
		spPrice.setBounds(121, 231, 62, 20);
		panel.add(spPrice);
		
		JLabel lblDt = new JLabel("DT");
		lblDt.setBounds(193, 234, 46, 14);
		panel.add(lblDt);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(27, 286, 85, 14);
		panel.add(lblDescription);
		
		final JTextArea taDescription = new JTextArea();
		taDescription.setBounds(121, 283, 189, 95);
		panel.add(taDescription);
		
		JLabel lblPhoto = new JLabel("Photo:");
		lblPhoto.setBounds(419, 43, 46, 14);
		panel.add(lblPhoto);
		
		final JLabel lblPhotoProd = new JLabel("");
		lblPhotoProd.setIcon(new ImageIcon(PanelAddProduct.class.getResource("/tn/esprit/auction/gui/stockManager/prod.jpg")));
		lblPhotoProd.setBounds(429, 78, 213, 193);
		panel.add(lblPhotoProd);
		
		JButton btnUpload = new JButton("");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
			        chooser.showOpenDialog(null);
			        File f=chooser.getSelectedFile();
			        pathImg=f.getAbsolutePath();
			        System.out.println("path="+pathImg);
			       try
			        {
			            File image=new File(pathImg);
			            FileInputStream fis=new FileInputStream(image);
			            ByteArrayOutputStream bos=new ByteArrayOutputStream();
			            byte[] buf = new byte[1024]; 
			            for(int readNum;(readNum=fis.read(buf))!=-1;)
			            {
			              bos.write(buf,0,readNum);
			            }
			           imageProdByte=bos.toByteArray();
			           
			            
			        }catch(Exception ex)
			        {
			            JOptionPane.showMessageDialog(null,ex);
			        }
			        
			     lblPhotoProd.setIcon(new ImageIcon(""+f));
			        
			         Path path=Paths.get(pathImg);
			       String ch=path.getParent().toString();
			       String ch1=path.getFileName().toString();
			        System.out.println("pathBaya="+ch1);
			        String ch0 ="imageAuction/";
			       String ch2=ch0.concat(ch1);
			       String ch3=ch2.replace('\\', '/');
			       imageUserPath=ch3;
			        //ch3=ch.replace('\\', '/');
			       tfUrlPhotoProd.setText(ch3);
			
			}
		});
		btnUpload.setIcon(new ImageIcon(PanelAddProduct.class.getResource("/tn/esprit/auction/gui/stockManager/addbut.jpg")));
		btnUpload.setBounds(508, 286, 49, 34);
		panel.add(btnUpload);
		
		tfUrlPhotoProd = new JTextField();
		tfUrlPhotoProd.setBounds(429, 331, 213, 20);
		panel.add(tfUrlPhotoProd);
		tfUrlPhotoProd.setColumns(10);

		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product product= new Product();
				product.setName(tfProdName.getText());
				product.setCategory(cbCategory.getSelectedItem().toString());
				product.setQuantity((Integer) spQuantity.getValue());
				product.setPrice((Integer) spPrice.getValue());
				product.setDescription(taDescription.getText());
				product.setImageUrl(tfUrlPhotoProd.getText());
				//product.setImageByte(imageByte);
				if(GestionProductDelegate.doAddProduct(product)){
					JOptionPane.showMessageDialog(null, "ok ! product added");
					tfProdName.setText("");
					
					
				}
			}
		});
		btnAdd.setBounds(228, 389, 118, 23);
		panel.add(btnAdd);
		
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(376, 389, 118, 23);
		panel.add(btnCancel);
		setLayout(groupLayout);

	}
}
