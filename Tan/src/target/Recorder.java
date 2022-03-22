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
	
	public static int score = 0;//��ҵ÷�
	
	public static String recordPath="src\\myRecorder.txt";	//����ҷ������浽ָ��·���ļ���
	
	public static BufferedWriter bufferedWriter = null; //���ô�����BufferedWriter������д�����
	
	public static BufferedReader bufferedReader = null; //���ô�����BufferedReader����ȡmyRecorder�ļ��е�ս����¼��ѡ���Ƿ�����Ͼ���Ϸ��
	
	//����һ������������Ϸ�˳�ʱ�����ǽ�allEnemyTankNum���浽 recordFile
    public static void keepRecord() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(recordPath));
        bufferedWriter.write(score + "\r\n");
      //��������̹��Vector��Ȼ�����������漴��
        //OOP������һ�����ԣ�Ȼ��ͨ��setXxx�õ�����Vector
        for (int i = 0; i < enemies.size(); i++){
            //ȡ������̹��
            Enemy enemyTank = enemies.get(i);
            //���������ж��£����Բ��жϣ�
            if (enemyTank.isAlive()){
                //�����enemyTank��Ϣ
                String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                //д�뵽�ļ�
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
    	//line���ڶ�ȡ�����ļ��е�������...
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
