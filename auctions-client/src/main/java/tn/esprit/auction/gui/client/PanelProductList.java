package tn.esprit.auction.gui.client;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import java.awt.Color;



import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTable;

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class PanelProductList extends JPanel {
	List <Product> products;
	   
    Product productSelected =new Product();
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelProductList() {
		products=new ArrayList<Product>();
		products=GestionProductDelegate.doFindAllProducts();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Products List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 27, 707, 331);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 430, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		panel.add(scrollPane);
		setLayout(groupLayout);
		initDataBindings();
		setVisible(true);
		panel.setVisible(true);
		scrollPane.setVisible(true);

	}
	protected void initDataBindings() {
		JTableBinding<Product, List<Product>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, products, table);
		//
		BeanProperty<Product, String> productBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("Product Name");
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("category");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("Category");
		//
		BeanProperty<Product, Integer> productBeanProperty_2 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("Price");
		//
		BeanProperty<Product, String> productBeanProperty_3 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("Description");
		//
		jTableBinding.bind();
	}
}
