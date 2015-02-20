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
	
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "add", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 50, 396, 237);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTakeOrder = new JButton("Take order");
		btnTakeOrder.setBounds(497, 318, 89, 23);
		add(btnTakeOrder);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Order, List<Order>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, orders, table);
		//
		BeanProperty<Order, Boolean> orderBeanProperty = BeanProperty.create("cashPayement");
		jTableBinding.addColumnBinding(orderBeanProperty).setColumnName("cashpayment");
		//
		BeanProperty<Order, Integer> orderBeanProperty_1 = BeanProperty.create("client");
		jTableBinding.addColumnBinding(orderBeanProperty_1).setColumnName("Client id");
		//
		BeanProperty<Order, Date> orderBeanProperty_2 = BeanProperty.create("dateLimit");
		jTableBinding.addColumnBinding(orderBeanProperty_2).setColumnName("dateLimit");
		//
		BeanProperty<Order, Integer> orderBeanProperty_3 = BeanProperty.create("deliveryMan.id");
		jTableBinding.addColumnBinding(orderBeanProperty_3).setColumnName("DeliveryMan id");
		//
		BeanProperty<Order, Integer> orderBeanProperty_4 = BeanProperty.create("manager.id");
		jTableBinding.addColumnBinding(orderBeanProperty_4).setColumnName("Manager id");
		//
		BeanProperty<Order, OrderPK> orderBeanProperty_5 = BeanProperty.create("orderPK");
		jTableBinding.addColumnBinding(orderBeanProperty_5).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
