package avaj_launcher.Aircrafts;

import avaj_launcher.Aircrafts.Aircraft.Flyable;

import java.util.*;

public class AircraftFactory {

	private interface							ICreator {
		Flyable	create(String name, int longitude, int latitude, int height);
	}

	private static HashMap<String, ICreator>	creators = new HashMap<>();

	static {
		creators.put("Baloon", AircraftFactory::newBaloon);
		creators.put("JetPlane", AircraftFactory::newJetPlane);
		creators.put("Helicopter", AircraftFactory::newHelicopter);
	}



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
		ICreator	creator = creators.get(type);

		if (creator == null)
			throw new RuntimeException("Unknown type");
		return (creator.create(name, longitude, latitude, height));
	}
}
