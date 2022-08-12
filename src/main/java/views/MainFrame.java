package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import resources.StockManagement;
import values.Item;

public class MainFrame extends JFrame {
	private StockManagement stockManager;
	
	private InputPanel arrivePanel;
	private InputPanel requestPanel;
	private TablePanel stockPanel;
	private TablePanel shortagePanel;
	
	private JLabel shippingNameLbl;
	private JLabel shippingNumLbl;
	
	public MainFrame() {
		super("Stock Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize model
		stockManager = new StockManagement();
		
		JButton arriveBtn = new JButton("搬入");
		JButton requestBtn = new JButton("出庫依頼");
		arriveBtn.addMouseListener(new ArriveButtonListener());
		requestBtn.addMouseListener(new RequestButtonListener());
		shippingNameLbl = new JLabel("");
		shippingNumLbl = new JLabel("");
		
		arrivePanel = new InputPanel("搬入", arriveBtn);	
		requestPanel = new InputPanel("出庫依頼", requestBtn);
		JPanel shippingPanel = new JPanel();
		shippingPanel.setLayout(new GridLayout(2, 2));
		shippingPanel.add(new JLabel("品名:"));
		shippingPanel.add(shippingNameLbl);
		shippingPanel.add(new JLabel("数量:"));
		shippingPanel.add(shippingNumLbl);
		Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(lineBorder, "出庫");
		shippingPanel.setBorder(titledBorder);
		
		JPanel ioPanel = new JPanel();
		ioPanel.setLayout(new GridLayout(1, 3));
		ioPanel.add(arrivePanel);
		ioPanel.add(requestPanel);
		ioPanel.add(shippingPanel);
		add(ioPanel, BorderLayout.NORTH);
		
		JPanel dbPanel = new JPanel();
		ioPanel.setLayout(new GridLayout(1, 2));
		stockPanel = new TablePanel("在庫", stockManager.getStock());	
		shortagePanel = new TablePanel("在庫不足リスト", stockManager.getShortage());	
		dbPanel.add(stockPanel);
		dbPanel.add(shortagePanel);
		add(dbPanel, BorderLayout.SOUTH);
		pack();
	}
	
	private class ArriveButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			String itemName = arrivePanel.getItemName();
			int itemNum = arrivePanel.getItemNum();
			stockManager.arrive(itemNum, itemName);
			arrivePanel.clearValues();
			stockPanel.update(stockManager.getStock());
			shortagePanel.update(stockManager.getShortage());
			Item shipping = stockManager.getShipping();
			if (shipping.getName() != null && shipping.getNum() > 0) {
				shippingNameLbl.setText(shipping.getName());
				shippingNumLbl.setText("" + shipping.getNum());
			} else {
				shippingNameLbl.setText("");
				shippingNumLbl.setText("");
			}
			MainFrame.this.validate();
			MainFrame.this.repaint();
		}

		@Override
		public void mouseEntered(MouseEvent event) {
		}

		@Override
		public void mouseExited(MouseEvent event) {
		}

		@Override
		public void mousePressed(MouseEvent event) {
		}

		@Override
		public void mouseReleased(MouseEvent event) {
		}
		
	}
	
	private class RequestButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			String itemName = requestPanel.getItemName();
			int itemNum = requestPanel.getItemNum();
			stockManager.req(itemNum, itemName);
			requestPanel.clearValues();
			stockPanel.update(stockManager.getStock());
			shortagePanel.update(stockManager.getShortage());
			Item shipping = stockManager.getShipping();
			if (shipping.getName() != null && shipping.getNum() > 0) {
				shippingNameLbl.setText(shipping.getName());
				shippingNumLbl.setText("" + shipping.getNum());
			} else {
				shippingNameLbl.setText("");
				shippingNumLbl.setText("");
			}
			MainFrame.this.validate();
			MainFrame.this.repaint();
		}

		@Override
		public void mouseEntered(MouseEvent event) {
		}

		@Override
		public void mouseExited(MouseEvent event) {
		}

		@Override
		public void mousePressed(MouseEvent event) {
		}

		@Override
		public void mouseReleased(MouseEvent event) {
		}
		
	}

}
