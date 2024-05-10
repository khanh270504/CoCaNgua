package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import database.Leaderboard;
import database.UpdatePoints;

public class PanelControl extends JPanel {
	public static JLabel jLabel_turn;

	public JLabel jLabel_title;
	public JLabel jLabel_title2;
	public JLabel jl_player1;
	public JLabel jl_player2;
	public JLabel jl_player3;
	public JLabel jl_player4;
	public JLabel jl_point1;
	public JLabel jl_point2;
	public JLabel jl_point3;
	public JLabel jl_point4;
	public static Font font = new Font("TimeNewRoman", Font.BOLD, 15);
	public Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public PanelControl() {
		jLabel_title = new JLabel("~~~~~THE CURRENT TURN~~~~~");
		jLabel_turn = new JLabel("THE FIRST BLUE TEAM!");
		jLabel_turn.setFont(font);
		jLabel_turn.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_turn.setVerticalAlignment(SwingConstants.CENTER);
		jLabel_turn.setForeground(Color.blue);
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);

		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(2, 1));
		jPanel1.add(jLabel_title);
		jPanel1.add(jLabel_turn);
		jPanel1.setBackground(Color.LIGHT_GRAY);
		add(jPanel1, BorderLayout.NORTH);

		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jLabel_title2 = new JLabel("Scores");
		jLabel_title2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_title2.setVerticalAlignment(SwingConstants.CENTER);
		jLabel_title2.setFont(font);
		gbc.gridx = 0; // Cột 0 trong hàng 1
		gbc.gridy = 0; // Hàng 1
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		jPanel2.add(jLabel_title2, gbc);

		jl_player1 = new JLabel("Blue's point: ");
		jl_player1.setFont(font);
		gbc.gridx = 0; // Cột 0 trong hàng 2
		gbc.gridy = 1; // Hàng 2
		gbc.weightx = 0.75;
		gbc.weighty = 0.2;
		jPanel2.add(jl_player1, gbc);
		jl_point1 = new JLabel("0");
		gbc.gridx = 1; // Cột 1 trong hàng 2
		gbc.gridy = 1; // Hàng 2
		gbc.weightx = 0.25;
		gbc.weighty = 0.2;
		jPanel2.add(jl_point1, gbc);

		jl_player2 = new JLabel("Red's point: ");
		jl_player2.setFont(font);
		gbc.gridx = 0; // Cột 0 trong hàng 3
		gbc.gridy = 2; // Hàng 3
		gbc.weightx = 0.75;
		gbc.weighty = 0.2;
		jPanel2.add(jl_player2, gbc);
		jl_point2 = new JLabel("0");
		gbc.gridx = 1; // Cột 1 trong hàng 3
		gbc.gridy = 2; // Hàng 3
		gbc.weightx = 0.25;
		gbc.weighty = 0.2;
		jPanel2.add(jl_point2, gbc);

		jl_player3 = new JLabel("Green's point: ");
		jl_player3.setFont(font);
		gbc.gridx = 0; // Cột 0 trong hàng 4
		gbc.gridy = 3; // Hàng 4
		gbc.weightx = 0.75;
		gbc.weighty = 0.2;
		jl_point3 = new JLabel("0");
		jPanel2.add(jl_player3, gbc);
		gbc.gridx = 1; // Cột 1 trong hàng 4
		gbc.gridy = 3; // Hàng 4
		gbc.weightx = 0.25;
		gbc.weighty = 0.2;
		jPanel2.add(jl_point3, gbc);

		jl_player4 = new JLabel("Yellow's point: ");
		jl_player4.setFont(font);
		gbc.gridx = 0; // Cột 0 trong hàng 5
		gbc.gridy = 4; // Hàng 5
		gbc.weightx = 0.75;
		gbc.weighty = 0.2;
		jPanel2.add(jl_player4, gbc);
		jl_point4 = new JLabel("0");
		gbc.gridx = 1; // Cột 1 trong hàng 5
		gbc.gridy = 4; // Hàng 5
		gbc.weightx = 0.25;
		gbc.weighty = 0.2;
		jPanel2.add(jl_point4, gbc);

		add(jPanel2);

		JPanel jPanel3 = new JPanel();
		JButton restart = new Restart();
		JButton exit = new Exit();
		jPanel3.setLayout(new GridLayout(2, 1));
		jPanel3.add(restart);
		jPanel3.add(exit);
		jPanel3.setBackground(Color.LIGHT_GRAY);
		add(jPanel3, BorderLayout.SOUTH);

		UpdatePlayerWinpointDisplay();
	}

	public static void update() {
		jLabel_turn.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_turn.setVerticalAlignment(SwingConstants.CENTER);
		if (GameManager.currentPlayer == 0) {
			jLabel_turn.setText("BLUE'S TURN!");
			jLabel_turn.setFont(font);
			jLabel_turn.setForeground(Color.blue);
		}
		if (GameManager.currentPlayer == 1) {
			jLabel_turn.setText("RED'S TURN!");
			jLabel_turn.setFont(font);
			jLabel_turn.setForeground(Color.red);
		}
		if (GameManager.currentPlayer == 2) {
			jLabel_turn.setText("GREEN'S TURN!");
			jLabel_turn.setFont(font);
			jLabel_turn.setForeground(Color.green);
		}
		if (GameManager.currentPlayer == 3) {
			jLabel_turn.setText("YELLOW'S TURN!");
			jLabel_turn.setFont(font);
			jLabel_turn.setForeground(Color.yellow);
		}
	}

	private void UpdatePlayerWinpointDisplay() {

		jl_point1.setText(Integer.toString(Leaderboard.GetPlayerWinPoint(1)));
		jl_point2.setText(Integer.toString(Leaderboard.GetPlayerWinPoint(2)));
		jl_point3.setText(Integer.toString(Leaderboard.GetPlayerWinPoint(3)));
		jl_point4.setText(Integer.toString(Leaderboard.GetPlayerWinPoint(4)));
	}

	public void UpdatePlayerPoint(int PlayerWinID) {
		UpdatePoints.updateWinPoints(PlayerWinID);
		UpdatePlayerWinpointDisplay();
	}

	public void WinGame() {

		if (GameManager.currentPlayer == 0) {
			Win_Panel panel = new Win_Panel("BLUE TEAM WIN!!!", Color.BLUE);

		}
		if (GameManager.currentPlayer == 1) {
			Win_Panel panel = new Win_Panel("RED TEAM WIN!!!", Color.RED);

		}
		if (GameManager.currentPlayer == 2) {
			Win_Panel panel = new Win_Panel("GREEN TEAM WIN!!!", Color.GREEN);

		}
		if (GameManager.currentPlayer == 3) {
			Win_Panel panel = new Win_Panel("YELLOW TEAM WIN!!!", Color.YELLOW);

		}

		UpdatePlayerPoint(GameManager.currentPlayer + 1);

	}
}
