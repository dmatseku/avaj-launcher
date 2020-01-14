package avaj_launcher.Weather;

import avaj_launcher.Coordinates.Coordinates;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider	weatherProvider = new WeatherProvider();
	private String[]				weather = {
			"RAIN",
			"FOG",
			"SUN",
			"SNOW"
	};

	private
	WeatherProvider() {
	}

	public static WeatherProvider
	getProvider() {
		return (weatherProvider);
	}

	public String
	getCurrentWeather(Coordinates coordinates) {
		int randResLong = 0;
		int randResLat = 0;
		int randResHeight = 0;
		Random rand = new Random(coordinates.getHeight()
				+ coordinates.getLongitude() + coordinates.getLatitude());

		randResLong = rand.nextInt(coordinates.getLongitude()) + 1;
		randResLat = rand.nextInt(coordinates.getLatitude()) + 1;
		randResHeight = rand.nextInt(coordinates.getHeight()) + 1;

		int res = rand.nextInt(randResLong + randResHeight
						+ randResLat / 3) % weather.length;

		return (weather[res]);
	}
}
