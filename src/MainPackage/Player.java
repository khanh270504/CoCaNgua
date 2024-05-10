package MainPackage;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public int team;
	public List<Horse> horseList;
	public String horseImageURL;

	public int HorseWin = 0;

	public Player(int _team) {

		team = _team;
		HorseInit();
	}

	private void HorseInit() {
		horseList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Horse newHorse = new Horse("resources/images/H" + Integer.toString(team) + ".GIF", team, i);

			horseList.add(newHorse);
		}
	}

}
