package target;

public class Player extends Tank implements Runnable{
	
	public Player(int x, int y, int direction) {
		super(x, y, direction);
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!isAlive){
				System.out.println("Íæ¼Ò±»»÷±ÐÁË£¡");
				break;
			}
		}
	}
}