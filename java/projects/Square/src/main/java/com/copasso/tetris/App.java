package com.copasso.tetris;

import com.copasso.tetris.view.GameClient;

public class App {

	public static void main(String[] args) {
		// 启动游戏
		new Thread(new GameClient()).start();
	}

}
