import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class Logic {

    static int games = 1000;

    @Getter
    private static int winCount = 0;

    @Getter
    Player player;
    Random random = new Random();
    public void createGame(){
        player = new Player();
        for (int i = 1; i < 4; i++) {
            Door.addToDoors(new Door(i, this, player));
        }
    }

    public void generateWinDoor(){
        int winNum = randomChoice(0,3);
        Door.getDoors().get(winNum).setWin(true);
    }
    public void startGame(){

        int currentGame = 0;

        while (currentGame <= games) {
            createGame();
            generateWinDoor();
            playerChoiceDoor();

            if(Door.getDoors().get(player.getChosenDoor()).isWin()){

            }


        currentGame++;
        }


    }

    private void playerChoiceDoor() {
        int randomNum = randomChoice(0,3);
        player.setChosenDoor(randomNum);

    }

    private int randomChoice(int a, int b){
        return random.nextInt(a,b);
    }



}
