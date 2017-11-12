package jsmli.slingyball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by simin on 11/11/2017.
 */

public class ControlBall extends View {

    private float controlBallCenterX;
    private float controlBallCenterY;
    private float controlBallRadius;

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

    public ControlBall(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

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

//        synchronized (circleLock) {
//            for (Circle c : circles) {
//                cp.setColor(Color.BLACK);
//                canvas.drawCircle(player.getX(), player.getY(), player.getRadius(), cp);
//                cp.setColor(player.getColor());
//                canvas.drawCircle(player.getX(), player.getY(), player.getRadius() - 5, cp);
//            }
//        }
//
//        // Preview Circle
//        if (makingCircle) {
//            cp.setColor(Color.BLACK);
//            canvas.drawCircle(newX, newY, newRadius, cp);
//            cp.setColor(newColor);
//            canvas.drawCircle(newX, newY, newRadius - 5, cp);
//        }
//
//        // Circle Count
//        tp.setColor(Color.WHITE);
//        tp.setTextAlign(Paint.Align.CENTER);
//        int fontSizeDip = 30;
//        int fontSizePixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, fontSizeDip, getResources().getDisplayMetrics());
//        tp.setTextSize(fontSizePixels);
//
//        canvas.drawText(circles.size() + " " + getResources().getString(R.string.count_balls), maxX / 2, fontSizePixels, tp);
//
//        if (DEBUG) {
//            String multiLine = "gx: " + gx + "\ngy: " + gy;
//            tp.setTextAlign(Paint.Align.LEFT);
//            tp.setTextSize(30);
//            String lines[] = multiLine.split("\n");
//            int yOffset = 30;
//            for (int i = 0; i < lines.length; ++i) {
//                canvas.drawText(lines[i], 0, 60 + yOffset, tp);
//                tp.getTextBounds(lines[i], 0, lines[i].length(), currentBounds);
//                yOffset += currentBounds.height() + 5;
//            }
//        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                // TO:DO Use trigonometry to cut the corners of this if statement
                if(event.getX() >  controlBallCenterX - controlBallRadius
                        && event.getX() < controlBallCenterX + controlBallRadius
                        && event.getY() >  controlBallCenterY - controlBallRadius
                        && event.getY() < controlBallCenterY + controlBallRadius){

                    drawing = true;
                    startX = event.getX();
                    startY = event.getY();



                }



//                for (int i = circles.size() - 1; i >= 0; --i) {
//                    if (circles.get(i).isTouching(touchX, touchY)) {
//                        synchronized (circleLock) {
//                            circles.remove(circles.get(i));
//                        }
//                        return true;
//                    }
//                }
//
//                newX = touchX;
//                newY = touchY;
//                newRadius = MIN_BALL_RADIUS;
//                newColor = Color.argb(255, rand.nextInt(256),
//                        rand.nextInt(256), rand.nextInt(256));
//                makingCircle = true;

                return true;

            case MotionEvent.ACTION_MOVE:

                if(drawing){

                    endX = event.getX();
                    endY = event.getY();

                    postInvalidate();



                }



                return true;

            case MotionEvent.ACTION_UP:

                drawing = false;


                return true;
        }
        return false;
    }

}
