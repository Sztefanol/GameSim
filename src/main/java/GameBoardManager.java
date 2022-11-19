//Zawiera logikę gry

public class GameBoardManager {

  private final GameBoard gameBoard;
  private final Player[] players = new Player[2];
  private int currentTurnPlayerNumber = 1;
  private GameState gameState = GameState.IN_GAME;

  public GameBoardManager(Player player1, Player player2, GameBoard gameBoard){
    this.gameBoard = gameBoard;
    this.players[0] = player1;
    this.players[1] = player2;
  }

  public GameStepResult gameStep() {
    if(gameState != GameState.IN_GAME){
      return GameStepResult.GAME_END;
    }

    int[] currentMove = players[currentTurnPlayerNumber - 1].makeMove(gameBoard.getBoard());
    int x = currentMove[0];
    int y = currentMove[1];
    GameBoardSymbols currentPlayerSymbol = GameBoardSymbols.values()[currentTurnPlayerNumber];

    if(!TicTacToeRuleChecker.isMoveValid(x, y, gameBoard)) {
      return GameStepResult.ILLEGAL_MOVE;
    }

    gameBoard.addMove(x, y, currentPlayerSymbol);

    if(TicTacToeRuleChecker.isWinningMove(x, y, currentPlayerSymbol, gameBoard)) {
      gameState = GameState.values()[currentTurnPlayerNumber];
      return GameStepResult.GAME_END;
    }

    if(gameBoard.isBoardFull()) {
      gameState = GameState.DRAW;
      return GameStepResult.GAME_END;
    }

    switchPlayers();
    return GameStepResult.MOVE_OK;
  }

  private void switchPlayers() {
    if (currentTurnPlayerNumber == 1) {
      currentTurnPlayerNumber = 2;
    } else {
      currentTurnPlayerNumber = 1;
    }
  }

  public int getCurrentTurnPlayerNumber() {
    return currentTurnPlayerNumber;
  }

  public GameState getGameState() {
    return gameState;
  }
}
