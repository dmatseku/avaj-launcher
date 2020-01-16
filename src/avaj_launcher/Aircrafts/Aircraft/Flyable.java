package avaj_launcher.Aircrafts.Aircraft;

import avaj_launcher.WeatherTower;

public interface Flyable {

	void	updateConditions();
	void	registerTower(WeatherTower weatherTower);
}
