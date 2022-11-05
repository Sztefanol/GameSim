public class TicTacToeRuleChecker {
  public static boolean isMoveValid(int x, int y, GameBoard gameBoard) {
    return gameBoard.getBoard()[x][y] == GameBoardSymbols.EMPTY;
  }

  public static boolean isWinningMove(int x, int y, GameBoardSymbols symbol, GameBoard gameBoard) {
    return isWinningRow(x, symbol, gameBoard) || isWinningColumn(y, symbol, gameBoard) || isWinningDiagonal(symbol, gameBoard);
  }

  private static boolean isWinningRow(int x, GameBoardSymbols symbol, GameBoard gameBoard) {
    for (int i = 0; i < gameBoard.getSize(); i++) {
      if (gameBoard.getBoard()[x][i] != symbol) {
        return false;
      }
    }
    return true;
  }

  private static boolean isWinningColumn(int y, GameBoardSymbols symbol, GameBoard gameBoard) {
    for (int i = 0; i <= gameBoard.getSize(); i++) {
      if (gameBoard.getBoard()[i][y] != symbol) {
        return false;
      }
    }
    return true;
  }

  private static boolean isWinningDiagonal(GameBoardSymbols symbol, GameBoard gameBoard) {
    for (int i = 0; i <= gameBoard.getSize(); i++) {
      if (gameBoard.getBoard()[i][i] != symbol || gameBoard.getBoard()[i][gameBoard.getSize() - i] != symbol) {
        return false;
      }
    }
    return true;
  }

}
