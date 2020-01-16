package avaj_launcher.Aircrafts;

import avaj_launcher.Aircrafts.Aircraft.Aircraft;
import avaj_launcher.Aircrafts.Aircraft.Flyable;
import avaj_launcher.io.Output;
import avaj_launcher.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower	weatherTower;


	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void
	updateConditions() {
		String	weather = weatherTower.getWeather(super.coordinates);
		switch (weather) {
			case "SUN":
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude() + 10, super.coordinates.getHeight() + 2);
				Output.getOutput().write("JetPlane#" + name + "(" + id +
						"): I wanted a cocktail :)");
				break;
			case "RAIN":
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude() + 5, super.coordinates.getHeight());
				Output.getOutput().write("JetPlane#" + name + "(" + id +
						"): It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude() + 1, super.coordinates.getHeight());
				Output.getOutput().write("JetPlane#" + name + "(" + id +
						"): Flying on devices.");
				break;
			case "SNOW":
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude(), super.coordinates.getHeight() - 7);
				Output.getOutput().write("JetPlane#" + name + "(" + id +
						"): It's raining. Better watch out for lightings.");
				break;
			default:
				super.coordinates = new Coordinates(super.coordinates.getLongitude(),
					super.coordinates.getLatitude(), super.coordinates.getHeight() + 1);
				break;
		}

		if (super.coordinates.getHeight() == 0) {
			weatherTower.unregister(this);
			Output.getOutput().write("JetPlane#" + name + "(" + id +
					") Landing.");
			Output.getOutput().write("Tower says: JetPlane#" + name + "(" + id
					+ ") unregistered from weather tower.");
		}
	}

	@Override
	public void
	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Output.getOutput().write("Tower says: JetPlane#" + name + "(" + id
				+ ") registered to weather tower.");
	}
}
