package jsmli.slingyball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ControlBall extends View {

    private float controlBallCenterX;
    private float controlBallCenterY;
    private float controlBallRadius;
    public static PlayerBall playerListener;
    boolean validTouch;

    private Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    boolean drawing = false;

    public ControlBall(Context context) {
        super(context);

        this.setBackgroundColor(Color.RED);

    }

    public ControlBall(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        p.setColor(Color.WHITE);
        p.setStrokeWidth(10);
        this.setBackgroundColor(Color.RED);

    }

    public ControlBall(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public ControlBall(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    @Override
    protected void onSizeChanged (int w, int h, int oldw, int oldh){

        controlBallCenterX = this.getWidth()/2;
        controlBallCenterY = this.getHeight()/2;
        controlBallRadius = this.getWidth()/9;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(controlBallCenterX, controlBallCenterY, controlBallRadius, p);

        if(drawing)
            canvas.drawLine(startX, startY, endX, endY, p);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if(GameView.getScrollVelocity() == 0) {

                    if (Math.pow((event.getX() - controlBallCenterX), 2) +
                            Math.pow((event.getY() - controlBallCenterY), 2) <
                            Math.pow(controlBallRadius, 2)) {

                        drawing = true;
                        startX = event.getX();
                        startY = event.getY();

                    }

                    validTouch = true;

                }else{
                    validTouch = false;
                }

                return true;

            case MotionEvent.ACTION_MOVE:

                if(drawing){

                    endX = event.getX();
                    endY = event.getY();

                    postInvalidate();

                }

                return true;

            case MotionEvent.ACTION_UP:

                if(validTouch) {


                    if (GameView.getGravity() == 0f) {

                        GameView.setGravity(GameView.GAMEGRAVITY);
                    }

                    drawing = false;

                    playerListener.setVx(startX - endX);
                    playerListener.setVy(startY - endY);

                }

                return true;
        }
        return false;
    }
}
