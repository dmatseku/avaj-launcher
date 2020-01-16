package avaj_launcher;

import avaj_launcher.Aircrafts.Coordinates;
import avaj_launcher.Tower.Tower;
import avaj_launcher.Weather.WeatherProvider;

public class WeatherTower extends Tower {

	public String
	getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void
	changeWeather() {
		conditionsChanged();
	}
}
