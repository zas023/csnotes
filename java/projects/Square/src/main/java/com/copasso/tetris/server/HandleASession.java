package com.copasso.tetris.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.copasso.tetris.util.Constant.*;

/**
 * for handling a new session for two players
 */
public class HandleASession implements Runnable{
    private Socket player1;
    private Socket player2;

    private DataInputStream fromPlayer1;
    private DataOutputStream toPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer2;

    // Continue to play
    private boolean continueToPlay = true;

    public HandleASession(Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        try {
            // Create data input and output streams
            DataInputStream fromPlayer1 = new DataInputStream(player1.getInputStream());
            DataOutputStream toPlayer1 = new DataOutputStream(player1.getOutputStream());
            DataInputStream fromPlayer2 = new DataInputStream(player2.getInputStream());
            DataOutputStream toPlayer2 = new DataOutputStream(player2.getOutputStream());

            // Write anything to notify player 1 to start
            // This is just to let player 1 know to start
            toPlayer1.writeInt(PLAYER_START);
            toPlayer2.writeInt(PLAYER_START);

            // Continuously serve the players and determine and report
            // the game status to the players
            while (true) {
                // 从客户端中获取得分
                System.out.println("readInt start");
                int score1 = fromPlayer1.readInt();
                int score2 = fromPlayer2.readInt();
                System.out.println("score1:"+score1);
                System.out.println("score1:"+score2);
                System.out.println("readInt end");
                toPlayer1.writeInt(score2);
                toPlayer2.writeInt(score1);
                System.out.println("writeInt end");
//                if (score1>score2){
//                    toPlayer1.writeInt(PLAYER1_WON);
//                    toPlayer2.writeInt(PLAYER1_WON);
//                    break;
//                }else if(score1==score2){
//                    toPlayer1.writeInt(PLAYER_DRAW);
//                    toPlayer2.writeInt(PLAYER_DRAW);
//                    break;
//                }else {
//                    toPlayer1.writeInt(PLAYER2_WON);
//                    toPlayer2.writeInt(PLAYER2_WON);
//                    break;
//                }

            }
        }
        catch(IOException ex) {
            System.err.println(ex);
        }
    }
}