//package com.copasso.tetris.view;
//
//import com.copasso.tetris.model.Cell;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.Random;
//
//import javax.swing.*;
//
//import static com.copasso.tetris.util.Constant.*;
//import static java.awt.event.KeyEvent.*;
//
///**
// * 俄罗斯方块Frame
// */
//public class GameClient extends JFrame implements Runnable,KeyListener{
//
//	// 游戏地图格子，每个格子保存一个方块，数组纪录方块的状态
//	private Cell map[][] = new Cell[NUM_ROW][NUM_COL];
//	// 标记是否正在游戏
//	private boolean isGameOver = false;
//	// 标记是否正在下落
//	private boolean isFall = true;
//	// 图形最下一行在地图中所在行数的索引
//	private int rowIndex = 0;
//	// 生成的图形行数
//	private int blockRows = 0;
//	// 标记是否快速下降
//	private boolean isSpeedUp = false;
//	// 图形形状
//	private int shape;
//	// 玩家总积分
//	private int score1;
//	private int score2;
//
//	private DataInputStream fromServer;
//	private DataOutputStream toServer;
//
//	private boolean continueToPlay = true;
//
//	private boolean isWaiting = true;
//	private boolean isStarted = false;
//
//	private String host = "localhost";
//
//	public GameClient() {
//		//初始化窗体信息
//        setTitle("俄罗斯方块");
//		setSize(NUM_COL * BLOCK_SIZE, NUM_ROW * BLOCK_SIZE);
//        setLocationRelativeTo(null);
//        setAlwaysOnTop(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
//
//		setLayout(new GridLayout(NUM_ROW, NUM_COL));
//
//		//初始化地图
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				add(map[i][j] = new Cell(i,j));
//			}
//		}
//		addKeyListener(this);
//		setVisible(true);
//
//		connectToServer();
//
//		new Thread(this).start();
//	}
//
//	/**
//	 * 连接服务器
//	 */
//	private void connectToServer() {
//		try {
//			// Create a socket to connect to the server
//			Socket socket = new Socket(host, 8000);
//			// Create an input stream to receive data from the server
//			fromServer = new DataInputStream(socket.getInputStream());
//			// Create an output stream to send data to the server
//			toServer = new DataOutputStream(socket.getOutputStream());
//		}
//		catch (Exception ex) {
//			System.err.println(ex);
//		}
//	}
//
//	/************************************************************/
//	public void paint(Graphics g) {
//		super.paint(g);
//
//		// 打印得分
//		g.setColor(Color.GRAY);
//		g.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		g.drawString("YOUR SCORE : " + score1, 5, 50);
//		g.drawString("HIS SCORE : " + score2, 5, 80);
//
//		// 游戏结束，打印结束字符串
//		if (isGameOver) {
//			g.setColor(Color.RED);
//			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
//			g.drawString("GAME OVER !", this.getWidth() / 2 - 140, this.getHeight() / 2);
//		}
//	}
//
//	public void fall() {
//		isFall = true; // 是否能够下落
//		// 从当前行检查，如果遇到阻碍，则停止下落
//		for (int i = 0; i < blockRows; i++) {
//			for (int j = 0; j < NUM_COL; j++) {
//				// 遍历到行中块为活动块，而下一行块为静止块，则遇到阻碍
//				if (map[rowIndex - i][j].isActive() && map[rowIndex - i + 1][j].isStoped()) {
//					isFall = false; // 停止下落
//					break;
//				}
//			}
//			if (!isFall)
//				break;
//		}
//
//		if (isFall) { // 可以下落
//			// 图形下落一行
//			for (int i = 0; i < blockRows; i++) {
//				for (int j = 0; j < NUM_COL; j++) {
//					if (map[rowIndex - i][j].isActive()) { // 活动块向下移动一行
//						map[rowIndex - i][j].setColor(Color.WHITE); // 原活动块变成空块
//						map[rowIndex - i + 1][j].setColor(Color.RED); // 下一行块变成活动块
//					}
//				}
//			}
//			// 重绘
//			repaint();
//		} else if (rowIndex < blockRows) {
//			// 行索引小于生成的图形行数，说明图形刚出现就遇到阻碍，已经顶到地图最上方了，游戏结束
//			isGameOver = true;
//		}
//	}
//
//	/**
//	 * 向下移动
//	 */
//	public void toDown(){
//		rowIndex++;
//	}
//
//	/**
//	 * 向左移动
//	 */
//	public void toLeft() {
//
//		// 标记左边是否有阻碍
//		boolean hasBlock = false;
//
//		//判断是否左边有阻碍
//		for (int i = 0; i < blockRows; i++) {
//			if (map[rowIndex - i][0].isActive()) { // 判断左边是否为墙
//				hasBlock = true;
//				break; // 有阻碍，不用再循环判断行
//			} else {
//				for (int j = 1; j < NUM_COL; j++) { // 判断左边是否有其它块
//					if (map[rowIndex - i][j].isActive() && map[rowIndex - i][j - 1].isStoped()) {
//						hasBlock = true;
//						break; // 有阻碍，不用再循环判断列
//					}
//				}
//				if (hasBlock)
//					break; // 有阻碍，不用再循环判断行
//			}
//		}
//
//		//左边没有阻碍，则将图形向左移动一个块的距离
//		if (!hasBlock) {
//			for (int i = 0; i < blockRows; i++) {
//				for (int j = 1; j < NUM_COL; j++) {
//					if (map[rowIndex - i][j].isActive()) {
//						map[rowIndex - i][j].setColor(Color.WHITE);
//						map[rowIndex - i][j - 1].setColor(Color.RED);
//					}
//				}
//			}
//
//			// 重绘
//			repaint();
//		}
//	}
//
//	/**
//	 * 向右移动
//	 */
//	public void toRight() {
//		// 标记右边是否有阻碍
//		boolean hasBlock = false;
//
//		//判断是否右边有阻碍
//		for (int i = 0; i < blockRows; i++) {
//			if (map[rowIndex - i][NUM_COL - 1].isActive()) { // 判断右边是否为墙
//				hasBlock = true;
//				break; // 有阻碍，不用再循环判断行
//			} else {
//				for (int j = 0; j < NUM_COL - 1; j++) { // 判断右边是否有其它块
//					if (map[rowIndex - i][j].isActive() && map[rowIndex - i][j + 1].isStoped()) {
//						hasBlock = true;
//						break; // 有阻碍，不用再循环判断列
//					}
//				}
//				if (hasBlock)
//					break; // 有阻碍，不用再循环判断行
//			}
//		}
//
//		//右边没有阻碍，则将图形向右移动一个块的距离
//		if (!hasBlock) {
//			for (int i = 0; i < blockRows; i++) {
//				for (int j = NUM_COL - 2; j >= 0; j--) {
//					if (map[rowIndex - i][j].isActive()) {
//						map[rowIndex - i][j].setColor(Color.WHITE);
//						map[rowIndex - i][j + 1].setColor(Color.RED);
//					}
//				}
//			}
//
//			// 重绘
//			repaint();
//		}
//	}
//
//	/**
//	 * 旋转方块图形
//	 */
//	public void toRotate() {
//		try {
//			if (shape == 4) { // 方形，旋转前后是同一个形状
//				return;
//			} else if (shape == 0) { // 条状
//				// 临时数组，放置旋转后图形
//				Cell[][] tmp = new Cell[4][4];
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						tmp[i][j]=new Cell(i,j);
//					}
//				}
//				int startColumn = 0;
//				// 找到图形开始的第一个方块位置
//				for (int i = 0; i < NUM_COL; i++) {
//					if (map[rowIndex][i].isActive()) {
//						startColumn = i;
//						break;
//					}
//				}
//				// 查找旋转之后是否有阻碍，如果有阻碍，则不旋转
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						if (map[rowIndex - 3 + i][j + startColumn].isStoped()) {
//							return;
//						}
//					}
//				}
//
//				if (map[rowIndex][startColumn + 1].isActive()) { // 横向条形，变换为竖立条形
//					for (int i = 0; i < 4; i++) {
//						tmp[i][0].setColor(Color.RED);
//						for (int j = 1; j < 4; j++) {
//							tmp[i][j].setColor(Color.WHITE);
//						}
//					}
//					blockRows = 4;
//				} else { // 竖立条形，变换为横向条形
//					for (int j = 0; j < 4; j++) {
//						tmp[3][j].setColor(Color.RED);
//						for (int i = 0; i < 3; i++) {
//							tmp[i][j].setColor(Color.WHITE);
//						}
//					}
//					blockRows = 1;
//				}
//				// 将原地图中图形修改为变换后图形
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						map[rowIndex - 3 + i][startColumn + j].setColor(tmp[i][j].getColor());
//					}
//				}
//			} else {
//				// 临时数组，放置旋转后图形
//				Cell[][] tmp = new Cell[3][3];
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						tmp[i][j]=new Cell(i,j);
//					}
//				}
//				int startColumn = NUM_COL;
//				// 找到图形开始的第一个方块位置
//				for (int j = 0; j < 3; j++) {
//					for (int i = 0; i < NUM_COL; i++) {
//						if (map[rowIndex - j][i].isActive()) {
//							startColumn = i < startColumn ? i : startColumn;
//						}
//					}
//				}
//				// 判断变换后是否会遇到阻碍
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						if (map[rowIndex - 2 + j][startColumn + 2 - i].isStoped())
//							return;
//					}
//				}
//				// 变换
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						tmp[2 - j][i].setColor(map[rowIndex - 2 + i][startColumn + j].getColor());
//					}
//				}
//				// 将原地图中图形修改为变换后图形
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						map[rowIndex - 2 + i][startColumn + j].setColor(tmp[i][j].getColor());
//					}
//				}
//
//				// 重绘
//				repaint();
//				// 重新修改行指针
//				for (int i = 0; i < 3; i++) {
//					for (int j = 0; j < 3; j++) {
//						if (map[rowIndex - i][startColumn + j] != null
//								|| !map[rowIndex - i][startColumn + j].isEmpty()) {
//							rowIndex = rowIndex - i;
//							blockRows = 3;
//							return;
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			// 遇到数组下标越界，说明不能变换图形形状，不作任何处理
//			e.printStackTrace();
//		}
//	}
//
//	/************************************************************/
//	/**
//	 * 生成随机的方块图形
//	 */
//	public void randomBlocks() {
//		Random rand = new Random();
//		shape = rand.nextInt(7);// 随机形状
//		// 随机图形出现的中间位置
//		int randPos = rand.nextInt(NUM_COL - 4) + 2;
//		//System.out.println("随机图形"+shape+"随机位置"+randPos);
//		// 根据随机数产生不同的图形
//		switch (shape) {
//			case 0: // ─型
//				map[0][randPos].setColor(Color.red);
//				map[0][randPos - 1].setColor(Color.red);
//				map[0][randPos + 1].setColor(Color.red);
//				map[0][randPos + 2].setColor(Color.red);
//				blockRows = 1;
//				break;
//			case 1: // ┗型
//				map[0][randPos].setColor(Color.red);
//				map[1][randPos].setColor(Color.red);
//				map[2][randPos].setColor(Color.red);
//				map[2][randPos + 1].setColor(Color.red);
//				blockRows = 3;
//				break;
//			case 2: // ┛型
//				map[0][randPos].setColor(Color.red);
//				map[1][randPos].setColor(Color.red);
//				map[2][randPos].setColor(Color.red);
//				map[2][randPos - 1].setColor(Color.red);
//				blockRows = 3;
//				break;
//			case 3: // ┷型
//				map[1][randPos].setColor(Color.red);
//				map[1][randPos - 1].setColor(Color.red);
//				map[1][randPos + 1].setColor(Color.red);
//				map[0][randPos].setColor(Color.red);
//				blockRows = 2;
//				break;
//			case 4: // ■型
//				map[0][randPos].setColor(Color.red);
//				map[0][randPos + 1].setColor(Color.red);
//				map[1][randPos].setColor(Color.red);
//				map[1][randPos + 1].setColor(Color.red);
//				blockRows = 2;
//				break;
//			case 5: // Z型
//				map[0][randPos - 1].setColor(Color.red);
//				map[0][randPos].setColor(Color.red);
//				map[1][randPos].setColor(Color.red);
//				map[1][randPos + 1].setColor(Color.red);
//				blockRows = 2;
//				break;
//			case 6: // 反Z型
//				map[0][randPos + 1].setColor(Color.red);
//				map[0][randPos].setColor(Color.red);
//				map[1][randPos].setColor(Color.red);
//				map[1][randPos - 1].setColor(Color.red);
//				blockRows = 2;
//				break;
//		}
//
//		rowIndex = blockRows - 1;
//		isSpeedUp=false;
//	}
//
//	/**
//	 * 判断是否能消除行
//	 */
//	public void judgeBolcks() {
//		int[] blocksCount = new int[NUM_ROW]; // 记录每行有方块的列数
//		int eliminateRows = 0; // 消除的行数
//		//计算每行方块数量
//		for (int i = 0; i < NUM_ROW; i++) {
//			blocksCount[i] = 0;
//			for (int j = 0; j < NUM_COL; j++) {
//				if (map[i][j].isStoped())
//					blocksCount[i]++;
//			}
//		}
//
//		//实现有满行的方块消除操作
//		for (int i = 0; i < NUM_ROW; i++) {
//			if (blocksCount[i] == NUM_COL) {
//				// 清除一行
//				for (int m = i; m >= 0; m--) {
//					for (int n = 0; n < NUM_COL; n++) {
//						map[m][n].setColor((m == 0) ? Color.WHITE : map[m - 1][n].getColor());
//					}
//				}
//				eliminateRows++; // 记录消除行数
//			}
//		}
//		// 计算积分
//		score1 += eliminateRows == 1 ? 10 : (
//				eliminateRows == 2 ? 30 : (eliminateRows == 3 ? 60 : (eliminateRows == 0 ? 0 : 100)));
//		//得分则向服务器提交分数
//		try {
//			toServer.writeInt(score1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// 重绘方块
//		repaint();
//	}
//
//	/**
//	 * 修改图形方块状态
//	 */
//	public void changeBolckState() {
//		for (int i = 0; i < NUM_ROW; i++) {
//			for (int j = 0; j < NUM_COL; j++) {
//				if (map[i][j].isActive()) // 将活动状态改为静止状态
//					map[i][j].setColor(Color.BLUE);
//			}
//		}
//		repaint();
//	}
//
//	/************************************************************/
//	/**
//	 * 向服务器提交分数
//	 * @throws IOException
//	 */
//	private void sendToServer() throws IOException {
//		toServer.writeInt(score1);
//	}
//
//	/**
//	 * 接受服务器消息
//	 * @throws IOException
//	 */
//	private void receiveInfoFromServer() throws IOException {
//		// Receive game status
//		int status = fromServer.readInt();
//		System.out.println("status:"+status);
//		if (status == PLAYER1_WON) {
//			// Player 1 won, stop playing
//			continueToPlay = false;
//
//		}
//		else if (status == PLAYER2_WON) {
//			// Player 2 won, stop playing
//			continueToPlay = false;
//
//		}
//		else if (status == PLAYER_DRAW) {
//			// No winner, game is over
//
//		} else if (status==PLAYER_START){
//			//start game
//			isStarted=true;
//		}else {
//			//get other's score
//			score2=status;
//		}
//	}
//
//	public void run() {
//		while (true) { // 正在游戏
//			if (isWaiting){
//				try {
//					System.out.println("receiveInfoFromServer start");
//					receiveInfoFromServer();
//					System.out.println("receiveInfoFromServer end");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
////			System.out.println((!isGameOver)&&isStarted);
//			if ((!isGameOver)&&isStarted){
//				// 生成方块图形
//				randomBlocks();
//				System.out.println("randomBlocks");
//				// 图形循环下落
//				while (rowIndex < NUM_ROW - 1) {
//					fall(); // 下降
//					if (!isFall) {
//						break;
//					}
//					// 每下降一行，指针向下移动一行
//					System.out.println(rowIndex);
//					toDown();
//					try {
//						// 休眠，加速休眠一毫秒，未加速休眠500毫秒
//						Thread.sleep(isSpeedUp ? 1 : 500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				// 下落到遇到阻碍为止，修改图形方块状态
//				System.out.println("changeBolckState start");
//				changeBolckState();
//				System.out.println("changeBolckState end");
//				// 判断是否可消除行
//				judgeBolcks();
//				System.out.println("judgeBolcks end");
//			}
//		}
//	}
//
//	/************************************************************/
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    public void keyPressed(KeyEvent e) {
//	    switch (e.getKeyCode()){
//            case VK_LEFT:
//				toLeft();
//                break;
//            case VK_RIGHT:
//				toRight();
//                break;
//            case VK_DOWN:
//				// 标记可以加速下落
//				isSpeedUp=true;
//                break;
//            case VK_UP:
//				toRotate();
//        }
//    }
//
//    public void keyReleased(KeyEvent e) {
//	    if (e.getKeyCode()==VK_DOWN)
//			isSpeedUp=false;
//    }
//}