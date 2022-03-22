package target;

public class Bomb {
	private int x;
	private int y;
	private int life = 3;	//炸弹的生命周期
	boolean isAlive = true;
	
	public Bomb() {
		
	}
	
	public Bomb(int x,int y) {
		this.x = x;
		this.y = y;
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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	public int getLife() {
		return life;
	}

	public void bomb(){
        if(life > 0){
            life--;
        }else{
            isAlive = false;
        }
    }
}
