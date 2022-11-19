public class GameBoardVisualizer {
  public static String toString(GameBoard gameBoard) {

    String HORIZONTAL_LINE = "\n-------\n";

    GameBoardSymbols[][] board = gameBoard.getBoard();
    StringBuilder result = new StringBuilder();
    String currentTextSymbol = "";

    result.append(HORIZONTAL_LINE);
    for (int i = 0; i < board.length; i++) {
      result.append("|");
      for (int j = 0; j < board.length; j++) {
        switch (board[i][j]) {
          case CIRCLE -> result.append("O|");
          case CROSS -> result.append("X|");
          case EMPTY -> result.append(" |");
        }
      }
      result.append(HORIZONTAL_LINE);
    }

//    for (int i = 0; i < board.length; i++) {
//      for (int j = 0; j < board.length; j++) {
//        result.append(board[i][j].toString());
//        result.append(" ");
//      }
//      result.append("\n");
//   }
    return result.toString();
  }
}
