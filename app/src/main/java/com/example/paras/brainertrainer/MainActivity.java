package com.example.paras.brainertrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnStart,button1,button2,button3,button4,btnPlayAgain;
    RelativeLayout relativeLayout2;
//GridLayout gridLayout1;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int correctAnsLocation;
    int score;
    int numberOfQuestions=0;

TextView sum,points,timer,checksum;



public void playAgain(final View view)
{

  score=0;
  numberOfQuestions=0;
timer.setText("30s");
points.setText("0/0");
checksum.setText("");

btnPlayAgain.setVisibility(view.INVISIBLE);
generateQuestions();

    new CountDownTimer(30100,1000)
    {

        @Override
        public void onTick(long l) {
            timer.setText(String.valueOf(l/1000)+"s");

        }

        @Override
        public void onFinish() {
            btnPlayAgain.setVisibility(view.VISIBLE);

            checksum.setText("Your Score"+":"+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        }
    }.start();


}





public void generateQuestions()
{
    Random random=new Random();
    int a=random.nextInt(21);
    int b=random.nextInt(21);


    sum.setText(Integer.toString(a)+"+"+Integer.toString(b));

    correctAnsLocation=random.nextInt(4);
    answers.clear();

    int incorrectAns;


    for(int i=0;i<4;i++)
    {
        if(i==correctAnsLocation)
        {
            answers.add(a+b);

        }
        else
        {
            incorrectAns=random.nextInt(41);

            while(incorrectAns == a+b)
            {
                incorrectAns=random.nextInt(41);
            }

            answers.add(incorrectAns);
        }
    }

    button1.setText(Integer.toString(answers.get(0)));
    button2.setText(Integer.toString(answers.get(1)));
    button3.setText(Integer.toString(answers.get(2)));
    button4.setText(Integer.toString(answers.get(3)));
}











    public void chooseAnswer(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(correctAnsLocation)))
        {

            score++;
            checksum.setText("Correct !");
            //Log.i("Correct",(String )view.getTag());
        }
        else
        {
            checksum.setText("Incorrect !");
        }
        numberOfQuestions++;

        points.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestions();

        //Log.i("Tag ", (String) view.getTag());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnStart=(Button)findViewById(R.id.btnGo);
         sum=(TextView)findViewById(R.id.sumTextView);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        checksum=(TextView)findViewById(R.id.resultTextView);
        points=(TextView)findViewById(R.id.pointsTextView);
        timer=(TextView)findViewById(R.id.timerTextView);
        btnPlayAgain=(Button)findViewById(R.id.btnPlayAgain);
        relativeLayout2=(RelativeLayout)findViewById(R.id.relativeLayout2);
    //    gridLayout1=(GridLayout)findViewById(R.id.gridLayout);
       //generateQuestions();





        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnStart.setVisibility(View.INVISIBLE);
                relativeLayout2.setVisibility(RelativeLayout.VISIBLE);
                playAgain(findViewById(R.id.btnPlayAgain));
            }

        });




    }
}
