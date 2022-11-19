import java.util.Random;

public class RandomPlayer extends Player{

  @Override
  public int[] makeMove(GameBoardSymbols[][] board) {
    Random random = new Random();

    return new int[]{random.nextInt(board[0].length), random.nextInt(board.length)};
  }
}
