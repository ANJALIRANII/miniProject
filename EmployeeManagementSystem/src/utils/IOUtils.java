package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.org.Emploee;

public interface IOUtils {

	static void storeEmpDetails(Map<String, Emploee> emps, String fileName) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(emps);
		}
	}
	//@SuppressWarnings("unchecked")
	static Map<String, Emploee> restoreEmpDetails(String FileName) {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FileName))) {
			return (Map<String, Emploee>) in.readObject();
		} catch (Exception e) {
			System.out.println("error during de-serial" + e);
			return new HashMap<>();

		}

	}

}
