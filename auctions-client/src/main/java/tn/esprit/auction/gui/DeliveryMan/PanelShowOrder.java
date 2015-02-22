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
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelShowOrder extends JPanel {
	List<Order>orders;
	List<Order> ordersTodeliver;
	Order orderTodeliver;
	Order orderState;
	private JTable table;
	private JTable table_1;


	/**
	 * Create the panel.
	 */
	public PanelShowOrder() {
		orders=new ArrayList<Order>();
		orders=GestionOrderDelegate.doFindAllOrders();
		ordersTodeliver=new ArrayList<Order>();
		
	
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Orders", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 609, 150);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTakeOrder = new JButton("Take order");
		btnTakeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ordersTodeliver.add(orderTodeliver);
				ordersTodeliver=GestionOrderDelegate.doFindAllOrders();
				initDataBindings();
			
			}
		});
		btnTakeOrder.setBounds(310, 412, 137, 23);
		add(btnTakeOrder);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				orderState=ordersTodeliver.get(table_1.getSelectedRow());
			}
		});
		scrollPane_1.setBounds(10, 284, 609, 74);
		add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnConfirm = new JButton("Confirm ");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderState.setState("delivred");
						
				if(GestionOrderDelegate.doUpdateOrder(orderState)){
					System.out.println("update with succes");
					
					ordersTodeliver=GestionOrderDelegate.doFindAllOrders();
					System.out.println("initiat binding not passed");
					initDataBindings();
					System.out.println("initiat binding passed");
					
					
				}
				else{
					
				}
			}
		});
		btnConfirm.setBounds(498, 412, 89, 23);
		add(btnConfirm);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Order, List<Order>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, orders, table);
		//
		BeanProperty<Order, Integer> orderBeanProperty_2 = BeanProperty.create("produit");
		jTableBinding.addColumnBinding(orderBeanProperty_2).setColumnName("Product id");
		//
		BeanProperty<Order, Integer> orderBeanProperty = BeanProperty.create("client");
		jTableBinding.addColumnBinding(orderBeanProperty).setColumnName("Client id");
		//
		BeanProperty<Order, String> orderBeanProperty_1 = BeanProperty.create("adressClient");
		jTableBinding.addColumnBinding(orderBeanProperty_1).setColumnName("adress Client");
		//
		BeanProperty<Order, Integer> orderBeanProperty_3 = BeanProperty.create("orderPK.idDeliveryMan");
		jTableBinding.addColumnBinding(orderBeanProperty_3).setColumnName("Delivery id");
		//
		BeanProperty<Order, Boolean> orderBeanProperty_5 = BeanProperty.create("cashPayement");
		jTableBinding.addColumnBinding(orderBeanProperty_5).setColumnName("PaymentCash");
		//
		jTableBinding.bind();
		//
		JTableBinding<Order, List<Order>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ordersTodeliver, table_1);
		//
		BeanProperty<Order, Integer> orderBeanProperty_4 = BeanProperty.create("produit");
		jTableBinding_1.addColumnBinding(orderBeanProperty_4).setColumnName("Product id");
		//
		BeanProperty<Order, String> orderBeanProperty_6 = BeanProperty.create("state");
		jTableBinding_1.addColumnBinding(orderBeanProperty_6).setColumnName("state");
		//
		BeanProperty<Order, Integer> orderBeanProperty_7 = BeanProperty.create("client");
		jTableBinding_1.addColumnBinding(orderBeanProperty_7).setColumnName("Client id");
		//
		BeanProperty<Order, String> orderBeanProperty_8 = BeanProperty.create("adressClient");
		jTableBinding_1.addColumnBinding(orderBeanProperty_8).setColumnName("Adress");
		//
		BeanProperty<Order, Boolean> orderBeanProperty_9 = BeanProperty.create("cashPayement");
		jTableBinding_1.addColumnBinding(orderBeanProperty_9).setColumnName("Cash Payment");
		//
		jTableBinding_1.bind();
	}
}
