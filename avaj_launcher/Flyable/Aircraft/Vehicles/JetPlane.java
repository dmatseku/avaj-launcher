package avaj_launcher.Flyable.Aircraft.Vehicles;

import avaj_launcher.Coordinates.Coordinates;
import avaj_launcher.Flyable.Aircraft.Aircraft;
import avaj_launcher.Flyable.Flyable;
import avaj_launcher.Tower.Towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

	WeatherTower weatherTower;

	public
	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void
	updateConditions() {
		String	weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
				System.out.println("JetPlane#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): I wanted a cocktail :)");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude() + 5, coordinates.getHeight());
				System.out.println("JetPlane#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude() + 1, coordinates.getHeight());
				System.out.println("JetPlane#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): Flying on devices.");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 7);
				System.out.println("JetPlane#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): It's raining. Better watch out for lightings.");
				break;
			default:
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() + 1);
				break;
		}

		if (coordinates.getHeight() == 0) {
			weatherTower.unregister(this);
			System.out.println("JetPlane#" + name + "(" + id +
					") (Height = " + coordinates.getHeight() +
					"): Landing.");
			System.out.println("Tower says: JetPlane#" + name + "(" + id
					+ ") unregistered from weather tower.");
		}
	}

	@Override
	public void
	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + name + "(" + id
				+ ") registered to weather tower.");
	}
}
