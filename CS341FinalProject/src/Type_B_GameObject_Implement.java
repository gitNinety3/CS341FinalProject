import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject_Implement extends Type_B_GameObject_Adapter implements  KeyListener {

	GameObject gameObject;

	// CONSTRUCTOR
	public Type_B_GameObject_Implement(GameObject gameObject) {
		super(gameObject);
		gObject = gameObject;
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("src/images/ballRed.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Up.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Left.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Down.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Right.png"));

	}

	// THIS METHOD ALLOWS THE OBJECT TO MOVE ONLY WITH USER CONTROLL
	public void move(Canvas c) {

		Icon icon = getCurrentImage();

		int iconWidth = icon.getIconWidth();
		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

		if (getHighlighted()) {
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
				}
				break;
			case Direction.LEFT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.RIGHT);
				}
				break;
			case Direction.RIGHT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.LEFT);
				}
				break;
			default:
				break;
			}
		} else {
			if (getDirection() == Direction.RIGHT) {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > c.getSize().getWidth()) {
					setX((int) (c.getSize().getWidth() - iconWidth));
					setDirection(Direction.DOWN);
				}
			} else if (getDirection() == Direction.DOWN) {
				setY(getY() + getVelocity());
				if (getY() + iconHeight > c.getSize().getWidth()) {
					setY((int) (c.getSize().getWidth() - iconHeight));
					setDirection(Direction.LEFT);
				}
			} else if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.UP);
				}
			} else {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.RIGHT);
				}
			}
		}
	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.UP:
			currentImage = 1;
			break;
		case Direction.LEFT:
			currentImage = 2;
			break;
		case Direction.DOWN:
			currentImage = 3;
			break;
		case Direction.RIGHT:
			currentImage = 4;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		if (getHighlighted()) {
			if (e.getKeyCode() != KeyEvent.VK_TAB) {
				setDirection(Direction.NONE);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (getHighlighted()) {
			if (e.getKeyCode() == KeyEvent.VK_TAB) {
				setDirection(Direction.NONE);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}
	}
}
