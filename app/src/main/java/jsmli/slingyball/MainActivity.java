package jsmli.slingyball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonView = (Button) findViewById(R.id.button);




    }

    public void clickStartButton(View v){

        if(!(buttonView.getAlpha() < 0.001 && buttonView.getAlpha() > -0.001)){


            buttonView.setAlpha(0);

            GameView.getInstance().startGame();





        }

    }

}
