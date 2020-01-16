package avaj_launcher;

import avaj_launcher.Aircrafts.AircraftFactory;
import avaj_launcher.io.Input;

public class Main {

    public static void
    main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments");
            return;
        }

        try {
            Input input = new Input(args[0]);
            WeatherTower weatherTower = new WeatherTower();
            String[] elemData;

            for (int i = 0; (elemData = input.getData(i)) != null; i++) {
                AircraftFactory.newAircraft(
                        elemData[0],
                        elemData[1],
                        Integer.parseInt(elemData[2]),
                        Integer.parseInt(elemData[3]),
                        Integer.parseInt(elemData[4])
                ).registerTower(weatherTower);
            }

            int steps = input.getStepCount();
            while (steps-- > 0) {
                weatherTower.changeWeather();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
