package com.example.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import static android.content.ContentValues.TAG;


public class MainActivity extends Activity {

        //Components
        TextView    rez;

        Button      bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
        Button      btclear;

        ImageButton btplus,  btminus,  btmnozenje,  btdelenje,  btednakvo;

        //Pres Numbers
        String  runningNumber = "";

        //Pres Operations
        int brojA;
        int brojB;
        int brojC;

        boolean     plus,   minus,  mnozenje,   delenje,    ednakvo = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initComponents();
        setComponents();
    }


    private void initComponents() {

        rez     = findViewById(R.id.textViewRez);

        bt0     = findViewById(R.id.buttonNula);
        bt1     = findViewById(R.id.button1);
        bt2     = findViewById(R.id.button2);
        bt3     = findViewById(R.id.button3);
        bt4     = findViewById(R.id.button4);
        bt5     = findViewById(R.id.button5);
        bt6     = findViewById(R.id.button6);
        bt7     = findViewById(R.id.button7);
        bt8     = findViewById(R.id.button8);
        bt9     = findViewById(R.id.button9);
        btclear = findViewById(R.id.buttonClear);

        btplus      = findViewById(R.id.imageButtonAdd);
        btminus     = findViewById(R.id.imageButtonSubtract);
        btmnozenje  = findViewById(R.id.imageButtonMultiply);
        btdelenje   = findViewById(R.id.imageButtonDivide);
        btednakvo   = findViewById(R.id.imageButtonEqual);
    }


    private void setComponents() {

        //Set REZ to Start ""
        rez.setText(" ");

        //Numbers
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(1);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(2);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(3);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(4);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(5);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(6);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(7);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(8);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(9);
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presNumber(0);
            }
        });

        //Operations
        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacija();
                plus = true;
            }
        });

        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacija();
                minus = true;
            }
        });

        btmnozenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacija();
                mnozenje = true;
            }
        });

        btdelenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacija();
                delenje = true;
            }
        });

        //Ednakvo
        btednakvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (runningNumber != "" && ednakvo == false){
                brojB = Integer.parseInt(runningNumber);

                if (plus == true){
                    brojC   = brojA + brojB;
                    plus    = false;
                    ednakvo = true;
                }

                if (minus == true){
                    brojC   = brojA - brojB;
                    minus   = false;
                    ednakvo = true;
                }

                if (mnozenje == true){
                    brojC   = brojA * brojB;
                    minus   = false;
                    ednakvo = true;
                }

                if (delenje == true){
                    brojC   = brojA / brojB;
                    minus   = false;
                    ednakvo = true;
                }

                runningNumber = String.valueOf(brojC);
                rez.setText(runningNumber);
                }
            else {
                Toast.makeText(MainActivity.this, "Vnesi Broj / Operacija", Toast.LENGTH_SHORT).show();
            }
            }
        });

        // CLEAR -- Brisenje -- Reset
        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                runningNumber = "";
                rez.setText("");

                brojA = 0;
                brojB = 0;
                brojC = 0;

                 plus       = false;
                 minus      = false;
                 mnozenje   = false;
                 delenje    = false;
                 ednakvo    = false;

                Toast.makeText(MainActivity.this, "CLEAR", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // Metod Vnes BROJ
    private void presNumber(int number) {
        if (ednakvo == true){
            Toast.makeText(this, "Vnesi Operacija", Toast.LENGTH_SHORT).show();
        }
        else{
            runningNumber += String.valueOf(number);
            rez.setText(runningNumber);
        }
    }


    // Metod Operacii
    private void operacija (){
        if(runningNumber != ""){
            brojA = Integer.parseInt(runningNumber);
            runningNumber = "";
            rez.setText("");
            ednakvo = false;
        }
        else {
            Toast.makeText(MainActivity.this, "Vnesi Broj", Toast.LENGTH_SHORT).show();
        }
    }

}
