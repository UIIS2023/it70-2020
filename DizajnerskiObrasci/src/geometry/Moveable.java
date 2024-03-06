package geometry;

public interface Moveable {
	
	//svi clanovi interfejsa su javni, tako da se specifikator pristupa PUBLIC podrazumeva
	void moveTo(int x, int y); //apstraktne metode, nemaju implementaciju
	void moveBy(int byX, int byY);

}
