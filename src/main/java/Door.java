import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Door {

    Player player;

    @Getter
    private static List<Door> doors = new ArrayList<>();
    private final int doorNumber;

    @Setter @Getter
    private boolean win = false;
    Logic logic;

    @Setter @Getter
    private boolean userMarker = false;

    public Door(int doorNumber, Logic logic, Player player) {
        this.doorNumber = doorNumber;
        this.logic = logic;
        this.player = player;
    }

    public static void addToDoors(Door door) {
        doors.add(door);
    }

    @Override
    public String toString() {
        return "Дверь " + doorNumber;
    }

}
