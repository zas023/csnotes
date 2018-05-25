package com.copasso.tetris;

import com.copasso.tetris.view.GameFrame;

public class App {

	public static void main(String[] args) {
		// 启动游戏
		new Thread(new GameFrame()).start();
	}

}
