package target;

import java.util.Vector;

public class Tank {
	public int x;
	public int y;
	public int direction;
	//单独的子弹对象...
	public Bullet bullet = null;
	//子弹集合...
	public Vector<Bullet> bullets = new Vector<>(); //将子弹保存到Vector集合内
	public boolean isAlive = true;//坦克是否存活
	public static final int SPEED = 3;
	
	public Tank() {
		
	}
	
	public Tank(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDirection() {
		return direction;
	}
	

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	//坦克的移动操作：
	public void moveUp() {
		direction = 1;
		y-=SPEED;
	}
	public void moveDown() {
		direction = 2;
		y+=SPEED;
	}
	public void moveLeft() {
		direction = 3;
		x-=SPEED;
	}
	public void moveRight() {
		direction = 4;
		x+=SPEED;
	}
	
	public void shoot() {
		//当玩家按下J或者1键时，进行就发触发shoot()方法，发射子弹。。。
		switch(getDirection()) {
			case 1:
				bullet = new Bullet(x + 22, y - 10 , 1);
				bullets.add(bullet);
				break;
			case 2:
				bullet = new Bullet(x + 22, y + 60, 2);
				bullets.add(bullet);
				break;
			case 3:
				bullet = new Bullet(x - 10 , y + 22, 3);
				bullets.add(bullet);
				break;
			case 4:
				bullet = new Bullet(x + 60, y + 22, 4);
				bullets.add(bullet);
				break;
			default:
				break;
		}
		new Thread(bullet).start();
	}
}
