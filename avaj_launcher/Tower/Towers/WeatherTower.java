package avaj_launcher.Tower.Towers;

import avaj_launcher.Coordinates.Coordinates;
import avaj_launcher.Tower.Tower;
import avaj_launcher.Weather.WeatherProvider;

public class WeatherTower extends Tower {

	public
	WeatherTower() {
	}

	public String
	getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void
	changeWeather() {
		conditionsChanged();
	}
}
