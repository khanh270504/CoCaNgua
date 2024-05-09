package MainPackage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Exit extends JButton {
	public Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public Exit() {

		setText("Exit");
		setFont(PanelControl.font);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setBorder(border);
		setFocusPainted(false);
		setContentAreaFilled(false);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

	}
}
