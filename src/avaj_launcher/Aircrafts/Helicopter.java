package avaj_launcher.Aircrafts;

import avaj_launcher.Aircrafts.Aircraft.Aircraft;
import avaj_launcher.Aircrafts.Aircraft.Flyable;
import avaj_launcher.io.Output;
import avaj_launcher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower	weatherTower;


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
				Output.getOutput().write("Helicopter#" + name + "(" + id +
						"): Oh. it's hot");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude() + 5,
					coordinates.getLatitude(), coordinates.getHeight());
				Output.getOutput().write("Helicopter#" + name + "(" + id +
						"): It's wet outside");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude() + 1,
					coordinates.getLatitude(), coordinates.getHeight());
				Output.getOutput().write("Helicopter#" + name + "(" + id +
						"): I can't see anything!");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 12);
				Output.getOutput().write("Helicopter#" + name + "(" + id +
					"): It is cold");
				break;
			default:
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() + 1);
				break;
		}

		if (coordinates.getHeight() == 0) {
			weatherTower.unregister(this);
			Output.getOutput().write("Helicopter#" + name + "(" + id +
					") Landing.");
			Output.getOutput().write("Tower says: Helicopter#" + name + "(" + id
					+ ") unregistered from weather tower.");
		}
	}

	@Override
	public void
	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Output.getOutput().write("Tower says: Helicopter#" + name + "(" + id
				+ ") registered to weather tower.");
	}
}
