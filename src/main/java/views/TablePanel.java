package views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class TablePanel extends JPanel {
	public TablePanel(String title, Map<String, Integer> table) {
		
		update(table);

		Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(lineBorder, title);
		setBorder(titledBorder);		
	}
	
	public void update(Map<String, Integer> table) {
		this.removeAll();
		setLayout(new GridLayout(table.size() + 1, 2));
		add(new JLabel("品名 "));
		add(new JLabel("数量 "));
		for (Map.Entry<String, Integer> entry: table.entrySet()) {
			add(new JLabel(entry.getKey()));
			add(new JLabel("" + entry.getValue()));
		}
	}
}
