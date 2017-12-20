
public class Minesweeper {

	public static void main(String[] args) {
	System.out.println("Enter size for square board (# of rows and columns): ");
	
	Board b = new Board(IO.readInt());
	b.gui = new MsGUI(b);
	b.gui.setVisible(true);
}
}
