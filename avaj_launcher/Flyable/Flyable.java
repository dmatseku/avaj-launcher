package avaj_launcher.Flyable;

import avaj_launcher.Tower.Towers.WeatherTower;

public interface Flyable {

	void	updateConditions();
	void	registerTower(WeatherTower weatherTower);
}
