package com.copasso.tetris;

import com.copasso.tetris.view.GameFrame;

public class App {

	public static void main(String[] args) {
		// 启动游戏
		new Thread(new GameFrame()).start();
//		SquareFactory squareFactory = new SquareFactory();
//		Ground ground = new Ground();
//		GamePanel gamePanel = new GamePanel();
//
//		Controller controller = new Controller(
//				ground, squareFactory,gamePanel);
//
//		//GamePanel由于是继承JPanel，故需要一个Frame才可以显示出来。
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(gamePanel.getSize().width+10, gamePanel.getSize().height+35);
//		frame.add(gamePanel);
//		gamePanel.addKeyListener(controller);
//		frame.addKeyListener(controller);
//		frame.setVisible(true);
//		controller.newGame();
	}

}
