package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import graphic.MyPanel;
import target.Recorder;

@SuppressWarnings("serial")
public class Main extends JFrame{
	MyPanel myPanel = null;
	static int opt;
	public Main() throws IOException{
		myPanel = new MyPanel(opt);
		new Thread(myPanel).start();
		this.add(myPanel);
		this.addKeyListener(myPanel);
		this.setSize(1300, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[]args) throws IOException{
		System.out.println("输入1(新游戏) or 2(继续上一局)");
		Scanner scanner = new Scanner(System.in);
		opt = scanner.nextInt();
		Main main = new Main();
		scanner.close();
        main.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到关闭窗口");
                try {
                    Recorder.keepRecord();
                } catch (IOException ex){
                    ex.printStackTrace();
                }
                //退出
                System.exit(0);
            }
        });
	}
}
