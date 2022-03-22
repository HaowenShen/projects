package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JPanel;

import target.AePlayWave;
import target.Bomb;
import target.Bullet;
import target.Enemy;
import target.Node;
import target.Player;
import target.Recorder;
import target.Tank;

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements KeyListener,Runnable {
	int x = 100;
	int y = 300;
	int direction = 1;
	//��Ҷ���...
	Player player = null;
	//ը������
	Vector<Bomb> bombs = new Vector<>();
	//Node���󼯺ϣ��������Ͼ���Ϸ������λ����Ϣ
	Vector<Node> nodes = null;
	//���˼���
	Vector<Enemy> enemies = new Vector<Enemy>();
	public MyPanel(int opt) throws IOException {
		//��ʼ��Node���󼯺�
		player = new Player(x, y, direction);
		//����ļ���src\\myRecorder.txt���������ȡ�Ͼ���Ϸ������ļ������ڡ�
		File file = new File(Recorder.recordPath);
		if(!file.exists()) {
			System.out.println("�ļ�������ֻ�ܿ�������Ϸ");
			opt=1;
		}
		switch(opt) {
			case 1:
				for(int i=0;i<5;i++) {
					Enemy enemy=new Enemy(x+100*i,y-150,2);
					enemy.setPlayer(player);
					enemy.setEnemies(enemies);
					enemies.add(enemy);
					new Thread(enemy).start();
				}
				break;
			
			case 2:
				nodes=Recorder.getNodesAndEnemyTankRec();
				for(int i=0;i<nodes.size();i++) {
					Node node = nodes.get(i);
					//����һ������̹��
					Enemy enemy = new Enemy(node.getX(),node.getY(),node.getDirection());
					enemy.setPlayer(player);
					enemy.setEnemies(enemies);
					enemies.add(enemy);
					new Thread(enemy).start();
				}
				break;
			default:
				System.out.println("�������");
				break;
		}
		/*������MyPanel�ĵ��˼������ø�Recorder��...*/
		Recorder.setEnemies(enemies);
		bombs.add(new Bomb(0,0));
	}
	
	//������ҵ÷���Ϣ��
	public void drawInfo(Graphics g) {
		//������ҵ��ܳɼ�
        g.setColor(Color.black);
        Font font = new Font("����",Font.BOLD,25);
        g.setFont(font);
        g.drawString("����̹����",1000,30);
        drawTank(g,4,900,120,1);    //����һ���з�̹��
        g.setColor(Color.BLACK);            //������Ҫ�������óɺ�ɫ����Ȼ�ᱣ����ɫ
        g.drawString(Recorder.getScore() + "",1080,100);
        
	}
	
	//���Ʒ���...
	@Override
	public void paint(Graphics g) {
		drawInfo(g);
		g.fill3DRect(0, 0, 800, 800, false);
		if(player.isAlive()) {
			drawTank(g,1,player.getX(),player.getY(),player.getDirection());
		}
		//�����˴Ӽ�����ȡ������������Ƴ���...
		for(int i=0;i<enemies.size();i++) {
			Enemy enemy = enemies.get(i);
			enemy.setEnemies(enemies);
			if(enemy.isAlive()) {
				drawTank(g,4,enemy.getX(),enemy.getY(),enemy.getDirection());
			}
		}
		
		//�����ӵ�
		for(int i=0;i<player.bullets.size();i++){
			Bullet pbullet = player.bullets.get(i);
			//����ӵ��̻߳�û���������ͻ����ӵ�...
			if(pbullet.isAlive()) {
				g.setColor(Color.RED);
				g.draw3DRect(pbullet.getX(), pbullet.getY(), 2, 2, false);
				g.fill3DRect(pbullet.getX(), pbullet.getY(), 2, 2, false);
			}
		}
		
		//���Ʊ�ըЧ��...
		for(int i=0; i<bombs.size(); i++) {
			Bomb bomb = bombs.get(i);
			switch(bomb.getLife()) {
				case 1:
					g.drawImage(Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb1.png")), bomb.getX(), bomb.getY(), 80, 80,this);
					break;
				case 2:
					g.drawImage(Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb2.png")), bomb.getX(), bomb.getY(), 80, 80,this);
					break;
				case 3:
					g.drawImage(Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb3.png")), bomb.getX(), bomb.getY(), 80, 80,this);
					break;
				default:
					break;
			}
			bomb.bomb();
		}
		
	}
	
	
	
	//��һ��е��˵���Ϊ...
	public void hitEnemy() {
		for(int i=0;i<player.bullets.size();i++) {
			Bullet bullet = player.bullets.get(i);
			if(bullet != null && bullet.isAlive()) {
				for(int j=0;j<enemies.size();j++) {
				Enemy enemy = enemies.get(j);
					destroyEnemy(bullet,enemy);
				}
			}else {
				player.bullets.remove(i);
				new AePlayWave("resource\\blast.wav").start();
			}
		}
	}
	
	//��һ��е��˵���Ϊ...
		public void hitPlayer() {
			for(int i=0;i<enemies.size();i++) {
				Enemy enemy = enemies.get(i);
				for(int j=0;j<enemy.bullets.size();i++) {
					Bullet bullet = enemy.bullets.get(i);
					if(bullet != null && bullet.isAlive()) {
						destroyPlayer(bullet,player);
					}else {
						enemy.bullets.remove(i);
					}
				}
			}
		}
	
	//�ݻٵз�̹��...
	public void destroyEnemy(Bullet bullet,Enemy enemy) {
		switch(enemy.getDirection()) {
			case 1:
			case 2:
				if(bullet.getX()>=enemy.getX() && bullet.getX()<=enemy.getX()+45 && bullet.getY()>=enemy.getY() && bullet.getY()<=enemy.getY()+50) {
					bullet.setAlive(false);
					enemy.setAlive(false);
					enemies.remove(enemy);
					//����̹�˼�һ��
					if(enemy instanceof Enemy) {
						Recorder.addScore();
					}
					bombs.add(new Bomb(enemy.getX(),enemy.getY()));
				}
				break;
			case 3:
			case 4:
				if(bullet.getX()>=enemy.getX() && bullet.getX()<=enemy.getX()+50 && bullet.getY()>=enemy.getY() && bullet.getY() <= enemy.getY()+45){
					bullet.setAlive(false);
					enemy.setAlive(false);
					enemies.remove(enemy);
					//����̹�˼�һ��
					if(enemy instanceof Enemy) {
						Recorder.addScore();
					}
					bombs.add(new Bomb(enemy.getX(),enemy.getY()));
				}
				break;
			default:
					break;
		}
		
	}
	
	//�ݻ����...
		public void destroyPlayer(Bullet bullet,Tank player) {
			switch(player.getDirection()) {
				case 1:
				case 2:
					if(bullet.getX()>=player.getX() && bullet.getX()<=player.getX()+45 && bullet.getY()>=player.getY() && bullet.getY()<=player.getY()+50) {
						bullet.setAlive(false);
						player.setAlive(false);
						bombs.add(new Bomb(player.getX(),player.getY()));
					}
					break;
				case 3:
				case 4:
					if(bullet.getX()>=player.getX() && bullet.getX()<=player.getX()+50 && bullet.getY()>=player.getY() && bullet.getY() <= player.getY()+45){
						bullet.setAlive(false);
						player.setAlive(false);
						bombs.add(new Bomb(player.getX(),player.getY()));
					}
					break;
				default:
						break;
			}
		}
	
	//����̹�˺���
	public void drawTank(Graphics g,int color,int x,int y,int direction) {
		//����̹�˵���ɫ
		switch(color) {
			case 1:
				g.setColor(Color.ORANGE);
				break;
			case 2:
				g.setColor(Color.MAGENTA);
				break;
			case 3:
				g.setColor(Color.YELLOW);
				break;
			case 4:
				g.setColor(Color.GREEN);
				break;
			case 5:
				g.setColor(Color.DARK_GRAY);
				break;
			default:
					break;
		}
		
		//ȷ��̹�˵ķ���
		switch(direction){
			case 1://����
				g.draw3DRect(x, y, 10, 50, false);//���Ĵ�
				g.fill3DRect(x, y, 10, 50, false);
				g.draw3DRect(x+10, y+10, 25, 30, false);//����
				g.fill3DRect(x+10, y+10, 25, 30, false);
				g.draw3DRect(x+35, y, 10, 50, false);//���Ĵ�
				g.fill3DRect(x+35, y, 10, 50, false);
				g.draw3DRect(x+20, y-10, 5, 32, false);//�ڹ�
				g.fill3DRect(x+20, y-10, 5, 32, false);
				g.draw3DRect(x+15, y+10, 15, 15, false);//��̨
				g.fill3DRect(x+15, y+10, 15, 15, false);
				break;
			case 2://����
				g.draw3DRect(x, y, 10, 50, false);//���Ĵ�
				g.fill3DRect(x, y, 10, 50, false);
				g.draw3DRect(x+10, y+10, 25, 30, false);//����
				g.fill3DRect(x+10, y+10, 25, 30, false);
				g.draw3DRect(x+35, y, 10, 50, false);//���Ĵ�
				g.fill3DRect(x+35, y, 10, 50, false);
				g.draw3DRect(x+20, y+28, 5, 32, false);//�ڹ�
				g.fill3DRect(x+20, y+28, 5, 32, false);
				g.draw3DRect(x+15, y+25, 15, 15, false);//��̨
				g.fill3DRect(x+15, y+25, 15, 15, false);
				break;
			case 3://����
				g.draw3DRect(x, y, 50, 10, false);
				g.fill3DRect(x, y, 50, 10, false);
				g.draw3DRect(x+10, y+10, 30, 25, false);
				g.fill3DRect(x+10, y+10, 30, 25, false);
				g.draw3DRect(x, y+35, 50, 10, false);
				g.fill3DRect(x, y+35, 50, 10, false);
				g.draw3DRect(x-10, y+20, 32, 5, false);
				g.fill3DRect(x-10, y+20, 32, 5, false);
				g.draw3DRect(x+10, y+15, 15, 15, false);
				g.fill3DRect(x+10, y+15, 15, 15, false);
				break;
			case 4://����
				g.draw3DRect(x, y, 50, 10, false);
				g.fill3DRect(x, y, 50, 10, false);
				g.draw3DRect(x+10, y+10, 30, 25, false);
				g.fill3DRect(x+10, y+10, 30, 25, false);
				g.draw3DRect(x, y+35, 50, 10, false);
				g.fill3DRect(x, y+35, 50, 10, false);
				g.draw3DRect(x+28, y+20, 32, 5, false);
				g.fill3DRect(x+28, y+20, 32, 5, false);
				g.draw3DRect(x+25, y+15, 15, 15, false);
				g.fill3DRect(x+25, y+15, 15, 15, false);
				break;
			default:
				break;
					
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				if(player.getY()-10 > 0) {
					player.moveUp();
				}
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				if(player.getY()+60 < 800) {
					player.moveDown();
				}
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				if(player.getX()-10>0) {
					player.moveLeft();
				}
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				if(player.getX()+60 < 800 ) {
					player.moveRight();
				}
				break;
			case KeyEvent.VK_NUMPAD1:
			case KeyEvent.VK_J:
				if(player.bullets.size()<=3) {
					player.shoot();
				}
				break;
			default:
				break;
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	//���û���Ϊ�̣߳���������50���룬ÿ50�����ػ�һ��...
	@Override
	public void run(){
		new AePlayWave("resource\\start.wav").start();//�����̣߳���������....
		while(true) {
			this.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hitPlayer();//���˻�����ҵ���Ϊ...
			hitEnemy();//��һ��е��˵���Ϊ...
		}
	}	
}