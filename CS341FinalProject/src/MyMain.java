
public class MyMain {

	public static void main(String[] args) {
		
		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		Type_A_GameObject A = new Type_A_GameObject(400, 200);
		A.setVelocity(5);
		canvas.addGameObject(A);
		canvas.addKeyListener(A);

		Type_B_GameObject_Implement B = new Type_B_GameObject_Implement(0, 0);
		B.setVelocity(5);
		canvas.addKeyListener(B);
		canvas.addGameObject(B);
	
		Type_C_GameObject C = new Type_C_GameObject(400, 400);
		C.setVelocity(5);
		canvas.addKeyListener(C);
		canvas.addGameObject(C);
		
		// TASK 2: ADD A USER GAME OBJECT
		Type_D_GameObject D = new Type_D_GameObject(400, 500);
		D.setVelocity(5);
		canvas.addKeyListener(D);
		canvas.addGameObject(D);
	}
}
