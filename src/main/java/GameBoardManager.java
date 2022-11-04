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

  public boolean isMoveValid(int x, int y) {
    return gameBoard.getBoard()[x][y] == GameBoardSymbols.EMPTY;
  }

  public boolean isWinningMove(int x, int y, GameBoardSymbols symbol) {
    return isWinningRow(x, symbol) || isWinningColumn(y, symbol) || isWinningDiagonal(symbol);
  }

  private boolean isWinningRow(int x, GameBoardSymbols symbol) {
    for (int i = 0; i < gameBoard.getSize(); i++) {
      if (gameBoard.getBoard()[x][i] != symbol) {
        return false;
      }
    }
    return true;
  }

  private boolean isWinningColumn(int y, GameBoardSymbols symbol) {
    for (int i = 0; i <= gameBoard.getSize(); i++) {
      if (gameBoard.getBoard()[i][y] != symbol) {
        return false;
      }
    }
    return true;
  }

  private boolean isWinningDiagonal(GameBoardSymbols symbol) {
    for (int i = 0; i <= gameBoard.getSize(); i++) {
      if (gameBoard.getBoard()[i][i] != symbol || gameBoard.getBoard()[i][gameBoard.getSize() - i] != symbol) {
        return false;
      }
    }
    return true;
  }

}
