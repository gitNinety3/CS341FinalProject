
public abstract class Type_B_GameObject_Adapter  extends GameObject {
	
	GameObject gObject;
	
	public Type_B_GameObject_Adapter (GameObject gObject) {
		
		super(gObject.getX(), gObject.getY());
	}
	
	public abstract void move (Canvas c);
	
}
