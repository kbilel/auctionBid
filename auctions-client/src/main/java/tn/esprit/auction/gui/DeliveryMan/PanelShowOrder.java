package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import tn.esprit.auction.delegate.GestionOrderDelegate;
import tn.esprit.auction.domain.Order;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import tn.esprit.auction.domain.DeliveryMan;
import tn.esprit.auction.domain.Manager;
import java.util.Date;
import tn.esprit.auction.domain.OrderPK;

public class PanelShowOrder extends JPanel {
	List<Order>orders;
	private JTable table;


	/**
	 * Create the panel.
	 */
	public PanelShowOrder() {
		orders=new ArrayList<Order>();
		orders=GestionOrderDelegate.doFindAllOrders();
	
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Orders", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 615, 237);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTakeOrder = new JButton("Take order");
		btnTakeOrder.setBounds(251, 351, 137, 23);
		add(btnTakeOrder);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Order, List<Order>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, orders, table);
		//
		BeanProperty<Order, Integer> orderBeanProperty = BeanProperty.create("client");
		jTableBinding.addColumnBinding(orderBeanProperty).setColumnName("Client id");
		//
		BeanProperty<Order, Integer> orderBeanProperty_1 = BeanProperty.create("produit");
		jTableBinding.addColumnBinding(orderBeanProperty_1).setColumnName("Product id");
		//
		BeanProperty<Order, Integer> orderBeanProperty_2 = BeanProperty.create("orderPK.idDeliveryMan");
		jTableBinding.addColumnBinding(orderBeanProperty_2).setColumnName("Delivery id");
		//
		BeanProperty<Order, Integer> orderBeanProperty_3 = BeanProperty.create("orderPK.idManager");
		jTableBinding.addColumnBinding(orderBeanProperty_3).setColumnName("Manager id");
		//
		BeanProperty<Order, Boolean> orderBeanProperty_4 = BeanProperty.create("cashPayement");
		jTableBinding.addColumnBinding(orderBeanProperty_4).setColumnName("PaymentCash");
		//
		jTableBinding.bind();
	}
}
