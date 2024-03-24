import java.util.Random;

public class Logic {

    static Random random = new Random();
    public static void createGame(){
        for (int i = 1; i < 4; i++) {
            Door.addToDoors(new Door(i));
        }
    }

    public static void generateWinDoor(){
        int winNum = randomChoice();
        Door.getDoors().get(winNum).setWin(true);
    }
    public static void startGame(){
        createGame();
        generateWinDoor();
        userChoiceDoor();
    }

    private static void userChoiceDoor() {
        Door.getDoors().get(randomChoice()).setUserMarker(true);
    }

    private static int randomChoice(){
        return random.nextInt(0,3);
    }



}
