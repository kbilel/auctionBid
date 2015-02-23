package tn.esprit.auction.gui.DeliveryMan;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
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

import org.jdesktop.beansbinding.ObjectProperty;

import tn.esprit.auction.domain.Product;
import tn.esprit.auction.gui.authentification.Authentification;
import tn.esprit.auction.gui.client.HomeClient;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelShowOrder extends JPanel {
	List<Order>orders;
	List<Order> ordersTodeliver;
	Order orderTodeliver;
	Order orderState =new Order();
	private JTable table;
	private JTable table_1;
	Order orderSelectedTable ;


	/**
	 * Create the panel.
	 */
	public PanelShowOrder() {
		orders=new ArrayList<Order>();
		orders=GestionOrderDelegate.doFindAllOrders();
		ordersTodeliver=new ArrayList<Order>();
		ordersTodeliver=GestionOrderDelegate.doFindAllOrdersByIdDeliveryMan(HomeClient.getUser().getId());
		
	
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Orders", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 609, 150);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderSelectedTable=orders.get(table.getSelectedRow());
			
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				orderState=ordersTodeliver.get(table_1.getSelectedRow());
			}
		});
		scrollPane_1.setBounds(10, 295, 527, 74);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderState=ordersTodeliver.get(table_1.getSelectedRow());
			}
		});
		
		scrollPane_1.setViewportView(table_1);
		
		JButton btnTakeOrder = new JButton("Take Order");
		btnTakeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(orderSelectedTable.getIdDeliveryMan()==null){
				Order order =new Order();
				order=orderSelectedTable;
				order.setIdDeliveryMan(HomeClient.getUser().getId());
				GestionOrderDelegate.doUpdateOrder(order);
				System.out.println("update ok");
			}else JOptionPane.showMessageDialog(null, "This Order is already taken !" );
				
				initDataBindings();
				}
		});
		btnTakeOrder.setBounds(230, 211, 163, 29);
		add(btnTakeOrder);
		
		JButton btnDeliver = new JButton("Deliver");
		btnDeliver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order order =new Order();
				order= orderState;
				order.setState("Delivred");
				GestionOrderDelegate.doUpdateOrder(order);
				initDataBindings();
				
			
			}
		});
		btnDeliver.setBounds(230, 399, 156, 29);
		add(btnDeliver);
		
		JLabel lblMyOrders = new JLabel("My orders");
		lblMyOrders.setBackground(Color.WHITE);
		lblMyOrders.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMyOrders.setForeground(Color.BLUE);
		lblMyOrders.setBounds(10, 248, 90, 14);
		add(lblMyOrders);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Order, List<Order>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, ordersTodeliver, table_1);
		//
		BeanProperty<Order, Integer> orderBeanProperty_6 = BeanProperty.create("orderPK.idProduct");
		jTableBinding_1.addColumnBinding(orderBeanProperty_6).setColumnName("Product id");
		//
		BeanProperty<Order, Integer> orderBeanProperty_7 = BeanProperty.create("orderPK.idClient");
		jTableBinding_1.addColumnBinding(orderBeanProperty_7).setColumnName("Client id");
		//
		BeanProperty<Order, String> orderBeanProperty_8 = BeanProperty.create("adressClient");
		jTableBinding_1.addColumnBinding(orderBeanProperty_8).setColumnName("Adress");
		//
		BeanProperty<Order, String> orderBeanProperty_10 = BeanProperty.create("state");
		jTableBinding_1.addColumnBinding(orderBeanProperty_10).setColumnName("state");
		//
		BeanProperty<Order, Integer> orderBeanProperty_11 = BeanProperty.create("idDeliveryMan");
		jTableBinding_1.addColumnBinding(orderBeanProperty_11).setColumnName("DeliveryMan id").setEditable(false);
		//
		jTableBinding_1.bind();
		//
		JTableBinding<Order, List<Order>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, orders, table);
		//
		BeanProperty<Order, Integer> orderBeanProperty = BeanProperty.create("orderPK.idProduct");
		jTableBinding.addColumnBinding(orderBeanProperty).setColumnName("Product id");
		//
		BeanProperty<Order, Integer> orderBeanProperty_1 = BeanProperty.create("orderPK.idClient");
		jTableBinding.addColumnBinding(orderBeanProperty_1).setColumnName("Client id");
		//
		BeanProperty<Order, String> orderBeanProperty_2 = BeanProperty.create("adressClient");
		jTableBinding.addColumnBinding(orderBeanProperty_2).setColumnName("Adress");
		//
		BeanProperty<Order, Date> orderBeanProperty_3 = BeanProperty.create("dateLimit");
		jTableBinding.addColumnBinding(orderBeanProperty_3).setColumnName("Date of purchace");
		//
		BeanProperty<Order, Boolean> orderBeanProperty_4 = BeanProperty.create("cashPayement");
		jTableBinding.addColumnBinding(orderBeanProperty_4).setColumnName("Payment Cash");
		//
		BeanProperty<Order, String> orderBeanProperty_5 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(orderBeanProperty_5).setColumnName("State");
		//
		BeanProperty<Order, Integer> orderBeanProperty_9 = BeanProperty.create("idDeliveryMan");
		jTableBinding.addColumnBinding(orderBeanProperty_9).setColumnName("DeliveryMan Id").setEditable(false);
		//
		jTableBinding.bind();
	}
}
