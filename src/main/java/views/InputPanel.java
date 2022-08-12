package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InputPanel extends JPanel {
	private JTextField itemNameField;
	private JTextField itemNumField;
	
	public InputPanel(String title, JButton button) {
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		itemNameField = new JTextField(5);
		itemNumField = new JTextField(5);
		addComponent(gbl, new JLabel("品名"), 0, 0, 1, 1);
		addComponent(gbl, itemNameField, 1, 0, 1, 1);
		addComponent(gbl, new JLabel("数量:"), 0, 1, 1, 1);
		addComponent(gbl, itemNumField, 1, 1, 1, 1);
		addComponent(gbl, button, 2, 1, 1, 1);
		Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(lineBorder, title);
		setBorder(titledBorder);		
	}

	public void addComponent(GridBagLayout gbl, Component comp, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
        gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(comp, gbc);
		add(comp);
	}

	public String getItemName() {
		return itemNameField.getText();
	}
	
	public int getItemNum() {
		if (itemNumField.getText() == null) return 0;
		int itemNum = Integer.parseInt(itemNumField.getText());
		return itemNum;
	}
	
	public void clearValues() {
		itemNameField.setText("");
		itemNumField.setText("");
	}
}
