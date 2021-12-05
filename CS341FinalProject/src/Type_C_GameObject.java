import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject {
	
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.LEFT);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("src/images/Type_C_Right.png"));
		imageList.add(new ImageIcon("src/images/Type_C_Left.png"));

	}

	public void move(Canvas c) {
		
		Icon icon = getCurrentImage();
		int iconWidth = icon.getIconWidth();
		
		// WIDTH 
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


}
