package jsmli.slingyball;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Button buttonView;
    private static MainActivity mainAcivityInstance;

    public static int highScore;

    public static MainActivity getMainAcivityInstance(){

        return mainAcivityInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonView = (Button) findViewById(R.id.button);

        SharedPreferences prefs = this.getSharedPreferences("highScore", Context.MODE_PRIVATE);
        MainActivity.highScore = prefs.getInt("highScoreKey", 0);

        mainAcivityInstance = this;

    }

    public void clickStartButton(View v){

        if(!(buttonView.getAlpha() < 0.001 && buttonView.getAlpha() > -0.001)){

            buttonView.setAlpha(0);

            GameView.getInstance().startGame();

        }

    }

    public void setHighScore(int newScore){

        highScore = newScore;

        SharedPreferences prefs = this.getSharedPreferences("highScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("highScoreKey", newScore);
        editor.apply();

    }

    public void clickPauseButton(View v){


    }
}
