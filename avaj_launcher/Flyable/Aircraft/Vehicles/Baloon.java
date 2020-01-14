package avaj_launcher.Flyable.Aircraft.Vehicles;

import avaj_launcher.Coordinates.Coordinates;
import avaj_launcher.Flyable.Aircraft.Aircraft;
import avaj_launcher.Flyable.*;
import avaj_launcher.Tower.Towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	WeatherTower weatherTower;

	public
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void
	updateConditions() {
		String	weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 2,
					coordinates.getLatitude(), coordinates.getHeight() + 4);
				System.out.println("Baloon#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): Good weather outside!");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 5);
				System.out.println("Baloon#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): Good I have a furnace!");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 3);
				System.out.println("Baloon#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): Visibility is zero!");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 15);
				System.out.println("Baloon#" + name + "(" + id +
						") (Height = " + coordinates.getHeight() +
						"): To melt a furnace is very difficult!");
				break;
			default:
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() + 1);
				break;
		}

		if (coordinates.getHeight() == 0) {
			weatherTower.unregister(this);
			System.out.println("Baloon#" + name + "(" + id +
					") (Height = " + coordinates.getHeight() +
					"): Landing.");
			System.out.println("Tower says: Baloon#" + name + "(" + id
					+ ") unregistered from weather tower.");
		}
	}

	@Override
	public void
	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + name + "(" + id
							+ ") registered to weather tower.");
	}
}
