package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static android.util.Half.POSITIVE_INFINITY;
import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity{
     Button b9,b8,b7,b6,b5,b4,b3,b2,b1,b0,bA,bS,bM,bD,bE,bC;
     TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b9 = findViewById(R.id.button9);
        b8 = findViewById(R.id.button8);
        b7 = findViewById(R.id.button7);
        b6 = findViewById(R.id.button6);
        b5 = findViewById(R.id.button5);
        b4 = findViewById(R.id.button4);
        b3 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button2);
        b1 = findViewById(R.id.button1);
        b0 = findViewById(R.id.button0);
        bA = findViewById(R.id.buttonA);
        bS = findViewById(R.id.buttonS);
        bM = findViewById(R.id.buttonM);
        bD = findViewById(R.id.buttonD);
        bE = findViewById(R.id.buttonE);
        bC = findViewById(R.id.buttonC);
        t = findViewById(R.id.textView);
        t.setTextSize(COMPLEX_UNIT_DIP,30);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("9");
                 else
                     t.setText(t.getText()+"9");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("8");
                else
                t.setText(t.getText()+"8");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("7");
                else
                t.setText(t.getText()+"7");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("6");
                else
                t.setText(t.getText()+"6");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("5");
                else
                t.setText(t.getText()+"5");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("4");
                else
                t.setText(t.getText()+"4");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("3");
                else
                t.setText(t.getText()+"3");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("2");
                else
                t.setText(t.getText()+"2");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("1");
                else
                t.setText(t.getText()+"1");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("0");
                else
                t.setText(t.getText()+"0");
            }
        });
        bA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("+");
                else
                    t.setText(t.getText()+"+");
            }
        });
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("-");
                else
                    t.setText(t.getText()+"-");
            }
        });
        bM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("*");
                else
                    t.setText(t.getText()+"*");
            }
        });
        bD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t.getText().equals("0"))
                    t.setText("/");
                else
                    t.setText(t.getText()+"/");
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("0");
            }
        });
        bE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans = (String) t.getText();
                StringTokenizer tokenizer = new StringTokenizer(ans, "+*/-", false);
                StringTokenizer tokenizer2 = new StringTokenizer(ans, "1234567890", false);
                ArrayList<Integer> list = new ArrayList<Integer>();
                ArrayList<String> list2 = new ArrayList<String>();
                while(tokenizer.hasMoreTokens())
                    list.add(Integer.parseInt(tokenizer.nextToken()));
                while(tokenizer2.hasMoreTokens())
                    list2.add(tokenizer2.nextToken());
                double end = 0;
                if(list.size()>0)
                    end = list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        int x = i - 1;
                        if (list2.get(x).equals("+"))
                            end += list.get(i);
                        if (list2.get(x).equals("*"))
                            end *= list.get(i);
                        if (list2.get(x).equals("/")) {
                            try {
                                end /= list.get(i);
                            } catch (ArithmeticException e) {
                                t.setText("ERROR");
                            }
                        }
                        if (list2.get(x).equals("-"))
                            end -= list.get(i);
                    }
                if(t.getText().equals("+") || t.getText().equals("*") || t.getText().equals("/") || t.getText().equals("-"))
                        t.setText("ERROR");
                if(list.size() < list2.size() || list.size()==list2.size()) {
                    if (t.getText().equals("0"))
                        t.setText("0");
                    else
                        t.setText("ERROR");
                }
                for(int i =0;i<list2.size();i++)
                    if(list2.get(i).equals("*") || list2.get(i).equals("+") || list2.get(i).equals("/") || list2.get(i).equals("-"))
                        end+=0;
                    else
                        t.setText("ERROR");
                if(t.getText().equals("ERROR"))
                    t.setText("ERROR");
                else {
                        String s = Double.toString(end);
                        if(s.substring(s.length()-1).equals("0"))
                            t.setText(Integer.toString((int)end));
                        else
                            t.setText(s);

                }
            }
            });
        }
    }