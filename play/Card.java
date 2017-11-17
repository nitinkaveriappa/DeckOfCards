package play;

public class Card {
	
	String face;
	String suit;
	
	public Card(String faces, String suits){
		this.face = faces;
		this.suit = suits;
	}
	
	public String getFaces() {
		return face;
	}
	public void setFaces(String faces) {
		this.face = faces;
	}
	public String getSuits() {
		return suit;
	}
	public void setSuits(String suits) {
		this.suit = suits;
	}
	
	@Override
	public String toString() {
		return "Card[face=" + face + ",suit=" + suit + "]";
	}
}
