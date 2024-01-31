import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class CellComponent extends JComponent  {

	public static enum CellType {
		FLOOR, WALL, START, EXIT, LAVA, GOLD, LOCKRED, KEYRED, LOCKGREEN, KEYGREEN, LOCKBLUE, KEYBLUE
	};
	
	private CellType type;
	private String IMG_FLOOR = "floor.jpg";
	private String IMG_WALL = "wall.jpg";
	private String IMG_START = "start.jpg";
	private String IMG_EXIT = "exit.jpg";
	private String IMG_LAVA = "lava.jpg";
	private String IMG_GOLD = "gold.jpg";
	private String IMG_LOCKRED = "lock-red.jpg";
	private String IMG_KEYRED = "key-red.jpg";
	private String IMG_LOCKGREEN = "lock-green.jpg";
	private String IMG_KEYGREEN = "key-green.jpg";
	private String IMG_LOCKBLUE = "lock-blue.jpg";
	private String IMG_KEYBLUE = "key-blue.jpg";


	
	public void setType(CellType type) {
		this.type = type;
		repaint();
	}
	
	/**
	 * Draws the different types of map cells on the screen
	 * 
	 * @param g
	 *            Graphics object used to draw the cells on the screen
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		
		String imgFile = "";
		if (type == CellType.FLOOR) {
			imgFile = IMG_FLOOR;
		} else if (type == CellType.WALL) {
			imgFile = IMG_WALL;
		} else if (type == CellType.START) {
			imgFile = IMG_START;
		} else if (type == CellType.EXIT) {
			imgFile = IMG_EXIT;
		} else if (type == CellType.LAVA) {
			imgFile = IMG_LAVA;
		} else if (type == CellType.GOLD) {
			imgFile = IMG_GOLD;
		} else if (type == CellType.LOCKRED) {
			imgFile = IMG_LOCKRED;
		} else if (type == CellType.KEYRED) {
			imgFile = IMG_KEYRED;
		} else if (type == CellType.LOCKGREEN) {
			imgFile = IMG_LOCKGREEN;
		} else if (type == CellType.KEYGREEN) {
			imgFile = IMG_KEYGREEN;
		} else if (type == CellType.LOCKBLUE) {
			imgFile = IMG_LOCKBLUE;
		} else if (type == CellType.KEYBLUE) {
			imgFile = IMG_KEYBLUE;
		}


		try {
			Image img = new ImageIcon(imgFile).getImage();
			g2d.drawImage(img, 0, 0, width, height, null);
		} catch (Exception e) {
			System.out.println("Error opening file " + imgFile);
		}

	}
	
}
