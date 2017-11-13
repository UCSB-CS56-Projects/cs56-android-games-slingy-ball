package jsmli.slingyball;

import android.os.SystemClock;

public class GameThread extends Thread {

    private GameView gameView;
    private boolean running;

    public GameThread(GameView gameView) {
        this.gameView = gameView;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        long time1 = System.currentTimeMillis();
        long time2;

        while (running) {
            SystemClock.sleep(5);
            time2 = System.currentTimeMillis();
            int delta = (int) (time2 - time1);
            gameView.update(delta);
            time1 = time2;
        }
    }
}
