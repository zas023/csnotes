package com.copasso.tetris.view;

import com.copasso.tetris.model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import static com.copasso.tetris.util.Constant.*;
import static java.awt.event.KeyEvent.*;

/**
 * 俄罗斯方块
 */
public class GamePanel extends JPanel implements Runnable,KeyListener{

	// 游戏地图格子，每个格子保存一个方块，数组纪录方块的状态
	private State map[][] = new State[NUM_ROW][NUM_COL];
	// 标记是否正在游戏
	private boolean isGameOver = false;
	// 标记是否正在下落
	private boolean isFall = true;
	// 图形最下一行在地图中所在行数的索引
	private int rowIndex = 0;
	// 生成的图形行数
	private int blockRows = 0;
	// 标记是否快速下降
	private boolean immediate = false;
	// 图形形状
	private int shape;
	// 玩家总积分
	private int score;

	public GamePanel() {

		//初始化地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = State.EMPTY;
            }
        }

        addKeyListener(this);
	}

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                if (map[i][j] == State.ACTIVE) { // 绘制活动块
                    g.setColor(Color.RED);
                    g.fillRoundRect(j * BLOCK_SIZE, i * BLOCK_SIZE + 25,
                            BLOCK_SIZE - 1, BLOCK_SIZE - 1, BLOCK_SIZE / 5,
                            BLOCK_SIZE / 5);
                } else if (map[i][j] == State.STOPED) { // 绘制静止块
                    g.setColor(Color.BLUE);
                    g.fillRoundRect(j * BLOCK_SIZE, i * BLOCK_SIZE + 25,
                            BLOCK_SIZE - 1, BLOCK_SIZE - 1, BLOCK_SIZE / 5,
                            BLOCK_SIZE / 5);
                }
            }
        }

        /* 打印得分 */
        g.setColor(Color.GRAY);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.drawString("SCORE : " + score, 5, 70);

        // 游戏结束，打印结束字符串
        if (isGameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("GAME OVER !", this.getWidth() / 2 - 140,
                    this.getHeight() / 2);
        }
    }


	/**
	 * 生成随机的方块图形
	 */
	private void generateBlocks() {
		Random rand = new Random();
		shape = rand.nextInt(8);// 随机形状
		// 随机图形出现的中间位置
		int randPos = rand.nextInt(NUM_COL - 4) + 2;
		// 根据随机数产生不同的图形
		switch (shape) {
			case 0: // ─型
				map[0][randPos] = map[0][randPos - 1] = map[0][randPos + 1] = map[0][randPos + 2] = State.ACTIVE;
				blockRows = 1;
				break;
			case 1: // ┗型
				map[0][randPos] = map[1][randPos] = map[2][randPos] = map[2][randPos + 1] = State.ACTIVE;
				blockRows = 3;
				break;
			case 2: // ┛型
				map[0][randPos] = map[1][randPos] = map[2][randPos] = map[2][randPos - 1] = State.ACTIVE;
				blockRows = 3;
				break;
			case 3: // ┷型
				map[1][randPos] = map[1][randPos - 1] = map[1][randPos + 1] = map[0][randPos] = State.ACTIVE;
				blockRows = 2;
				break;
			case 4: // ■型
				map[0][randPos] = map[0][randPos + 1] = map[1][randPos] = map[1][randPos + 1] = State.ACTIVE;
				blockRows = 2;
				break;
			case 5: // Z型
				map[0][randPos - 1] = map[0][randPos] = map[1][randPos] = map[1][randPos + 1] = State.ACTIVE;
				blockRows = 2;
				break;
			case 6: // 反Z型
				map[0][randPos + 1] = map[0][randPos] = map[1][randPos] = map[1][randPos - 1] = State.ACTIVE;
				blockRows = 2;
				break;
		}

		rowIndex = blockRows - 1;
	}

	/**
	 * 图形向下落
	 */
	private void fall() {
		isFall = true; // 是否能够下落
		// 从当前行检查，如果遇到阻碍，则停止下落
		for (int i = 0; i < blockRows; i++) {
			for (int j = 0; j < NUM_COL; j++) {
				// 遍历到行中块为活动块，而下一行块为静止块，则遇到阻碍
				if (map[rowIndex - i][j] == State.ACTIVE
						&& map[rowIndex - i + 1][j] == State.STOPED) {
					isFall = false; // 停止下落
					break;
				}
			}
			if (!isFall)
				break;
		}

		if (isFall) { // 可以下落
			// 图形下落一行
			for (int i = 0; i < blockRows; i++) {
				for (int j = 0; j < NUM_COL; j++) {
					if (map[rowIndex - i][j] == State.ACTIVE) { // 活动块向下移动一行
						map[rowIndex - i][j] = State.EMPTY; // 原活动块变成空块
						map[rowIndex - i + 1][j] = State.ACTIVE; // 下一行块变成活动块
					}
				}
			}
			// 重绘
			repaint();
		} else if (rowIndex < blockRows) {
			// 行索引小于生成的图形行数，说明图形刚出现就遇到阻碍，已经顶到地图最上方了，游戏结束
            isGameOver = true;
		}
	}

	/**
	 * 向左走
	 */
	private void toLeft() {
		// 标记左边是否有阻碍
		boolean hasBlock = false;

		/* 判断是否左边有阻碍 */
		for (int i = 0; i < blockRows; i++) {
			if (map[rowIndex - i][0] == State.ACTIVE) { // 判断左边是否为墙
				hasBlock = true;
				break; // 有阻碍，不用再循环判断行
			} else {
				for (int j = 1; j < NUM_COL; j++) { // 判断左边是否有其它块
					if (map[rowIndex - i][j] == State.ACTIVE
							&& map[rowIndex - i][j - 1] == State.STOPED) {
						hasBlock = true;
						break; // 有阻碍，不用再循环判断列
					}
				}
				if (hasBlock)
					break; // 有阻碍，不用再循环判断行
			}
		}

		/* 左边没有阻碍，则将图形向左移动一个块的距离 */
		if (!hasBlock) {
			for (int i = 0; i < blockRows; i++) {
				for (int j = 1; j < NUM_COL; j++) {
					if (map[rowIndex - i][j] == State.ACTIVE) {
						map[rowIndex - i][j] = State.EMPTY;
						map[rowIndex - i][j - 1] = State.ACTIVE;
					}
				}
			}

			// 重绘
			repaint();
		}
	}

	/**
	 * 向右走
	 */
	private void toRight() {
		// 标记右边是否有阻碍
		boolean hasBlock = false;

		/* 判断是否右边有阻碍 */
		for (int i = 0; i < blockRows; i++) {
			if (map[rowIndex - i][NUM_COL - 1] == State.ACTIVE) { // 判断右边是否为墙
				hasBlock = true;
				break; // 有阻碍，不用再循环判断行
			} else {
				for (int j = 0; j < NUM_COL - 1; j++) { // 判断右边是否有其它块
					if (map[rowIndex - i][j] == State.ACTIVE
							&& map[rowIndex - i][j + 1] == State.STOPED) {
						hasBlock = true;
						break; // 有阻碍，不用再循环判断列
					}
				}
				if (hasBlock)
					break; // 有阻碍，不用再循环判断行
			}
		}

		/* 右边没有阻碍，则将图形向右移动一个块的距离 */
		if (!hasBlock) {
			for (int i = 0; i < blockRows; i++) {
				for (int j = NUM_COL - 2; j >= 0; j--) {
					if (map[rowIndex - i][j] == State.ACTIVE) {
						map[rowIndex - i][j] = State.EMPTY;
						map[rowIndex - i][j + 1] = State.ACTIVE;
					}
				}
			}

			// 重绘
			repaint();
		}
	}

	/**
	 * 向下直走
	 */
	private void toDown() {
		// 标记可以加速下落
		immediate = true;
	}

	/**
	 * 旋转方块图形
	 */
	private void toRotate() {
		try {
			if (shape == 4) { // 方形，旋转前后是同一个形状
				return;
			} else if (shape == 0) { // 条状
				// 临时数组，放置旋转后图形
				State[][] tmp = new State[4][4];
				int startColumn = 0;
				// 找到图形开始的第一个方块位置
				for (int i = 0; i < NUM_COL; i++) {
					if (map[rowIndex][i] == State.ACTIVE) {
						startColumn = i;
						break;
					}
				}
				// 查找旋转之后是否有阻碍，如果有阻碍，则不旋转
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (map[rowIndex - 3 + i][j + startColumn] == State.STOPED) {
							return;
						}
					}
				}

				if (map[rowIndex][startColumn + 1] == State.ACTIVE) { // 横向条形，变换为竖立条形
					for (int i = 0; i < 4; i++) {
						tmp[i][0] = State.ACTIVE;
						for (int j = 1; j < 4; j++) {
							tmp[i][j] = State.EMPTY;
						}
					}
					blockRows = 4;
				} else { // 竖立条形，变换为横向条形
					for (int j = 0; j < 4; j++) {
						tmp[3][j] = State.ACTIVE;
						for (int i = 0; i < 3; i++) {
							tmp[i][j] = State.EMPTY;
						}
					}
					blockRows = 1;
				}
				// 将原地图中图形修改为变换后图形
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						map[rowIndex - 3 + i][startColumn + j] = tmp[i][j];
					}
				}
			} else {
				// 临时数组，放置旋转后图形
				State[][] tmp = new State[3][3];
				int startColumn = NUM_COL;
				// 找到图形开始的第一个方块位置
				for (int j = 0; j < 3; j++) {
					for (int i = 0; i < NUM_COL; i++) {
						if (map[rowIndex - j][i] == State.ACTIVE) {
							startColumn = i < startColumn ? i : startColumn;
						}
					}
				}
				// 判断变换后是否会遇到阻碍
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (map[rowIndex - 2 + j][startColumn + 2 - i] == State.STOPED)
							return;
					}
				}
				// 变换
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[2 - j][i] = map[rowIndex - 2 + i][startColumn + j];
					}
				}
				// 将原地图中图形修改为变换后图形
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						map[rowIndex - 2 + i][startColumn + j] = tmp[i][j];
					}
				}

				// 重绘
				repaint();
				// 重新修改行指针
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (map[rowIndex - i][startColumn + j] != null
								|| map[rowIndex - i][startColumn + j] != State.EMPTY) {
							rowIndex = rowIndex - i;
							blockRows = 3;
							return;
						}
					}
				}
			}
		} catch (Exception e) {
			// 遇到数组下标越界，说明不能变换图形形状，不作任何处理
		}
	}

	/**
	 * 判断是否能消除行
	 */
	private void judge() {
		int[] blocksCount = new int[NUM_ROW]; // 记录每行有方块的列数
		int eliminateRows = 0; // 消除的行数
		//计算每行方块数量
		for (int i = 0; i < NUM_ROW; i++) {
			blocksCount[i] = 0;
			for (int j = 0; j < NUM_COL; j++) {
				if (map[i][j] == State.STOPED)
					blocksCount[i]++;
			}
		}

		//实现有满行的方块消除操作
		for (int i = 0; i < NUM_ROW; i++) {
			if (blocksCount[i] == NUM_COL) {
				// 清除一行
				for (int m = i; m >= 0; m--) {
					for (int n = 0; n < NUM_COL; n++) {
						map[m][n] = (m == 0) ? State.EMPTY : map[m - 1][n];
					}
				}

				eliminateRows++; // 记录消除行数
			}
		}

		// 计算积分
		score += eliminateRows == 1 ? 10 : (eliminateRows == 2 ? 30
				: (eliminateRows == 3 ? 60 : (eliminateRows == 0 ? 0 : 100)));
		// 重绘方块
		repaint();
	}

	/**
	 * 修改图形方块状态
	 */
	private void changeBolckState() {
		for (int i = 0; i < NUM_ROW; i++) {
			for (int j = 0; j < NUM_COL; j++) {
				if (map[i][j] == State.ACTIVE) // 将活动状态改为静止状态
					map[i][j] = State.STOPED;
			}
		}
		repaint();
	}

	public void run() {
		while (!isGameOver) { // 正在游戏
			// 生成方块图形
			generateBlocks();
			// 图形循环下落
			while (rowIndex < NUM_ROW - 1) {
				fall(); // 下降
				if (!isFall) {
					break;
				}
				rowIndex++; // 每下降一行，指针向下移动一行
				try {
					// 休眠，加速休眠一毫秒，未加速休眠500毫秒
					Thread.sleep(immediate ? 1 : 500);
				} catch (InterruptedException e) {
				}
			}
			immediate = false; // 按向下键加速，默认不加速
			// 下落到遇到阻碍为止，修改图形方块状态
			changeBolckState();
			// 判断是否可消除行
			judge();
		}
	}

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
	    switch (e.getKeyCode()){
            case VK_LEFT:
                toLeft();
                break;
            case VK_RIGHT:
                toRight();
                break;
            case VK_DOWN:
                toDown();
                break;
            case VK_UP:
                toRotate();
        }
    }

    public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode()==VK_DOWN)
	        immediate=false;
    }
}