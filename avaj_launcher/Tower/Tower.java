package avaj_launcher.Tower;

import avaj_launcher.Flyable.Flyable;
import java.util.ArrayList;

public class Tower {

	private ArrayList<Flyable>	observers = new ArrayList<>();

	public void
	register(Flyable flyable) {
		observers.add(flyable);
	}

	public void
	unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void
	conditionsChanged() {
		int size = observers.size();
		int i = 0;

		while (i < observers.size()) {
			observers.get(i).updateConditions();
			if (size == observers.size())
				i++;
			else
				size = observers.size();
		}
	}
}
