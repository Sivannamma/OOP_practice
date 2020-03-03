package ENUM;

public class CardsMain {
	public static void main(String[] args) {
		Card card = new Card(3, Shape.HEART);
		Card card2 = new Card(5, Shape.DIAMOND);
		System.out.println(card.SHAPE == card2.SHAPE);
		Shape [] s= Shape.values();
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
