package com.paythepiper.paythepiper;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {

    Button but1,but2,but5,but10,rst;
    TextView rndm,tvresult;
    ConstraintLayout l1;


    Random r;
    int res;
    int otpt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but5 = (Button) findViewById(R.id.but5);
        but10 = (Button) findViewById(R.id.but10);
        rst = (Button) findViewById(R.id.rst);
        rndm = (TextView) findViewById(R.id.rndm);
        tvresult = (TextView) findViewById(R.id.tvresult);

        l1 = (ConstraintLayout) findViewById(R.id.layout);


        res = r.nextInt(100) + 1;
        rndm.setText("Payment to be Made: " + res);


        but1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        otpt += 1;
                                        tvresult.setText(Integer.toString(otpt));
                                        chck();
                                    }

                                }


        );


        but2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        otpt += 2;
                                        tvresult.setText(Integer.toString(otpt));
                                        chck();
                                    }

                                }


        );


        but5.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        otpt += 5;
                                        tvresult.setText(Integer.toString(otpt));
                                        chck();
                                    }

                                }


        );


        but10.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         otpt += 10;
                                         tvresult.setText(Integer.toString(otpt));
                                         chck();
                                     }

                                 }


        );


        rst.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       otpt = 0;
                                       tvresult.setText(Integer.toString(otpt));
                                       chck();
                                   }

                               }


        );


    }

        private void chck(){
        if(res==otpt)
        {l1.setBackgroundColor(Color.BLUE);
        congrats();}

        if(res<otpt) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("Payment exceeding Required pay!!")
                    .setCancelable(true);

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialogBuilder.show();

            otpt = 0;
            tvresult.setText(Integer.toString(otpt));

        }    }

    private void congrats() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Payment Done!!Try Again?")
                .setCancelable(false)
                .setPositiveButton("CONTINUE",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        })

                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialogBuilder.show();




    }






    }

