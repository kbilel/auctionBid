package tn.esprit.auction.gui.DeliveryMan;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import tn.esprit.auction.delegate.GestionOrderDelegate;
import tn.esprit.auction.domain.Order;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class ManageOrder extends JPanel {
	private JTable table;
 List<Order> orders;
 
	public ManageOrder() {
		orders=new ArrayList<Order>();
	orders=GestionOrderDelegate.doFindAllOrders();
		
		
		
		setBorder(new TitledBorder(null, "affichage", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(25, 24, 396, 253);
		add(scrollPane2);
		
		table = new JTable();
		scrollPane2.setViewportView(table);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Order, List<Order>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, orders, table);
		//
		BeanProperty<Order, Integer> orderBeanProperty = BeanProperty.create("client");
		jTableBinding.addColumnBinding(orderBeanProperty).setColumnName("id client");
		//
		BeanProperty<Order, Integer> orderBeanProperty_1 = BeanProperty.create("produit");
		jTableBinding.addColumnBinding(orderBeanProperty_1).setColumnName("id_produit");
		//
		jTableBinding.bind();
	}
}
