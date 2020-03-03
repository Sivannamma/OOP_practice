package SelfGUI;

public class Student {
	private int id;
	private int age;
	private String name;
	private City city;
	private int NIL = -1; // in case a field is empty.

	public Student(int id, String name) {
		setId(id);
		setName(name);
		this.age = NIL;
		this.city = null;
	}

	public Student(int id, String name, int age, City city) {
		this(id, name); // setting the name and id with the first constructor
		// setting the other variable with the setters
		setAge(age);
		setCity(city);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String toString() {
		return "[Name: " + name + " id: " + id + "]";
	}

}
