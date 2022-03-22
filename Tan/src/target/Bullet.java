package target;

public class Bullet implements Runnable {
	
	public int x;
	
	public int y;
	
	public static final int SPEED = 20;
	
	public int direction;
	
	public boolean isAlive = true; //�ж��ӵ��߳��Ƿ�����...
	
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

	//�ӵ���Ϊ�߳�ʹ��...
	@Override
	public void run() {
		while(true) {
			switch(getDirection()) {
				case 1://����
					y -= SPEED;
					break;
				case 2://����
					y += SPEED;
					break;
				case 3://����
					x -= SPEED;
					break;
				case 4://����
					x += SPEED;
					break;
				default:
					break;
			}
			try {
				Thread.sleep(50);//�߳�����50ms...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�ӵ������꣺x=" + x +"��y=" + y);
			if(x > 800 || x < 0 || y < 0 || y > 800 || !isAlive) {
				isAlive = false;
				break;
			}
			
		}
		
	}
}
