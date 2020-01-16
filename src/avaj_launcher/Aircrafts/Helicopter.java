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
		String	weather = weatherTower.getWeather(super.coordinates);
		switch (weather) {
			case "SUN":
				super.coordinates = new Coordinates(super.coordinates.getLongitude() + 10,
					super.coordinates.getLatitude(), super.coordinates.getHeight() + 2);
				Output.getOutput().write("Helicopter#" + name + "(" + id +
						"): Oh. it's hot");
				break;
			case "RAIN":
				super.coordinates = new Coordinates(super.coordinates.getLongitude() + 5,
					super.coordinates.getLatitude(), super.coordinates.getHeight());
				Output.getOutput().write("Helicopter#" + name + "(" + id +
						"): It's wet outside");
				break;
			case "FOG":
				super.coordinates = new Coordinates(super.coordinates.getLongitude() + 1,
					super.coordinates.getLatitude(), super.coordinates.getHeight());
				Output.getOutput().write("Helicopter#" + name + "(" + id +
						"): I can't see anything!");
				break;
			case "SNOW":
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude(), super.coordinates.getHeight() - 12);
				Output.getOutput().write("Helicopter#" + name + "(" + id +
					"): It is cold");
				break;
			default:
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude(), super.coordinates.getHeight() + 1);
				break;
		}

		if (super.coordinates.getHeight() == 0) {
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
