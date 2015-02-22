package tn.esprit.auction.gui.stockManager;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.esprit.auction.delegate.GestionAuctionDelegate;
import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Auction;
import tn.esprit.auction.domain.Product;
import tn.esprit.auction.gui.manager.PanelManageAuction;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelManageProducts extends JPanel {
    List <Product> products;
   
    Product productSelected =new Product();
    GestionProductDelegate gestionProductDelegate;
    private JTable table;
    private JTextField idProd;
    private JTextField ProdName;
    private JTextField Category;
    private JTextField Quantity;
    private JTextField Price;
    private JTextArea Description;
    
	/**
	 * Create the panel.
	 */
	public PanelManageProducts() {
		products=new ArrayList<Product>();
		products=GestionProductDelegate.doFindAllProducts();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Manage Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 732, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JPanel panel_1 = new JPanel();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idProd.setText(products.get(table.getSelectedRow()).getId().toString());
				ProdName.setText(products.get(table.getSelectedRow()).getName());
				Category.setText(products.get(table.getSelectedRow()).getCategory());
				Quantity.setText(products.get(table.getSelectedRow()).getQuantity().toString());
				Price.setText(products.get(table.getSelectedRow()).getPrice().toString());
				Description.setText(products.get(table.getSelectedRow()).getDescription());
				
			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel lblId = new JLabel("Id:");
		
		idProd = new JTextField();
		idProd.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		
		ProdName = new JTextField();
		ProdName.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		
		Quantity = new JTextField();
		Quantity.setColumns(10);
		Quantity.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		
		Category = new JTextField();
		Category.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		
		Price = new JTextField();
		
		JLabel lblDescription = new JLabel("Description:");
		
		Description = new JTextArea();
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  productSelected=products.get(table.getSelectedRow());
				GestionProductDelegate.doUpdateProduct(productSelected);
				GestionProductDelegate.doFindAllProducts();
				initDataBindings();
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblCategory)
							.addGap(29)
							.addComponent(Category, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantity)
								.addComponent(lblPrice))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Quantity)
								.addComponent(Price)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(2)
									.addComponent(Description))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDescription)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(ProdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(idProd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDelete, 0, 0, Short.MAX_VALUE)
						.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(idProd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(ProdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdate))
						.addComponent(lblName))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(Category, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(Quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPrice)
						.addComponent(Price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(Description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Product, List<Product>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, products, table, "listProducts");
		//
		BeanProperty<Product, Integer> productBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("Id");
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Product, String> productBeanProperty_2 = BeanProperty.create("category");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("Category");
		//
		BeanProperty<Product, Integer> productBeanProperty_3 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("Price");
		//
		BeanProperty<Product, Integer> productBeanProperty_4 = BeanProperty.create("quantity");
		jTableBinding.addColumnBinding(productBeanProperty_4).setColumnName("Quantity");
		//
		BeanProperty<Product, String> productBeanProperty_5 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(productBeanProperty_5).setColumnName("New Column");
		//
		jTableBinding.bind();
		//
		BeanProperty<Product, Integer> productBeanProperty_6 = BeanProperty.create("id");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Product, Integer, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productSelected, productBeanProperty_6, idProd, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Product, String> productBeanProperty_7 = BeanProperty.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Product, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productSelected, productBeanProperty_7, ProdName, jTextFieldBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<Product, String> productBeanProperty_8 = BeanProperty.create("category");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<Product, String, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productSelected, productBeanProperty_8, Category, jTextFieldBeanProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<Product, Integer> productBeanProperty_9 = BeanProperty.create("price");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<Product, Integer, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productSelected, productBeanProperty_9, Price, jTextFieldBeanProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<Product, Integer> productBeanProperty_10 = BeanProperty.create("quantity");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<Product, Integer, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productSelected, productBeanProperty_10, Quantity, jTextFieldBeanProperty_4);
		autoBinding_4.bind();
		//
		BeanProperty<Product, String> productBeanProperty_11 = BeanProperty.create("description");
		BeanProperty<JTextArea, String> jTextAreaBeanProperty = BeanProperty.create("text");
		AutoBinding<Product, String, JTextArea, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productSelected, productBeanProperty_11, Description, jTextAreaBeanProperty);
		autoBinding_5.bind();
	}
}
