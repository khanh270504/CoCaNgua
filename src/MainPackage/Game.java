package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Game {

	private static JFrame window;
	public static GamepPanel gamePanel;
	public static PanelControl control = new PanelControl();;

	public static void main(String[] args) {
		Start();

		GameLoop();
	}

	public static void Start() {
		GameLoader.Init();

		window = new JFrame("Cờ Cá Ngựa");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setSize(00, 600);
		window.setLayout(new BorderLayout());

		gamePanel = new GamepPanel();

		window.add(gamePanel, BorderLayout.WEST);
		window.add(control, BorderLayout.EAST);

		window.pack();
		window.setBackground(Color.black);

		window.setResizable(false);
		window.setVisible(true);

		GameManager gameManager = new GameManager();
	}

	public static void GameLoop() {
		long currentTime = System.currentTimeMillis();
		long lastTime = System.currentTimeMillis();
		double t = 1000 / GameLoader.FPS;
		while (true) {
			currentTime = System.currentTimeMillis();
			double deltaTime = (currentTime - lastTime);
			if (deltaTime < t) {
				continue;

			}

			lastTime = currentTime;
		}
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
