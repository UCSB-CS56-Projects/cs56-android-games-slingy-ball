package jsmli.slingyball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by simin on 11/12/2017.
 */

public class GameView extends View {

    PlayerBall player;
    private Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final float GRAVITY = 10;


    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);



    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    protected void onLayout (boolean changed,
                   int left,
                   int top,
                   int right,
                   int bottom){

        player = new PlayerBall(300,300,300,300,Color.WHITE);




    }


    public void update(int delta) {

        //synchronized (circleLock) {
            //for (Circle c : circles) {
                player.setVx(player.getVx() + GRAVITY );
                player.setVy(player.getVy() + GRAVITY );
                player.setX(player.getX() + delta / 100f * player.getVx());
                player.setY(player.getY() + delta / 100f * player.getVy());

//                if (player.getX() < player.getRadius()) {
//                    player.setVx(-player.getVx() * player.getElasticity());
//                    player.setX(player.getRadius());
//                } else if (player.getX() > maxX - player.getRadius()) {
//                    player.setVx(-player.getVx() * player.getElasticity());
//                    player.setX(maxX - player.getRadius());
//                }
//
//                if (player.getY() < player.getRadius()) {
//                    player.setVy(-player.getVy() * player.getElasticity());
//                    player.setY(player.getRadius());
//                } else if (player.getY() > maxY - player.getRadius()) {
//                    player.setVy(-player.getVy() * player.getElasticity());
//                    player.setY(maxY - player.getRadius());
//                }
            //}
        //}
        postInvalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        p.setColor(Color.BLACK);
        canvas.drawCircle(player.getX(), player.getY(), player.getRadius(), p);





    }


}
