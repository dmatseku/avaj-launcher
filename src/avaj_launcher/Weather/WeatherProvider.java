package avaj_launcher.Weather;

import avaj_launcher.Aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider	weatherProvider = new WeatherProvider();
	private static String[]			weather = {
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
		int randResLong;
		int randResLat;
		int randResHeight;
		Random rand = new Random(coordinates.getHeight()
				+ coordinates.getLongitude() + coordinates.getLatitude());

		randResLong = rand.nextInt(coordinates.getLongitude() + 1) + 1;
		randResLat = rand.nextInt(coordinates.getLatitude() + 1) + 1;
		randResHeight = rand.nextInt(coordinates.getHeight() + 1) + 1;

		int res = rand.nextInt(randResLong + randResHeight
						+ randResLat / 3 + 1) % weather.length;

		return (weather[res]);
	}
}
