import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject {
	
	public Type_A_GameObject(int x, int y) {
		super(x, y); 
		setDirection(Direction.UP);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("src/images/Type_A_Up.png"));
		imageList.add(new ImageIcon("src/images/Type_A_Down.png"));

	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconHeight = icon.getIconHeight();
		//int iconWidth = icon.getIconWidth();
	
		// HEIGHT
		if (getDirection() == Direction.UP) {
			setX(getX() + getVelocity());
			if (getX() + iconHeight > c.getSize().getWidth()) {
				setX((int) (c.getSize().getHeight() - iconHeight));
				setDirection(Direction.DOWN);
			}
		} 
		else {
			setX(getX() - getVelocity());
			if (getX() < 0) {
				setX(0);
				setDirection(Direction.UP);
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
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		}
	}


}
