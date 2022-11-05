//Zawiera logikę gry

public class GameBoardManager {

  private final GameBoard gameBoard;
  private final Player[] players = new Player[2];
  private int currentTurnPlayerNumber = 1;

  public GameBoardManager(Player player1, Player player2, GameBoard gameBoard){
    this.gameBoard = gameBoard;
    this.players[0] = player1;
    this.players[1] = player2;
  }

  public void gameStep() {

  }


}
