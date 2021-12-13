import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.LEFT);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("src/images/Type_C_Right.png"));
		imageList.add(new ImageIcon("src/images/Type_C_Left.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Up.png"));

	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();
		
		if (getHighlighted()) {
			switch (getDirection()) {
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
					setDirection(Direction.RIGHT);
				}
				break;
				
			default:
				break;
			}
		}
		else {
			if (getDirection() == Direction.LEFT) {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > c.getSize().getWidth()) {
					setX((int) (c.getSize().getWidth() - iconWidth));
					setDirection(Direction.RIGHT);
				}
			} 
			else {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.LEFT);
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
		case Direction.RIGHT:
			currentImage = 0;
			break;
		case Direction.LEFT:
			currentImage = 1;
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		if (getHighlighted() == true) {
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
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}
	}
	
	public void highlight (Component c, Graphics g) {
		Icon icon = imageList.get(currentImage);
		int height = icon.getIconHeight();
		int width = icon.getIconWidth();
		
		g.setColor(Color.red);
		g.draw3DRect(getX(), getY(), width, height, true);
	}

}
