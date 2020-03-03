package SelfGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JFrame;

public class GUIStudent extends JFrame implements ActionListener, MouseListener {

	LinkedList<Student> list;

	public GUIStudent() {
		list = new LinkedList<Student>();
		init_gui_window();
	}

	private void init_gui_window() {
		// the size of the window
		this.setSize(600, 600);
		// setting that the program is terminated when we close 'X' on the window as
		// well.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("Arial", Font.BOLD, 13);
		this.setFont(f);

		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);

		Menu studentInfo = new Menu("Student info");
		studentInfo.addActionListener(this);
		// adding to the tag student info
		MenuItem setAge = new MenuItem("Set age");
		setAge.addActionListener(this);
		MenuItem setCity = new MenuItem("Set City");
		setCity.addActionListener(this);
		MenuItem setName = new MenuItem("Set Name");
		setName.addActionListener(this);
		studentInfo.add(setAge);
		studentInfo.add(setCity);
		studentInfo.add(setName);

		Menu generalActions = new Menu("General actions");
		generalActions.addActionListener(this);
		// adding to the tag general actions
		MenuItem add_student = new MenuItem("Add student");
		add_student.addActionListener(this);
		MenuItem delete_student = new MenuItem("Delete student");
		delete_student.addActionListener(this);
		MenuItem print_student = new MenuItem("Print students");
		print_student.addActionListener(this);
		generalActions.add(add_student);
		generalActions.add(delete_student);
		generalActions.add(print_student);

		// adding to the menu bar
		menuBar.add(studentInfo);
		menuBar.add(generalActions);

		this.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		switch (str) {
		case "Set age": {
			setAge();
			break;
		}
		case "Set City": {
			setCity();
			break;
		}
		case "Set Name": {
			setName();
			break;
		}
		case "Add student": {
			addStudent();
			break;
		}
		case "Delete student": {
			removeStudent();
			break;
		}
		case "Print students": {
			System.out.println(this.toString());
			break;
		}

		}
		repaint();

	}

	public void addStudent() {
		int id = MyConsole.readInt("enter ur id");
		String name = MyConsole.readString("enter ur name");
		Student t = new Student(id, name);
		list.add(t);
	}

//returns true if the student is being removed and was contained, false if not contained
	public boolean removeStudent() {
		int id = MyConsole.readInt("enter ur id");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	public void setAge() {
		list.get(find_in_list(MyConsole.readInt("enter ur id"))).setAge(MyConsole.readInt("enter ur age"));
	}

	public void setName() {
		list.get(find_in_list(MyConsole.readInt("enter ur id"))).setName(MyConsole.readString("enter ur name"));
	}

	public void setCity() {

		// list.get(find_in_list(MyConsole.readInt("enter ur
		// id"))).setAge(MyConsole.readString("enter ur id"));
	}

	private int find_in_list(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;

	}

	public String toString() {
		String ans = "{";
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 == list.size())
				ans += list.get(i).toString();
			else
				ans += list.get(i).toString() + " , ";
		}
		return ans + "}";
	}

}
