public class GameBoardVisualizer {
  public static String toString(GameBoard gameBoard) {

    GameBoardSymbols[][] board = gameBoard.getBoard();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        result.append(board[i][j].toString());
        result.append(" ");
      }
      result.append("\n");
    }
    return result.toString();
  }
}
