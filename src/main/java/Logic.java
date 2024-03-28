import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Random;

/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
(Парадокс Монти Холла — Википедия) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>.
Вывести на экран статистику по победам и поражениям
*/


@NoArgsConstructor
public class Logic {

    private int result;
    @Getter
    private HashMap<Integer, Boolean> results = new HashMap<Integer, Boolean>();
    static int games = 1000;

    @Getter
    private static int winCount = 0;

    @Getter
    Player player;
    Random random = new Random();

    public void createGame() {
        player = new Player();
        for (int i = 1; i < 4; i++) {
            Door.addToDoors(new Door(i, this, player));
        }
    }

    public void generateWinDoor() {
        int winNum = randomChoice(0, 3);
        Door.getDoors().get(winNum).setWin(true);
    }

    public void startGame() {
        createGame();
        int currentGame = 0;

        while (currentGame <= games) {
            generateWinDoor();
            playerChoiceDoor();

            if (Door.getDoors().get(player.getChosenDoor()).isWin()) {
                winCount++;
                results.put(currentGame, true);
            } else {
                winCount--;
                results.put(currentGame, false);
            }

            result = 1000+winCount;
            currentGame++;
            resetDoors();
        }

        for (HashMap.Entry<Integer, Boolean> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("При смене двери игроком на 1000 итераций выигрышных ситуаций будет " + result);
        System.out.println("Что составит " + Math.round((float) result /1000*100) + " %");

    }

    private void resetDoors() {
        for (Door door : Door.getDoors()) {
            door.setWin(false);
        }
    }


    private void playerChoiceDoor() {
        int randomNum = randomChoice(0, 3);
        player.setChosenDoor(randomNum);

    }

    private int randomChoice(int a, int b) {
        return random.nextInt(a, b);
    }


}
