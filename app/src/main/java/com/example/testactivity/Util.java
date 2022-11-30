package com.example.testactivity;

public interface Util {
	static ArrayList<String> readFile(String filepath) {
		try {
			BufferedReader bufReader = new BufferedReader(new FileReader(filepath));
			ArrayList<String> listOfLines = new ArrayList<>();

			String line = null;

			line = bufReader.readLine();

			while (line != null) {
				listOfLines.add(line);
				line = bufReader.readLine();
			}

			bufReader.close();
			return listOfLines;
		} catch (IOException e) {

			return null;

		}

	}
}
