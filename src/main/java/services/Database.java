package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Database {
	public static boolean doesExist(String username, String password, File fileToSearchInto) {
		try (Scanner scanner = new Scanner(fileToSearchInto)) {
			while (scanner.hasNext()) {
				String user = scanner.nextLine();

				String[] parameters = user.split(",");

				if (parameters[0].equals(username) && parameters[1].equals(password))
					return true;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
}
