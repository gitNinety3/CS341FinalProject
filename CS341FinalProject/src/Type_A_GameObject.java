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
	
		// HEIGHT
		if (getDirection() == Direction.DOWN) {
			setY(getY() + getVelocity());
			if (getY() + iconHeight > c.getSize().getWidth()) {
				setY((int) (c.getSize().getWidth() - iconHeight));
				setDirection(Direction.UP);
			}
		} 
		else {
			setY(getY() - getVelocity());
			if (getY() < 0) {
				setY(0);
				setDirection(Direction.DOWN);
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
