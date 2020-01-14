package avaj_launcher.Flyable.Aircraft;
import avaj_launcher.Coordinates.*;

import java.util.ArrayList;

public abstract class Aircraft {

    protected long                  id;
    protected String                name;
    protected Coordinates           coordinates;
    private static long             idCounter = 0;

    public
    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = Aircraft.nextId();
    }

    private static long
    nextId() {
        return (++(Aircraft.idCounter));
    }
}
