import java.util.Scanner;

public class Game {
        private Board board;
        private Player player1;
        private Player player2;
        private Scanner scanner;

        public Game(){
            board = new Board();
            scanner = new Scanner(System.in);
        }

        public void start(){
            System.out.println("Welcome to Tic Tac Toe Game! ");
            System.out.println("Enter name for Player 1 (X): ");
            player1 = new Player(scanner.nextLine(), 'X');

            System.out.println("Enter name for player 2 (X): ");
            player2 = new Player(scanner.nextLine(), 'O');

            Player currentPlayer = player1;
            boolean gameEnded = false;

            while(!gameEnded){
                System.out.println("\n" +currentPlayer.getName() + "'s Turn (" + currentPlayer.getMark() + ")");
                int row, col;

                while(true){
                    System.out.println("Enter row (0-2): ");
                    row = scanner.nextInt();

                    System.out.println("Enter col (0-2): ");
                    col = scanner.nextInt();

                    if(row>=0 && row <=2 && col>=0 && col<=2){

                        if(board.isCellEmpty(row,col)){
                            break;
                        }else{
                            System.out.println("Cell already taken. Try a different position.");
                        }
                    } else{
                        System.out.println("Invalid input. Enter row and column between 0 and 2.");
                    }
                }

                board.placMark(row,col,currentPlayer.getMark());
                board.printBoard();

                if(board.checkWin(currentPlayer.getMark())){
                    System.out.println(currentPlayer.getName()+ "Win!");
                    gameEnded =true;
                }else{
                    if (board.isFull()){
                        System.out.println("It's a Draw!");
                        gameEnded = true;
                    }else{
                        currentPlayer = (currentPlayer==player1) ? player2 : player1;
                    }
                }
                System.out.println("Game over!");
            }
        }
}
