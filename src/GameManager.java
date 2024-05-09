import java.util.ArrayList;
import java.util.List;

public class GameManager {
	public static GameManager instance;

	Player[] PlayerList;
	public static int currentPlayer = 0;
	int temp;

	public List<Horse> HorseOnBoard;

	private Dice dice;

	public GameManager() {
		instance = this;

		Init();
//		PlayerList[0].horseList.get(0).Start();
//		PlayerList[0].horseList.get(0).Move(55);
//		PlayerList[0].horseList.get(1).Start();
//		PlayerList[0].horseList.get(1).Move(55 - 6);
//		PlayerList[0].horseList.get(2).Start();
//		PlayerList[0].horseList.get(2).Move(55 - 12);
//		PlayerList[0].horseList.get(3).Start();
//		PlayerList[0].horseList.get(3).Move(55 - 18);

//		PlayerList[0].horseList.get(1).Start();
//		PlayerList[0].horseList.get(1).Move(6);
//		PlayerList[0].horseList.get(2).Start();
//		PlayerList[0].horseList.get(2).Move(12);
//		PlayerList[0].horseList.get(3).Start();
//		PlayerList[0].horseList.get(3).Move(8);
//		PlayerList[0].horseList.get(1).Start();
//		PlayerList[0].horseList.get(1).Move(55 - 6);
//		PlayerList[0].horseList.get(2).Start();
//		PlayerList[0].horseList.get(2).Move(55 - 12);
//		PlayerList[0].horseList.get(3).Start();
//		PlayerList[0].horseList.get(3).Move(55 - 18);
	}

	private void Init() {
		HorseOnBoard = new ArrayList<>();
		InitPlayerList();
		InitDice();
	}

	private void InitDice() {
		dice = new Dice();
	}

	private void InitPlayerList() {
		PlayerList = new Player[4];
		for (int i = 0; i < 4; i++) {
			Player newPlayer = new Player(i);
			PlayerList[i] = newPlayer;
		}
		currentPlayer = 0;
	}

	public void HorseSelected(Horse horse) {
		if (dice.diceValue == 0 || dice.isPlaying) {
			return;
		}

		if (horse.team == PlayerList[currentPlayer].team) {
			if (horse.isOnBoard) {
				int CheckCanMove = CheckHorseCanMove(horse);
				if (CheckCanMove != -1) {
					currentPlayer += 1;

					if (CheckCanMove == 1) {
						horse.Move(dice.diceValue);

						if (currentPlayer == 4) {
							temp = 0;
							if (CheckCurrentPlayerWin(temp)) {
								PanelControl.WinGame();

								// Next();
							}
						} else {
							if (CheckCurrentPlayerWin(currentPlayer)) {
								PanelControl.WinGame();

								// Next();
							}
						}

					} else {
						KillHorse(Horse.IndexAfterMove(horse, dice.diceValue));
						horse.Move(dice.diceValue);
					}

					if (dice.diceValue == 6) {
						currentPlayer -= 1;
					}

					dice.diceValue = 0;
					currentPlayer %= 4;
				}
			} else {
				if (CheckHorseCanStart(horse)) {
					KillHorse(horse.team * 14);
					horse.Start();

					dice.diceValue = 0;
				}
			}
		}
	}

	public int CheckHorseCanMove(Horse _horse) {
		int canMove = 1;
		for (int i = 0; i < HorseOnBoard.size(); i++) {
			if (HorseOnBoard.get(i).PositionIndex != _horse.PositionIndex) {
				if (HorseOnBoard.get(i).isWin)
					continue;
				if ((Horse.IndexAfterMove(_horse, dice.diceValue) - HorseOnBoard.get(i).PositionIndex) > 0
						&& (Horse.IndexAfterMove(_horse, dice.diceValue) - HorseOnBoard.get(i).PositionIndex) <= 6) {
					return -1;
				}
				if (HorseOnBoard.get(i).PositionIndex == Horse.IndexAfterMove(_horse, dice.diceValue)) {

					if (HorseOnBoard.get(i) == _horse || HorseOnBoard.get(i).team == _horse.team) {
						return -1;
					} else {
						canMove = 2;
					}
				}
			}

			if (_horse.StepCount == 55) {
				return 1;
			}

			if (_horse.StepCount + dice.diceValue > 55 && !_horse.isOnStable) {
				return -1;
			}

		}
		return canMove;
	}

	public void KillHorse(int horsePosIndex) {
		for (int i = 0; i < HorseOnBoard.size(); i++) {

			if (HorseOnBoard.get(i).PositionIndex == horsePosIndex) {
				HorseOnBoard.get(i).Die();
				break;
			}
		}
	}

	public boolean CheckHorseCanStart(Horse _horse) {
//    	System.out.println( PlayerList[currentPlayer].horseList.size());
		if (dice.diceValue != 6) {
			return false;
		}

		for (int i = 0; i < HorseOnBoard.size(); i++) {
			if (HorseOnBoard.get(i).PositionIndex == _horse.team * 14 && HorseOnBoard.get(i).team == _horse.team
					&& HorseOnBoard.get(i) != _horse) {
				return false;
			}
		}
		return true;
	}

	public void CheckPlayerCanMove() {
		boolean next = true;
		for (Horse horse : PlayerList[currentPlayer].horseList) {
			if (horse.isWin)
				continue;
			else {
				if (horse.isOnBoard) {
					if (CheckHorseCanMove(horse) != -1) {
						next = false;
					}
				} else {
					if (CheckHorseCanStart(horse)) {
						next = false;
					}
				}
			}
		}
//		System.out.println(PlayerList[currentPlayer].horseList.size());
		if (next) {
			Next();
		}

	}

	public void Next() {
		currentPlayer += 1;
//		if (dice.diceValue == 6)
//			currentPlayer -= 1;
		dice.diceValue = 0;

		if (currentPlayer == 4) {
			currentPlayer = 0;
		}

//		if (CheckCurrentPlayerWin()) {
//			if (currentPlayer == 4) {
//				currentPlayer += 1;
//			}
//		}

		System.out.println("next");
	}

	public boolean CheckCurrentPlayerWin(int x) {
		return PlayerList[x].HorseWin == 4;
	}
//	public boolean CheckCurrentPlayerWin() {
//		return PlayerList[currentPlayer].HorseWin == 4;
//	}
}
