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

import tn.esprit.auction.delegate.GestionProductDelegate;
import tn.esprit.auction.domain.Product;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class PanelManageProducts extends JPanel {
    List <Product> products;
    private JTable table;

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
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 732, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Product, List<Product>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, products, table, "listProducts");
		//
		BeanProperty<Product, Integer> productBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("Id");
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Product, String> productBeanProperty_2 = BeanProperty.create("category");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("New Column");
		//
		BeanProperty<Product, Integer> productBeanProperty_3 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("New Column");
		//
		BeanProperty<Product, Integer> productBeanProperty_4 = BeanProperty.create("quantity");
		jTableBinding.addColumnBinding(productBeanProperty_4).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
