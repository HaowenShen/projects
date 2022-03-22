package target;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Recorder {
	
	public static Vector<Enemy> enemies = new Vector<>();
	
	public static Vector<Node> nodes = new Vector<>();
	
	public static int score = 0;//玩家得分
	
	public static String recordPath="src\\myRecorder.txt";	//将玩家分数保存到指定路径文件中
	
	public static BufferedWriter bufferedWriter = null; //调用处理流BufferedWriter，进行写入操作
	
	public static BufferedReader bufferedReader = null; //调用处理流BufferedReader，读取myRecorder文件中的战斗记录，选择是否继续上局游戏。
	
	//增加一个方法，当游戏退出时，我们将allEnemyTankNum保存到 recordFile
    public static void keepRecord() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(recordPath));
        bufferedWriter.write(score + "\r\n");
      //遍历敌人坦克Vector，然后根据情况保存即可
        //OOP，定义一个属性，然后通过setXxx得到敌人Vector
        for (int i = 0; i < enemies.size(); i++){
            //取出敌人坦克
            Enemy enemyTank = enemies.get(i);
            //建议下面判断下（可以不判断）
            if (enemyTank.isAlive()){
                //保存该enemyTank信息
                String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                //写入到文件
                bufferedWriter.write(record + "\r\n");
            }
        }
        if (bufferedWriter != null){
            bufferedWriter.close();
        }
    }
    
    public static Vector<Node> getNodesAndEnemyTankRec() throws IOException{
    	bufferedReader = new BufferedReader(new FileReader(recordPath));
    	score=Integer.parseInt(bufferedReader.readLine());
    	//line用于读取保存文件中的行数据...
    	String line="";
    	while((line = bufferedReader.readLine()) != null) {
    		String[] xyd = line.split(" ");
    		Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
    		nodes.add(node);
    	}
    	if(bufferedReader != null) {
    		bufferedReader.close();
    	}
		return nodes;
    }
    
	public static void setEnemies(Vector<Enemy> enemies) {
		Recorder.enemies = enemies;
	}

	public static int getScore() {
		return Recorder.score;
	}

	public static String getRecordPath() {
		return Recorder.recordPath;
	}

	public static BufferedWriter getWriter() {
		return Recorder.bufferedWriter;
	}

	public static void setScore(int score) {
		Recorder.score = score;
	}
	
	public static void addScore() {
		Recorder.score++;
	}
}
