import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Restart extends JButton {
	public Restart() {

		setText("RESTART");
		setFont(PanelControl.font);
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setBorderPainted(false);
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
