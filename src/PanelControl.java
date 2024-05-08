import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelControl extends JPanel {
	public static JLabel jLabel;

	public JLabel jLabel2;
	public static Font font = new Font("TimeNewRoman", Font.BOLD, 15);
//	public static Border border = BorderFactory.createLineBorder(Color.BLACK, 5);

	public PanelControl() {
		jLabel2 = new JLabel("~~~~~LƯỢT CHƠI HIỆN TẠI~~~~~");
		jLabel = new JLabel("Đội xanh dương đi trước!!!");
		jLabel.setFont(font);
		jLabel.setForeground(Color.blue);
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		add(jLabel2, BorderLayout.NORTH);
		add(jLabel, BorderLayout.CENTER);
		JPanel jPanel = new JPanel();

		JButton restart = new Restart();

		JButton exit = new Exit();

		jPanel.setLayout(new GridLayout(2, 1));
		jPanel.add(restart);
		jPanel.add(exit);
		jPanel.setBackground(Color.LIGHT_GRAY);
		add(jPanel, BorderLayout.SOUTH);

	}

	public static void update() {
		jLabel.setHorizontalAlignment(SwingConstants.CENTER); // Đặt căn giữa ngang
		jLabel.setVerticalAlignment(SwingConstants.CENTER);
		if (GameManager.currentPlayer == 0) {
			jLabel.setText("Đến lượt đội xanh dương!");
			jLabel.setFont(font);
			jLabel.setForeground(Color.blue);

		}
		if (GameManager.currentPlayer == 1) {
			jLabel.setText("Đến lượt đội đỏ!");
			jLabel.setFont(font);
			jLabel.setForeground(Color.red);

		}
		if (GameManager.currentPlayer == 2) {
			jLabel.setText("Đến lượt đội xanh lá!");
			jLabel.setFont(font);
			jLabel.setForeground(Color.green);

		}
		if (GameManager.currentPlayer == 3) {
			jLabel.setText("Đến lượt đội vàng!");
			jLabel.setFont(font);
			jLabel.setForeground(Color.yellow);
//			border = BorderFactory.createLineBorder(Color.yellow, 5);
		}

	}

	public static void WinGame() {
		ImageIcon youwin = new ImageIcon("resources/images/win.jpg");
		if (GameManager.currentPlayer == 1) {
			JOptionPane.showMessageDialog(null, "Đội xanh dương thắng", "Nope", WIDTH, youwin);
//			Game.ReStart();
			System.exit(0);
		}
		if (GameManager.currentPlayer == 2) {
			JOptionPane.showMessageDialog(null, "Đội đỏ thắng", "Nope", WIDTH, youwin);
//			Game.ReStart();
			System.exit(0);
		}
		if (GameManager.currentPlayer == 3) {
			JOptionPane.showMessageDialog(null, "Đội xanh lá thắng", "Nope", WIDTH, youwin);
//			Game.ReStart();
			System.exit(0);
		}
		if (GameManager.currentPlayer == 4) {
			JOptionPane.showMessageDialog(null, "Đội vàng thắng", "Nope", WIDTH, youwin);
//			Game.ReStart();
			System.exit(0);
		}
	}
}
