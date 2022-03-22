package target;

public class Bullet implements Runnable {
	
	public int x;
	
	public int y;
	
	public static final int SPEED = 20;
	
	public int direction;
	
	public boolean isAlive = true; //判断子弹线程是否消亡...
	
	public Bullet(int x,int y,int direction) {
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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	//子弹作为线程使用...
	@Override
	public void run() {
		while(true) {
			switch(getDirection()) {
				case 1://向上
					y -= SPEED;
					break;
				case 2://向下
					y += SPEED;
					break;
				case 3://向左
					x -= SPEED;
					break;
				case 4://向右
					x += SPEED;
					break;
				default:
					break;
			}
			try {
				Thread.sleep(50);//线程休眠50ms...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子弹的坐标：x=" + x +"，y=" + y);
			if(x > 800 || x < 0 || y < 0 || y > 800 || !isAlive) {
				isAlive = false;
				break;
			}
			
		}
		
	}
}
