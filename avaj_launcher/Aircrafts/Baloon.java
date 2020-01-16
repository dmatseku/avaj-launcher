package avaj_launcher.Aircrafts;

import avaj_launcher.Aircrafts.Aircraft.Flyable;
import avaj_launcher.Aircrafts.Aircraft.Aircraft;
import avaj_launcher.io.Output;
import avaj_launcher.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower	weatherTower;


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
				Output.getOutput().write("Baloon#" + name + "(" + id +
						"): Good weather outside!");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 5);
				Output.getOutput().write("Baloon#" + name + "(" + id +
						"): Good I have a furnace!");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 3);
				Output.getOutput().write("Baloon#" + name + "(" + id +
						"): Visibility is zero!");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() - 15);
				Output.getOutput().write("Baloon#" + name + "(" + id +
						"): To melt a furnace is very difficult!");
				break;
			default:
				coordinates = new Coordinates(coordinates.getLongitude(),
					coordinates.getLatitude(), coordinates.getHeight() + 1);
				break;
		}

		if (coordinates.getHeight() == 0) {
			weatherTower.unregister(this);
			Output.getOutput().write("Baloon#" + name + "(" + id +
					") Landing.");
			Output.getOutput().write("Tower says: Baloon#" + name + "(" + id
					+ ") unregistered from weather tower.");
		}
	}

	@Override
	public void
	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Output.getOutput().write("Tower says: Baloon#" + name + "(" + id
							+ ") registered to weather tower.");
	}
}
