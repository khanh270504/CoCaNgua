import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Exit extends JButton {
	public Exit() {

		setText("Exit");
		setFont(PanelControl.font);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setBorderPainted(false);
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
