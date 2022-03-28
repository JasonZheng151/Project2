import java.util.Arrays;

/**
 * @author Jason Zheng
 */
public class BattleShipGame {
    private CPUShip cpu; //cpu object
    private BattleShip player;//player object
    boolean gameEnd = false;// game end condtion
    String[][] cpuboard;// board of the cpu
    String[][] playerBoard;// board of the player

    public BattleShipGame() {
        //cpu = new CPUShip();
        //String[][] cpuboard = cpu.makebattleShipGrid();
        //cpu.CPUaddShips(cpuboard);
    }
    /**
    //Creates the means to play the game, starts with creating the cpu board and then player board
     then asking the player to add ships to their board, then the player and cpu take turns trying to hit each other's ship.
     If 5 ships are hit, then either the player or CPU loses according to the conditions.
     */
    public void play() {
        cpu = new CPUShip();
        String[][] cpuboard = cpu.makebattleShipGrid();
        cpu.CPUaddShips(cpuboard);
        player = new BattleShip();
        playerBoard = player.makebattleShipGrid();
        player.addShips(playerBoard);
        int cpuCount = 0;
        int playerCount = 0;
        System.out.println(" ");//creates all the objects
        System.out.println("------------GAME START-------------");// game starts
        while (gameEnd == false) {
            player.hitShip(cpuboard);
            //checks for 5 sunk ships in the form of X
            for (int i = 0; i < cpuboard.length; i++) {
                for (int j = 0; j < cpuboard[0].length; j++) {
                    if (cpuboard[i][j].equals("X")) {
                        cpuCount++;
                        if (cpuCount >= 5) {
                            System.out.println("You have sunk the opponents battleship");
                            System.out.println("YOU WIN");
                            gameEnd = true;

                            break;
                        }
                    }
                }
            }
            cpuCount=0;
            System.out.println("You hit these Coords:"+player.getList());// tiles you already hit

            cpu.CPUhitShip(playerBoard);
            for (int i = 0; i < playerBoard.length; i++) {
                for (int j = 0; j < playerBoard[0].length; j++) {
                    if (playerBoard[i][j].equals("X")) {
                        playerCount++;
                        if (playerCount >= 5) {
                            System.out.println("YOU LOSE");
                            gameEnd = true;
                            System.out.println("You hit these Coords:"+player.getList());
                            break;
                        }
                    }
                }
            }
            playerCount=0;
        }
    }
}




