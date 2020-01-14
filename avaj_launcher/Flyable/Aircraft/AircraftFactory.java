package avaj_launcher.Flyable.Aircraft;

import avaj_launcher.Coordinates.Coordinates;
import avaj_launcher.Flyable.Flyable;
import avaj_launcher.Flyable.Aircraft.Vehicles.*;

import java.util.*;

public class AircraftFactory {

	private interface				ICreator {
		Flyable	create(String name, int longitude, int latitude, int height);
	}

	private static List<String>		types =
			Arrays.asList("Baloon", "JetPlane", "Helicopter");

	private static List<ICreator>	creators =
								Arrays.asList(AircraftFactory::newBaloon,
											AircraftFactory::newJetPlane,
											AircraftFactory::newHelicopter);


	private static Flyable
	newJetPlane(String name, int longitude, int latitude, int height) {
		return (new JetPlane(name, new Coordinates(longitude, latitude,
																height)));
	}

	private static Flyable
	newHelicopter(String name, int longitude, int latitude, int height) {
		return (new Helicopter(name, new Coordinates(longitude, latitude,
				height)));
	}

	private static Flyable
	newBaloon(String name, int longitude, int latitude, int height) {
		return (new Baloon(name, new Coordinates(longitude, latitude,
				height)));
	}

	public static Flyable
	newAircraft(String type, String name,
								  int longitude, int latitude, int height) {
		int	index = types.indexOf(type);

		if (index < 0)
			throw new RuntimeException("Unknown type");
		return (creators.get(index).create(name, longitude, latitude, height));
	}
}
