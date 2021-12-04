import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject_Implement extends GameObject {

	// CONSTRUCTOR
	public Type_B_GameObject_Implement(int x, int y) {
		super(x, y);
		setDirection(Direction.RIGHT);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("src/images/Type_B_Right.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Left.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Up.png"));
		imageList.add(new ImageIcon("src/images/Type_B_Down.png"));
		

	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconWidth = icon.getIconWidth();
		int iconHeight = icon.getIconHeight();
		
		if (getDirection() == Direction.RIGHT) {
			setX(getX() + getVelocity());
			if (getX() + iconWidth > c.getSize().getWidth()) {
				setX((int) (c.getSize().getWidth() - iconHeight));
				setDirection(Direction.DOWN);
			} 
		}
		else if (getDirection() == Direction.DOWN) {
			setY(getY() + getVelocity());
			if (getY() + iconHeight > c.getSize().getWidth()) {
				setY((int) (c.getSize().getWidth() - iconWidth));
				setDirection(Direction.LEFT);
			}
		}
		/*
		else if (getDirection() == Direction.LEFT) {
			setX(getX() + getVelocity());
			if (getX() + iconWidth > c.getSize().getWidth()) {
				setX((int) (c.getSize().getWidth() - iconHeight));
				setDirection(Direction.UP);
			}
		}
		
		else {
			setY(getY() - getVelocity());
			if (getY() < 0) {
				setY(0);
				setDirection(Direction.RIGHT);
			}
		}
		*/
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
		case Direction.UP:
			currentImage = 2;
			break;
		case Direction.DOWN:
			currentImage = 3;
			break;
		}
	}


}
