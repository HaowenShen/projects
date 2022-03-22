package target;
/*
  将敌人信息，恢复成Node对象=>Vector
 通过Node的Vector去恢复敌人坦克的位置和方向
 * */
public class Node {
	private int x;
	private int y;
	private int direction;
	
	public Node(int x,int y,int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
}
