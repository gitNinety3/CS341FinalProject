import java.awt.Component;
import java.awt.Graphics;
import java.util.List;

import javax.swing.Icon;

public abstract class GameObject {
	// EACH GAME OBJECT HAS AN X,Y LOCATION, VELOCITY, AND A DIRECTION
	// DATA MEMEBERS	
	private int x;
	private int y;
	private int velocity;
	private int direction;
	private boolean isHighlighted;

	// EACH GAME OBJECT CAN HAVE A COLLECTION OF IMAGES
	protected Icon myImage;
	protected List<Icon> imageList;
	protected int currentImage;

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 1;
		currentImage = 0;
		isHighlighted = false;
		
	}

	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
		
	}

	// ********************************************

	// ABSTRACT METHODS: MOVEMENT OF THE GAME OBJECT
	public abstract void move(Canvas c);
	public abstract void setImage();
	
	// WAS GONNA HAVE TWO METHODS FOR HIGHLIGHTED
	// AND FO AUTOMATED BUT IT WAS POINTLESS
	//public abstract void automatic(Canvas c);

	// ********************************************

	// SETTERS AND GETTERS
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Icon getCurrentImage() {
		return imageList.get(currentImage);

	}

	public Boolean getHighlighted() {
		return isHighlighted;
	}

	public void setHighlighted(Boolean state) {
		isHighlighted = state;
	}
	

}