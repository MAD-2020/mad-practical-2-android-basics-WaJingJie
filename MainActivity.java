package sg.edu.np.mad.whack_a_mole;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Whack-a-mole";
    TextView score;
    Button rightbtn, centerbtn, leftbtn;
    int totalscore = 0;

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");

        score = (TextView)findViewById(R.id.score);
        rightbtn = (Button)findViewById(R.id.righthole);
        centerbtn = (Button)findViewById(R.id.centerhole);
        leftbtn = (Button)findViewById(R.id.lefthole);

        rightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Right button clicked!");
                if(rightbtn.getText().toString()=="*"){
                    Log.v(TAG, "Hit, score added!");
                    totalscore = totalscore + 1;
                }
                else if(rightbtn.getText().toString()=="O"){
                    Log.v(TAG, "Missed, score deducted");
                    totalscore = totalscore - 1;
                }
                score.setText(Integer.toString(totalscore));
                setNewMole();
            }
        });

        centerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Center button clicked");
                if(centerbtn.getText().toString()=="*"){
                    Log.v(TAG, "Hit, score added!");
                    totalscore = totalscore + 1;
                }
                else if(centerbtn.getText().toString()=="O"){
                    Log.v(TAG, "Hit, score added!");
                    totalscore = totalscore - 1;
                }
                score.setText(Integer.toString(totalscore));
                setNewMole();
            }
        });

        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Left button clicked");
                if(leftbtn.getText().toString()=="*"){
                    Log.v(TAG, "Hit, score added!");
                    totalscore = totalscore + 1;
                }
                else if(leftbtn.getText().toString()=="O"){
                    Log.v(TAG, "Hit, score added!");
                    totalscore = totalscore - 1;
                }
                score.setText(Integer.toString(totalscore));
                setNewMole();
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        if(randomLocation == 0){
            rightbtn.setText("*");
            centerbtn.setText("O");
            leftbtn.setText("O");
        }

        else if(randomLocation == 1){
            rightbtn.setText("O");
            centerbtn.setText("*");
            leftbtn.setText("O");
        }

        else if(randomLocation == 2){
            rightbtn.setText("O");
            centerbtn.setText("O");
            leftbtn.setText("*");
        }
    }
}
