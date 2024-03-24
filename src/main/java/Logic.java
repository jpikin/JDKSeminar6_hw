import java.util.Random;

public class Logic {

    static Random random = new Random();
    public static void createGame(){
        for (int i = 1; i < 4; i++) {
            Door.addToDoors(new Door(i));
        }
    }

    public static void generateWinDoor(){
        int winNum = random.nextInt(0,3);
        Door.getDoors().get(winNum).setWin(true);
    }
    public static void startGame(){
        createGame();
        generateWinDoor();
    }



}
