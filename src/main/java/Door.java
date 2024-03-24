import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Door {
    @Getter
    private static List<Door> doors = new ArrayList<>();
    private final int doorNumber;
    @Setter @Getter
    private boolean win = false;

    @Setter
    private boolean userMarker = false;

    public Door(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public static void addToDoors(Door door) {
        doors.add(door);
    }

    @Override
    public String toString() {
        return "Дверь " + doorNumber;
    }

}
