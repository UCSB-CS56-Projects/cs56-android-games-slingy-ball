package jsmli.slingyball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View {

    PlayerBall player;
    ArrayList<Platform> platforms = new ArrayList<>();

    private Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

    private static float gravity = 0.0f;
    private static float scrollVelocity = 0.0f;
    public static final float GAMEGRAVITY = 4f;

    GameThread thread;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    public void startThread() {
        thread = new GameThread(this);
        thread.setRunning(true);
        thread.start();
    }

    public void createPlayer() {
        player = new PlayerBall(this.getWidth()/2,this.getHeight()-50,(35.0f/986.0f)*this.getWidth(),0.90f,Color.WHITE);
    }

    public void createPlatform() {
        platforms.add(new Platform(this.getWidth()/2, -60,260,(16.0f/1059f)*this.getHeight(),Color.WHITE));
    }

    protected void onLayout (boolean changed,
                   int left,
                   int top,
                   int right,
                   int bottom){

        createPlayer();

        platforms.add(new Platform(this.getWidth()+270, this.getHeight()-20, 260, (16.0f/1059f)*this.getHeight(), Color.WHITE));// invisible platform for index purposes
        platforms.add(new Platform(this.getWidth()/2, this.getHeight()/2, 260, (16.0f/1059f)*this.getHeight(), Color.WHITE));

        player.setVx(0);
        player.setVy(0);

        startThread();
    }

    public void update(int delta) {

        player.setVy(player.getVy() + gravity );
        player.setX(player.getX() + delta / 100f * player.getVx());
        player.setY(player.getY() + delta / 100f * (player.getVy()+scrollVelocity));

        for(Platform plat: platforms){
            plat.setY(plat.getY() + delta / 100f * scrollVelocity);
        }

        if(platforms.get(0).getY() >= this.getHeight()-20){

            scrollVelocity = 0;
            gravity = GAMEGRAVITY;
            platforms.get(0).setY(this.getHeight()-20);
        }

        if (player.getX() < player.getRadius()) {
            player.setVx(-player.getVx() * player.getElasticity());
            player.setX(player.getRadius());
        } else if (player.getX() > this.getWidth() - player.getRadius()) {
            player.setVx(-player.getVx() * player.getElasticity());
            player.setX(this.getWidth() - player.getRadius());
        }

//        if (player.getY() < player.getRadius()) {
//            player.setVy(-player.getVy() * player.getElasticity());
//            player.setY(player.getRadius()); }
        if (player.getY() > this.getHeight() - player.getRadius()) {
            player.setVy(-player.getVy() * player.getElasticity());
            player.setY(this.getHeight() - player.getRadius());
        }

        for(int i = 0; i < platforms.size(); i++){
            Platform plat = platforms.get(i);
            if(player.getX() < plat.getX() + plat.getLength() && player.getX() > plat.getX()){

                if((player.getY()+player.getRadius() > plat.getY() && player.getY()-player.getRadius() < plat.getY()) ||
                                (player.getY()-player.getRadius() < plat.getY() + plat.getHeight() && player.getY()+player.getRadius() > plat.getY() + plat.getHeight())) {

                    player.setVy(-player.getVy() * player.getElasticity());

                    if(player.getY()+player.getRadius() > plat.getY() && player.getY()-player.getRadius() < plat.getY()) {


                        if(platforms.indexOf(plat) == 1){

                            player.setVy(0);
                            player.setVx(0);
                            scrollVelocity = 100;
                            gravity = 0;

                            createPlatform();
                            platforms.remove(0);

                        }else{
                            player.setY(plat.getY() - player.getRadius());
                        }

                    } else {
                        player.setY(plat.getY() + plat.getHeight() + player.getRadius());
                    }
                }
            }

            if (player.getY() > plat.getY() && player.getY() < plat.getY()+plat.getHeight()) {

                if ((player.getX()+player.getRadius() > plat.getX() && player.getX()-player.getRadius() < plat.getX()) ||
                        (player.getX()-player.getRadius() < plat.getX()+plat.getLength() && player.getX()+player.getRadius() > plat.getX()+plat.getHeight())) {

                    player.setVx(-player.getVx() * player.getElasticity());

                    if (player.getX()+player.getRadius() > plat.getX() && player.getX()-player.getRadius() < plat.getX()) {
                        player.setX(plat.getX()-player.getRadius());
                    } else {
                        player.setX(plat.getX()+plat.getLength()+player.getRadius());
                    }
                }
            }
        }

        postInvalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        p.setColor(player.getColor());
        canvas.drawCircle(player.getX(), player.getY(), player.getRadius(), p);

        for(Platform x: platforms){
            p.setColor(x.getColor());
            canvas.drawRect(x.getX(), x.getY(),x.getX()+x.getLength(), x.getY()+x.getHeight(), p);
        }
    }

    public static void setGravity(float newGravity){
        gravity = newGravity;
    }

    public static float getGravity(){
        return gravity;
    }

    public static float getScrollVelocity(){
        return scrollVelocity;
    }

}
