package avaj_launcher.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

	private int					steps;
	private ArrayList<String[]>	data;

	public
	Input(String fileName) {
		try (FileInputStream fileStream = new FileInputStream(fileName)) {
			BufferedReader bReader = new BufferedReader(
					new InputStreamReader(fileStream));

			initSteps(bReader);
			initData(bReader);

		} catch (IOException e) {
			throw new RuntimeException("File not found");
		}
	}

	private void
	initData(BufferedReader bReader) throws IOException {
		String	line;
		Pattern	pattern = Pattern.compile("((\\w|\\d)+ )((\\w|\\d)+ )" +
											"(\\d+ )(\\d+ )(\\d+)");

		data = new ArrayList<>();
		while ((line = bReader.readLine()) != null) {
			if (!pattern.matcher(line).matches()) {
				throw new RuntimeException("Invalid file");
			}

			data.add(line.split(" "));
		}

		if (data.size() == 0) {
			throw new RuntimeException("Invalid file");
		}
	}

	private void
	initSteps(BufferedReader bReader) throws IOException {
		String line = bReader.readLine();

		if (line == null) {
			throw new RuntimeException("Invalid file");
		}

		if (!(Pattern.compile("\\w+").matcher(line).matches())) {
			throw new RuntimeException("Invalid file");
		}

		steps = Integer.parseInt(line);
	}

	public int
	getStepCount() {
		return (steps);
	}

	public String[]
	getData(int index) {
		if (index >= data.size()) {
			return (null);
		}

		return (data.get(index));
	}
}
