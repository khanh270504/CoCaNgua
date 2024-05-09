package MainPackage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Restart extends JButton {
	public Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public Restart() {

		setText("RESTART");
		setFont(PanelControl.font);
		setBorder(border);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setFocusPainted(false);
		setContentAreaFilled(false);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.ReStart();
				PanelControl.update();
			}

		});

	}
}
