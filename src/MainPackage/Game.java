package MainPackage;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {

	private static JFrame window;
	public static GamepPanel gamePanel;
	public static PanelControl control = new PanelControl();;

	public static void main(String[] args) {
		Start();
	}

	public static void Start() {
		GameLoader.Init();

		window = new JFrame("Cờ Cá Ngựa");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setLayout(new BorderLayout());

		gamePanel = new GamepPanel();

		window.add(gamePanel, BorderLayout.WEST);
		window.add(control, BorderLayout.EAST);

		window.pack();

		window.setResizable(false);
		window.setVisible(true);

		GameManager gameManager = new GameManager();
	}

	public static void ReStart() {
		if (Win_Panel.check_null) {
			Win_Panel.win.dispose();
			Win_Panel.check_null = false;
		}
		window.dispose();
		Start();
	}
}
