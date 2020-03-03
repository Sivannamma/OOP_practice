package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Test {
	public static void main(String[] args) {
		// serialize();
		 deserialize();
	}

	private static void serialize() {
		Car car = new Car(1234, "Mazda");
		String filename = "myObj.txt";

		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(car);

			out.close();
			file.close();

			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}

	private static void deserialize() {
		Car car = null;

		try {
			FileInputStream file = new FileInputStream("myObj.txt");
			ObjectInputStream in = new ObjectInputStream(file);

			car = (Car) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized");
			System.out.println(car);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

}