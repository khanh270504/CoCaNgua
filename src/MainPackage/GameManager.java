package MainPackage;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
	public static GameManager instance;

	public Player[] PlayerList;
	public static int currentPlayer = 0;

	public List<Horse> HorseOnBoard;
	private static Dice dice;

	public GameManager() {
		instance = this;

		Init();
//
//		PlayerList[0].horseList.get(0).Start();
//		PlayerList[0].horseList.get(0).Move(0);
//		PlayerList[1].horseList.get(0).Start();
//		PlayerList[1].horseList.get(0).Move(0);
//		PlayerList[2].horseList.get(0).Start();
//		PlayerList[2].horseList.get(0).Move(0);
//		PlayerList[3].horseList.get(0).Start();
//		PlayerList[3].horseList.get(0).Move(55);
//	
//	PlayerList[0].horseList.get(1).Start();
//	PlayerList[0].horseList.get(1).Move(3);
//	PlayerList[0].horseList.get(2).Start();
//	PlayerList[0].horseList.get(2).Move(15);
//	PlayerList[0].horseList.get(3).Start();
//	PlayerList[0].horseList.get(3).Move(9);
//	
//	PlayerList[1].horseList.get(1).Start();
//	PlayerList[1].horseList.get(1).Move(5);
//	PlayerList[1].horseList.get(2).Start();
//	PlayerList[1].horseList.get(2).Move(12);
//	PlayerList[1].horseList.get(3).Start();
//	PlayerList[1].horseList.get(3).Move(6);
//	
//	PlayerList[2].horseList.get(1).Start();
//	PlayerList[2].horseList.get(1).Move(55 - 14 * 2 - 3);
//	PlayerList[2].horseList.get(2).Start();
//	PlayerList[2].horseList.get(2).Move(12);
//	PlayerList[3].horseList.get(2).Start();
//	PlayerList[3].horseList.get(2).Move(12);
	}

	private void Init() {
		HorseOnBoard = new ArrayList<>();
		InitPlayerList();
		InitDice();
	}

	public static void InitDice() {
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

					if (CheckCanMove == 1) {
						horse.Move(dice.diceValue);
						if (CheckCurrentPlayerWin()) {

							Game.control.WinGame();

						}

					} else {
						KillHorse(Horse.IndexAfterMove(horse, dice.diceValue));
						horse.Move(dice.diceValue);
					}

					if (dice.diceValue == 6) {
						currentPlayer -= 1;
					}

					dice.diceValue = 0;
					currentPlayer += 1;
					if (currentPlayer == 4) {
						currentPlayer = 0;
					}

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

				for (int j = 1; j < dice.diceValue; j++) {
					if (Horse.IndexAfterMove(_horse, j) == HorseOnBoard.get(i).PositionIndex) {
						return -1;
					}
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
		if (next) {
			Next();
		}

	}

	public void Next() {
		currentPlayer += 1;
		if (dice.diceValue == 6)
			currentPlayer -= 1;
		dice.diceValue = 0;

		if (currentPlayer == 4) {
			currentPlayer = 0;
		}
		PanelControl.update();

	}

	public boolean CheckCurrentPlayerWin() {
		return PlayerList[currentPlayer].HorseWin == 4;
	}

	public static Dice getDice() {
		return dice;
	}

}