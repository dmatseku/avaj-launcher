package avaj_launcher.Flyable.Aircraft.Vehicles;

import avaj_launcher.Coordinates.Coordinates;
import avaj_launcher.Flyable.Aircraft.Aircraft;
import avaj_launcher.Flyable.Flyable;
import avaj_launcher.Tower.Towers.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower	weatherTower;

	public
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void
	updateConditions() {
		String	weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 10,
					coordinates.getLatitude(), coordinates.getHeight() + 2);
				System.out.println("Helicopter#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): Oh. it's hot");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude() + 5,
					coordinates.getLatitude(), coordinates.getHeight());
				System.out.println("Helicopter#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): It's wet outside");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude() + 1,
					coordinates.getLatitude(), coordinates.getHeight());
				System.out.println("Helicopter#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): I can't see anything!");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 12);
				System.out.println("Helicopter#" + name + "(" + id +
					") (Height = " + coordinates.getHeight() + "): It is cold");
				break;
			default:
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() + 1);
				break;
		}

		if (coordinates.getHeight() == 0) {
			weatherTower.unregister(this);
			System.out.println("Helicopter#" + name + "(" + id +
					") (Height = " + coordinates.getHeight() +
					"): Landing.");
			System.out.println("Tower says: Helicopter#" + name + "(" + id
					+ ") unregistered from weather tower.");
		}
	}

	@Override
	public void
	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + name + "(" + id
				+ ") registered to weather tower.");
	}
}
