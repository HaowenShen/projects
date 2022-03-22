package target;

import java.util.Vector;

public class Enemy extends Tank implements Runnable {
	
	Bullet bullet = null;
	
	public Vector<Bullet> bullets = new Vector<>();
	
	public Vector<Enemy> enemies = new Vector<>();
	
	public Player player;
	
	public Enemy() {
		super();
	}
	
	
	public Enemy(int x, int y, int direction) {
		super(x, y, direction);
	}
	//这里提供一个方法，将MyPanel内的成员Vector<Enemy>,添加到
	public void setEnemies(Vector<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	//判断敌人坦克和玩家是否相撞
	public boolean isTouchPlayer(){
		switch(this.getDirection()) {
		case 1:
			switch(player.getDirection()) {
						case 1:
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()-10>=player.getY()-10 &&
							this.getY()-10<=player.getY()+50) {
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+45 &&
							this.getY()-10>=player.getY()-10 &&
							this.getY()-10<=player.getY()+50) {
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()+50>=player.getY()-10 &&
							this.getY()+50<=player.getY()+50) {
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+45 &&
							this.getY()+50>=player.getY()-10 &&
							this.getY()+50<=player.getY()+50) {
								return true;
							}
							break;
						case 2:
							//左上角位置
							/*
							 this[this.getX(),this.getY()]
							 enemy[enemy.getX(),enemy.getY()]
							 this[this.getX()+45,enemy.getY()]
							 enemy[enemy.getX()+45,enemy.getY()] 
							 * */
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()-10>=player.getY() &&
							this.getY()-10<=player.getY()+60 ){
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+45 &&
							this.getY()-10>=player.getY() &&
							this.getY()-10<=player.getY()+60) {
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()+50>=player.getY() &&
							this.getY()+50<=player.getY()+60) {
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+45 &&
							this.getY()+50>=player.getY() &&
							this.getY()+50<=player.getY()+60) {
								return true;
							}
			break;
			case 3:
			if(
			this.getX()>=player.getX()-10 && 
			this.getX()<=player.getX()+50 && 
			this.getY()>=player.getY() && 
			this.getY()<=player.getY()+45){
				return true;
			}
			if(
			this.getX()+45>=player.getX()-10 &&
			this.getX()+45<=player.getX()+50 &&
			this.getY()>=player.getY() &&
			this.getY()<=player.getY()+45){
				return true;
			}
			if(
			this.getX()>=player.getX()-10 &&
			this.getX()<=player.getX()+50 &&
			this.getY()+50>=player.getY() &&
			this.getY()+50<=player.getY()+45){
				return true;
			}
			if(
			this.getX()+45>=player.getX()-10 &&
			this.getX()+45<=player.getX()+50 &&
			this.getY()+50>=player.getY() &&
			this.getY()+50<=player.getY()+45) {
				return true;
			}
			break;
			case 4:
			if(
			this.getX()>=player.getX() && 
			this.getX()<=player.getX()+60 && 
			this.getY()>=player.getY() && 
			this.getY()<=player.getY()+45){
				return true;
			}
			if(
			this.getX()+45>=player.getX() &&
			this.getX()+45<=player.getX()+60 &&
			this.getY()>=player.getY() &&
			this.getY()<=player.getY()+45){
				return true;
			}
			if(
			this.getX()>=player.getX() &&
			this.getX()<=player.getX()+60 &&
			this.getY()+50>=player.getY() &&
			this.getY()+50<=player.getY()+45){
				return true;
			}
			if(
			this.getX()+45>=player.getX() &&
			this.getX()+45<=player.getX()+60 &&
			this.getY()+50>=player.getY() &&
			this.getY()+50<=player.getY()+45) {
				return true;
			}
				break;
			default:
				break;
			}
			break;
		case 2:
			switch(player.getDirection()) {
				case 1:
					if(
					this.getX()>=player.getX() &&
					this.getX()<=player.getX()+45 &&
					this.getY()>=player.getY()-10 &&
					this.getY()<=player.getY()+50){
						return true;
					}
					if(
					this.getX()+45>=player.getX() &&
					this.getX()+45<=player.getX()+45 &&
					this.getY()>=player.getY()-10 &&
					this.getY()<=player.getY()+60) {
						return true;
					}
					if(
					this.getX()>=player.getX() &&
					this.getX()<=player.getX()+45 &&
					this.getY()+60>=player.getY()-10 &&
					this.getY()+60<=player.getY()+50) {
						return true;
					}
					if(
					this.getX()+45>=player.getX() &&
					this.getX()+45<=player.getX()+45 &&
					this.getY()+60>=player.getY()-10 &&
					this.getY()+60<=player.getY()+50) {
						return true;
					}
					break;
				case 2:
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+60){
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+45 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+60) {
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()+60>=player.getY() &&
							this.getY()+60<=player.getY()+60) {
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+45 &&
							this.getY()+60>=player.getY() &&
							this.getY()+60<=player.getY()+60) {
								return true;
							}
							break;
						case 3:
							if(
							this.getX() >= player.getX()-10 && 
							this.getX() <= player.getX()+50 && 
							this.getY() >= player.getY() && 
							this.getY() <= player.getY()+45){
								return true;
							}
							if(
							this.getX()+45>=player.getX()-10 &&
							this.getX()+45<=player.getX()+50 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+45){
								return true;
							}
							if(
							this.getX()>=player.getX()-10 &&
							this.getX()<=player.getX()+50 &&
							this.getY()+60>=player.getY() &&
							this.getY()+60<=player.getY()+45){
								return true;
							}
							if(
							this.getX()+45>=player.getX()-10 &&
							this.getX()+45<=player.getX()+50 &&
							this.getY()+60>=player.getY() &&
							this.getY()+60<=player.getY()+45){
								return true;
							}
							break;
						case 4:
							if(
							this.getX() >= player.getX() && 
							this.getX() <= player.getX()+60 && 
							this.getY() >= player.getY() && 
							this.getY() <= player.getY()+45){
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+60 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+45){
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+60 &&
							this.getY()+60>=player.getY() &&
							this.getY()+60<=player.getY()+45){
								return true;
							}
							if(
							this.getX()+45>=player.getX() &&
							this.getX()+45<=player.getX()+60 &&
							this.getY()+60>=player.getY() &&
							this.getY()+60<=player.getY()+45){
								return true;
							}
							break;
						default:
							break;
					}
			break;
		case 3:
			switch(player.getDirection()) {
						case 1:
							if(
							this.getX()-10>=player.getX() &&
							this.getX()-10<=player.getX()+45 && 
							this.getY()>=player.getY()-10 && 
							this.getY()<=player.getY()+50){
								return true;
							}
							if(
							this.getX()+50>=player.getX() &&
							this.getX()+50<=player.getX()+45 &&
							this.getY()>=player.getY()-10 &&
							this.getY()<=player.getY()+50){
								return true;
							}
							if(
							this.getX()-10>=player.getX() &&
							this.getX()-10<=player.getX()+45 &&
							this.getY()+45>=player.getY()-10 &&
							this.getY()+45<=player.getY()+50) {
								return true;
							}
							if(
							this.getX()+50>=player.getX() &&
							this.getX()+50<=player.getX()+45 &&
							this.getY()+45>=player.getY()-10 &&
							this.getY()+45<=player.getY()+50){
								return true;
							}
							break;
						case 2:
							if(
							this.getX()-10>=player.getX() && 
							this.getX()-10<=player.getX()+45 && 
							this.getY()>=player.getY() && 
							this.getY()<=player.getY()+60){
								return true;
							}
							if(
							this.getX()+50>=player.getX() &&
							this.getX()+50<=player.getX()+45 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+60){
								return true;
							}
							if(
							this.getX()-10>=player.getX() &&
							this.getX()-10<=player.getX()+45 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+60) {
								return true;
							}
							if(
							this.getX()+50>=player.getX() &&
							this.getX()+50<=player.getX()+45 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+60) {
								return true;
							}
							break;
						case 3:
							if(
							this.getX()-10>=player.getX()-10 && 
							this.getX()-10<=player.getX()+50 && 
							this.getY()>=player.getY() && 
							this.getY()<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()+50>=player.getX()-10 &&
							this.getX()+50<=player.getX()+50 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()-10>=player.getX()-10 &&
							this.getX()-10<=player.getX()+50 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()+50>=player.getX()-10 &&
							this.getX()+50<=player.getX()+50 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							break;
						case 4:
							if(
							this.getX()-10>=player.getX() && 
							this.getX()-10<=player.getX()+60 &&  
							this.getY()>=player.getY() && 
							this.getY()<=player.getY()+45){
								return true;
							}
							if(
							this.getX()+50>=player.getX() &&
							this.getX()+50<=player.getX()+60 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()-10>=player.getX() &&
							this.getX()-10<=player.getX()+60 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()+50>=player.getX() &&
							this.getX()+50<=player.getX()+60 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							break;
						default:
							break;
					}
			break;
		case 4:
			
					switch(player.getDirection()) {
						case 1:
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 && 
							this.getY()>=player.getY()-10 && 
							this.getY()<=player.getY()+50){
								return true;
							}
							if(
							this.getX()+60>=player.getX() &&
							this.getX()+60<=player.getX()+45 &&
							this.getY()>=player.getY()-10 &&
							this.getY()<=player.getY()+50){
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()+45>=player.getY()-10 &&
							this.getY()+45<=player.getY()+50) {
								return true;
							}
							if(
							this.getX()+60>=player.getX() &&
							this.getX()+60<=player.getX()+45 &&
							this.getY()+45>=player.getY()-10 &&
							this.getY()+45<=player.getY()+50){
								return true;
							}
							break;
						case 2:
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 && 
							this.getY()>=player.getY() && 
							this.getY()<=player.getY()+60){
								return true;
							}
							if(
							this.getX()+60>=player.getX() &&
							this.getX()+60<=player.getX()+45 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+60){
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+45 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+60) {
								return true;
							}
							if(
							this.getX()+60>=player.getX() &&
							this.getX()+60<=player.getX()+45 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+60){
								return true;
							}
							break;
						case 3:
							if(
							this.getX()>=player.getX()-10 && 
							this.getX()<=player.getX()+50 &&  
							this.getY()>=player.getY() && 
							this.getY()<=player.getY()+45){
								return true;
							}
							if(
							this.getX()+60>=player.getX()-10 &&
							this.getX()+60<=player.getX()+50 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()>=player.getX()-10 &&
							this.getX()<=player.getX()+50 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()+60>=player.getX()-10 &&
							this.getX()+60<=player.getX()+50 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							break;
						case 4:
							if(
							this.getX()>=player.getX() && 
							this.getX()<=player.getX()+60 &&  
							this.getY()>=player.getY() && 
							this.getY()<=player.getY()+45){
								return true;
							}
							if(
							this.getX()+60>=player.getX() &&
							this.getX()+60<=player.getX()+60 &&
							this.getY()>=player.getY() &&
							this.getY()<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()>=player.getX() &&
							this.getX()<=player.getX()+60 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							if(
							this.getX()+60>=player.getX() &&
							this.getX()+60<=player.getX()+60 &&
							this.getY()+45>=player.getY() &&
							this.getY()+45<=player.getY()+45) {
								return true;
							}
							break;
						default:
							break;
					}
			break;
		default:
			break;
		}
		return false;
	}
	
	//判断敌人坦克之间是否相撞
	public boolean isTouchEnemy() {
		switch(this.getDirection()) {
			case 1:
				for(int i=0;i<enemies.size();i++) {
					Enemy enemy = enemies.get(i);
					if(enemy != this) {//如果敌人坦克不是当前敌人坦克
						switch(enemy.getDirection()) {
							case 1:
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()-10>=enemy.getY()-10 &&
								this.getY()-10<=enemy.getY()+50) {
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+45 &&
								this.getY()-10>=enemy.getY()-10 &&
								this.getY()-10<=enemy.getY()+50) {
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()+50>=enemy.getY()-10 &&
								this.getY()+50<=enemy.getY()+50) {
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+45 &&
								this.getY()+50>=enemy.getY()-10 &&
								this.getY()+50<=enemy.getY()+50) {
									return true;
								}
								break;
							case 2:
								//左上角位置
								/*
								 this[this.getX(),this.getY()]
								 enemy[enemy.getX(),enemy.getY()]
								 this[this.getX()+45,enemy.getY()]
								 enemy[enemy.getX()+45,enemy.getY()] 
								 * */
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()-10>=enemy.getY() &&
								this.getY()-10<=enemy.getY()+60 ){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+45 &&
								this.getY()-10>=enemy.getY() &&
								this.getY()-10<=enemy.getY()+60) {
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()+50>=enemy.getY() &&
								this.getY()+50<=enemy.getY()+60) {
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+45 &&
								this.getY()+50>=enemy.getY() &&
								this.getY()+50<=enemy.getY()+60) {
									return true;
								}
								break;
							case 3:
								if(
								this.getX()>=enemy.getX()-10 && 
								this.getX()<=enemy.getX()+50 && 
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX()-10 &&
								this.getX()+45<=enemy.getX()+50 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()>=enemy.getX()-10 &&
								this.getX()<=enemy.getX()+50 &&
								this.getY()+50>=enemy.getY() &&
								this.getY()+50<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX()-10 &&
								this.getX()+45<=enemy.getX()+50 &&
								this.getY()+50>=enemy.getY() &&
								this.getY()+50<=enemy.getY()+45) {
									return true;
								}
								break;
							case 4:
								if(
								this.getX()>=enemy.getX() && 
								this.getX()<=enemy.getX()+60 && 
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+60 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+60 &&
								this.getY()+50>=enemy.getY() &&
								this.getY()+50<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+60 &&
								this.getY()+50>=enemy.getY() &&
								this.getY()+50<=enemy.getY()+45) {
									return true;
								}
								break;
							default:
								break;
						}
					}
				}
				break;
			case 2:
				for(int i=0;i<enemies.size();i++) {
					Enemy enemy = enemies.get(i);
					if(enemy != this) {//如果敌人坦克不是当前敌人坦克
						switch(enemy.getDirection()) {
							case 1:
								if(
									this.getX()>=enemy.getX() &&
									this.getX()<=enemy.getX()+45 &&
									this.getY()>=enemy.getY()-10 &&
									this.getY()<=enemy.getY()+50){
										return true;
									}
									if(
									this.getX()+45>=enemy.getX() &&
									this.getX()+45<=enemy.getX()+45 &&
									this.getY()>=enemy.getY()-10 &&
									this.getY()<=enemy.getY()+60) {
										return true;
									}
									if(
									this.getX()>=enemy.getX() &&
									this.getX()<=enemy.getX()+45 &&
									this.getY()+60>=enemy.getY()-10 &&
									this.getY()+60<=enemy.getY()+50) {
										return true;
									}
									if(
									this.getX()+45>=enemy.getX() &&
									this.getX()+45<=enemy.getX()+45 &&
									this.getY()+60>=enemy.getY()-10 &&
									this.getY()+60<=enemy.getY()+50) {
										return true;
									}
									break;
							case 2:
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+60){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+45 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+60) {
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()+60>=enemy.getY() &&
								this.getY()+60<=enemy.getY()+60) {
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+45 &&
								this.getY()+60>=enemy.getY() &&
								this.getY()+60<=enemy.getY()+60) {
									return true;
								}
								break;
							case 3:
								if(
								this.getX() >= enemy.getX()-10 && 
								this.getX() <= enemy.getX()+50 && 
								this.getY() >= enemy.getY() && 
								this.getY() <= enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX()-10 &&
								this.getX()+45<=enemy.getX()+50 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()>=enemy.getX()-10 &&
								this.getX()<=enemy.getX()+50 &&
								this.getY()+60>=enemy.getY() &&
								this.getY()+60<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX()-10 &&
								this.getX()+45<=enemy.getX()+50 &&
								this.getY()+60>=enemy.getY() &&
								this.getY()+60<=enemy.getY()+45){
									return true;
								}
								break;
							case 4:
								if(
								this.getX() >= enemy.getX() && 
								this.getX() <= enemy.getX()+60 && 
								this.getY() >= enemy.getY() && 
								this.getY() <= enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+60 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+60 &&
								this.getY()+60>=enemy.getY() &&
								this.getY()+60<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+45>=enemy.getX() &&
								this.getX()+45<=enemy.getX()+60 &&
								this.getY()+60>=enemy.getY() &&
								this.getY()+60<=enemy.getY()+45){
									return true;
								}
								break;
							default:
								break;
						}
					}
				}
				break;
			case 3:
				for(int i=0;i<enemies.size();i++) {
					Enemy enemy = enemies.get(i);
					if(enemy != this) {//如果敌人坦克不是当前敌人坦克
						switch(enemy.getDirection()) {
							case 1:
								if(
								this.getX()-10>=enemy.getX() &&
								this.getX()-10<=enemy.getX()+45 && 
								this.getY()>=enemy.getY()-10 && 
								this.getY()<=enemy.getY()+50){
									return true;
								}
								if(
								this.getX()+50>=enemy.getX() &&
								this.getX()+50<=enemy.getX()+45 &&
								this.getY()>=enemy.getY()-10 &&
								this.getY()<=enemy.getY()+50){
									return true;
								}
								if(
								this.getX()-10>=enemy.getX() &&
								this.getX()-10<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY()-10 &&
								this.getY()+45<=enemy.getY()+50) {
									return true;
								}
								if(
								this.getX()+50>=enemy.getX() &&
								this.getX()+50<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY()-10 &&
								this.getY()+45<=enemy.getY()+50){
									return true;
								}
								break;
							case 2:
								if(
								this.getX()-10>=enemy.getX() && 
								this.getX()-10<=enemy.getX()+45 && 
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+60){
									return true;
								}
								if(
								this.getX()+50>=enemy.getX() &&
								this.getX()+50<=enemy.getX()+45 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+60){
									return true;
								}
								if(
								this.getX()-10>=enemy.getX() &&
								this.getX()-10<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+60) {
									return true;
								}
								if(
								this.getX()+50>=enemy.getX() &&
								this.getX()+50<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+60) {
									return true;
								}
								break;
							case 3:
								if(
								this.getX()-10>=enemy.getX()-10 && 
								this.getX()-10<=enemy.getX()+50 && 
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()+50>=enemy.getX()-10 &&
								this.getX()+50<=enemy.getX()+50 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()-10>=enemy.getX()-10 &&
								this.getX()-10<=enemy.getX()+50 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()+50>=enemy.getX()-10 &&
								this.getX()+50<=enemy.getX()+50 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								break;
							case 4:
								if(
								this.getX()-10>=enemy.getX() && 
								this.getX()-10<=enemy.getX()+60 &&  
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+50>=enemy.getX() &&
								this.getX()+50<=enemy.getX()+60 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()-10>=enemy.getX() &&
								this.getX()-10<=enemy.getX()+60 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()+50>=enemy.getX() &&
								this.getX()+50<=enemy.getX()+60 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								break;
							default:
								break;
						}
					}
				}
				break;
			case 4:
				for(int i=0;i<enemies.size();i++) {
					Enemy enemy = enemies.get(i);
					if(enemy != this) {//如果敌人坦克不是当前敌人坦克
						switch(enemy.getDirection()) {
							case 1:
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 && 
								this.getY()>=enemy.getY()-10 && 
								this.getY()<=enemy.getY()+50){
									return true;
								}
								if(
								this.getX()+60>=enemy.getX() &&
								this.getX()+60<=enemy.getX()+45 &&
								this.getY()>=enemy.getY()-10 &&
								this.getY()<=enemy.getY()+50){
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY()-10 &&
								this.getY()+45<=enemy.getY()+50) {
									return true;
								}
								if(
								this.getX()+60>=enemy.getX() &&
								this.getX()+60<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY()-10 &&
								this.getY()+45<=enemy.getY()+50){
									return true;
								}
								break;
							case 2:
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 && 
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+60){
									return true;
								}
								if(
								this.getX()+60>=enemy.getX() &&
								this.getX()+60<=enemy.getX()+45 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+60){
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+60) {
									return true;
								}
								if(
								this.getX()+60>=enemy.getX() &&
								this.getX()+60<=enemy.getX()+45 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+60){
									return true;
								}
								break;
							case 3:
								if(
								this.getX()>=enemy.getX()-10 && 
								this.getX()<=enemy.getX()+50 &&  
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+60>=enemy.getX()-10 &&
								this.getX()+60<=enemy.getX()+50 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()>=enemy.getX()-10 &&
								this.getX()<=enemy.getX()+50 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()+60>=enemy.getX()-10 &&
								this.getX()+60<=enemy.getX()+50 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								break;
							case 4:
								if(
								this.getX()>=enemy.getX() && 
								this.getX()<=enemy.getX()+60 &&  
								this.getY()>=enemy.getY() && 
								this.getY()<=enemy.getY()+45){
									return true;
								}
								if(
								this.getX()+60>=enemy.getX() &&
								this.getX()+60<=enemy.getX()+60 &&
								this.getY()>=enemy.getY() &&
								this.getY()<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()>=enemy.getX() &&
								this.getX()<=enemy.getX()+60 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								if(
								this.getX()+60>=enemy.getX() &&
								this.getX()+60<=enemy.getX()+60 &&
								this.getY()+45>=enemy.getY() &&
								this.getY()+45<=enemy.getY()+45) {
									return true;
								}
								break;
							default:
								break;
						}
					}
				}
				break;
			default:
				break;
		}
		return false;
	}
	
	@Override
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
	
	//
	@Override
	public void run() {
		while(true) {
			this.setDirection((int)(Math.random()*5)+1);
			switch(getDirection()) {
				case 1:
					 for (int i = 0; i<30; i++){
	                        if(getY() > 0 && !this.isTouchEnemy() && !this.isTouchPlayer()) {
	                            moveUp();
	                        }
	                        try {
	                            Thread.sleep(50);
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                    }
					break;
				case 2:
					for (int i = 0;i < 30; i++){
                        if(getY()+60 < 800  && !this.isTouchEnemy() && !this.isTouchPlayer()){
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
					break;
				case 3:
					for (int i = 0; i<30; i++){
                        if(getX() > 0 && !this.isTouchEnemy() && !this.isTouchPlayer()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
					break;
				case 4:
					for (int i = 0;i < 30;i++){
                        if(getX()+60 < 800 && !this.isTouchEnemy() && !this.isTouchPlayer()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
					break;
				default:
					break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}