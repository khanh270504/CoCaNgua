package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Win_Panel extends JFrame {
	public Font font = new Font("TimeNewRoman", Font.BOLD, 20);
	public static JFrame win;
	public static boolean check_null = false;

	public Win_Panel(String s, Color c) {

		win = new JFrame();
		win.setTitle("CONGRATULATIONS");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(350, 300));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel jLabel_congratulations = new JLabel("~~~~~CONGRATULATIONS~~~~~");
		jLabel_congratulations.setFont(font);
		jLabel_congratulations.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_congratulations.setVerticalAlignment(SwingConstants.CENTER);
		jLabel_congratulations.setForeground(c);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		panel.add(jLabel_congratulations, gbc);

		JLabel jLabel_teamWin = new JLabel(s);
		jLabel_teamWin.setFont(font);
		jLabel_teamWin.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_teamWin.setVerticalAlignment(SwingConstants.CENTER);
		jLabel_teamWin.setForeground(c);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		panel.add(jLabel_teamWin, gbc);

		ImageIcon imageIcon = new ImageIcon("resources/images/win2.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.4;
		panel.add(imageLabel, gbc);

		JLabel jLabel_quesEnd = new JLabel("Choose 1 of the 2 buttons below");
		jLabel_quesEnd.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_quesEnd.setVerticalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		panel.add(jLabel_quesEnd, gbc);

		JButton button1 = new Restart();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		panel.add(button1, gbc);

		JButton button2 = new Exit();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		panel.add(button2, gbc);

		panel.setBackground(Color.white);

		win.add(panel);
		win.pack();
		win.setLocationRelativeTo(null);
		win.setResizable(false);
		win.setVisible(true);

		check_null = true;
	}

}
