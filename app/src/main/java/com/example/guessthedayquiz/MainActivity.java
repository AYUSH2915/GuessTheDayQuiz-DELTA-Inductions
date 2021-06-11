package com.example.guessthedayquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    View view;
    Vibrator vibrator1;
    Vibrator vibrator2;
    Vibrator vibrator3;
    Vibrator vibrator4;
    private TextView textView;
    private  TextView textView1;
    Random random = new Random();
    int a = random.nextInt(32);
    Random random1 = new Random();
    int c = random1.nextInt(12);
    Random random2 = new Random();
    int r = random2.nextInt(7);
    Random random3 = new Random();
    int f = random3.nextInt(7);
    Random random4 = new Random();
    int t = random4.nextInt(7);
    private String str = "";
    private int scr = 0;
    private int ct = 0;
    int a1 = 1;
    String STR2 = " ";
    String STR = "";
    int x = 0;
    String n="";
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int d = 1;
        if (a == 0) {
            a = 1;

        }
        if (c == 0) {
            STR = "jan";
            d = a;
        }
        if (c == 1) {
            STR = "feb";
            if ((a == 29) || (a == 30) || (a == 31)) {
                a = a - 3;
            }
            d = 31 + a;
        }
        if (c == 2) {
            STR = "march";
            d = 31 + 28 + a;
        }
        if (c == 3) {
            STR = "april";
            if (a == 31) {
                a = a - 1;
            }
            d = 31 + 28 + 31 + a;
        }
        if (c == 4) {
            STR = "may";
            d = 31 + 28 + 31 + 30 + a;
        }
        if (c == 5) {
            STR = "june";
            if (a == 31) {
                a = a - 1;
            }
            d = 31 + 28 + 31 + 30 + 31 + a;
        }
        if (c == 6) {
            STR = "july";
            d = 31 + 28 + 31 + 30 + 31 + 30 + a;
        }
        if (c == 7) {
            STR = "aug";
            d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + a;
        }
        if (c == 8) {
            STR = "sept";
            if (a == 31) {
                a = a - 1;
            }
            d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + a;
        }
        if (c == 9) {
            STR = "oct";
            d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + a;
        }
        if (c == 10) {
            STR = "nov";
            if (a == 31) {
                a = a - 1;
            }
            d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + a;
        }
        if (c == 11) {
            STR = "dec";
            d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + a;
        }
        int h = d % 7;
        if (h == 0) {
            str = "SUNDAY";
        }
        if (h == 1) {
            str = "MONDAY";
        }
        if (h == 2) {
            str = "TUESDAY";
        }
        if (h == 3) {
            str = "WEDNESDAY";
        }
        if (h == 4) {
            str = "THURSDAY";
        }
        if (h == 5) {
            str = "FRIDAY";
        }
        if (h == 6) {
            str = "SATURDAY";
        }


        textView = findViewById(R.id.textView);
        textView.setText("DATE =" + a + " " + STR + "   ");
        String arr[] = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        vibrator1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator2 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator3 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator4 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (r == f || r == t || f == t) {
            r = 3;
            f = 4;
            t = 2;
        }

        button1.setText(arr[r]);
        button2.setText(arr[f]);
        button3.setText(arr[t]);
        button4.setText("NONE");

        button1.setOnClickListener(new View.OnClickListener() {
            String st1 = "";

            @Override
            public void onClick(View v) {
                st1 = arr[r];
                if (st1 == str) {
                    if (x == a1 && STR2 == n) {
                        bob();
                    }
                    if ((x != a1) || (n != STR2)) {
                        scr = scr + 1;
                        ct = ct + 1;
                        vibrator1.vibrate(500);
                        green();
                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    if((x == a1) && (n == STR2)){
                        bob();
                    }
                    if((x != a1) || (n != STR2)) {
                        red();
                        scr = scr - 1;
                        count = count + 1;
                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                        text();
                    }

                }
                STR2 = n;
                a1 = x;

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            String st1 = "";

            @Override
            public void onClick(View v) {
                st1 = arr[f];

                if (str == st1) {
                    if (x == a1 && STR2 == n) {
                        bob();
                    }
                    if ((x != a1) || (n != STR2)) {
                        scr = scr + 1;
                        ct = ct + 1;
                        vibrator2.vibrate(500);
                        green();

                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    if((x == a1) && (n == STR2)){
                        bob();
                    }
                    if((x != a1) || (n != STR2)) {
                        red();
                        scr = scr - 1;
                        count = count + 1;
                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                        text();
                    }
                }
                STR2 = n;
                a1 = x;


            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            String st1 = "";

            @Override
            public void onClick(View v) {
                st1 = arr[t];
                if (st1 == str) {
                    if (x == a1 && STR2 == n) {
                        bob();
                    }
                    if ((x != a1) || (n != STR2)) {
                        scr = scr + 1;
                        ct = ct + 1;
                        vibrator3.vibrate(500);
                        green();
                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    if((x == a1) && (n == STR2)){
                        bob();
                    }
                    if((x != a1) || (n != STR2)) {
                        red();
                        scr = scr - 1;
                        count = count + 1;
                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                        text();
                    }

                }
                STR2 = n;
                a1 = x;


            }

        });
        button4.setOnClickListener(new View.OnClickListener() {
            String st1 = "";

            @Override
            public void onClick(View v) {
                st1 = "NONE";
                if ((ct == 0) && (arr[t] != str) && (arr[f] != str) && (arr[r] != str)) {
                    if ((x == a1) && (n == STR2)) {
                        bob();
                    }
                    if ((x != a1) || (n != STR2)) {
                        scr = scr + 1;
                        vibrator4.vibrate(500);
                        green();

                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    if((x == a1) && (n == STR2)){
                        bob();
                    }
                    if((x != a1) || (n != STR2)) {
                        red();
                        scr = scr - 1;
                        count = count + 1;
                        textView = findViewById(R.id.textView3);
                        textView.setText("Your Score Is = " + scr);
                        Toast.makeText(MainActivity.this, "INCORRECT ANSWER", Toast.LENGTH_SHORT).show();
                        text();
                    }
                    STR2 = n;
                    a1 = x;


                }


            }

        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = a1;
                n = STR2;
                white();
                Random random = new Random();
                a1 = random.nextInt(32);
                Random random1 = new Random();
                int c1 = random1.nextInt(12);
                Random random2 = new Random();
                int r1 = random2.nextInt(7);
                Random random3 = new Random();
                int f1 = random3.nextInt(7);
                Random random4 = new Random();
                int t1 = random4.nextInt(7);
                ct = 0;
                int d2 = 1;
                if (a1 == 0) {
                    a1 = 1;

                }
                if (c1 == 0) {
                    STR2 = "jan";
                    d2 = a;
                }
                if (c1 == 1) {
                    STR2 = "feb";
                    if ((a == 29) || (a == 30) || (a == 31)) {
                        a = a - 3;
                    }
                    d2 = 31 + a1;
                }
                if (c1 == 2) {
                    STR2 = "march";
                    d2 = 31 + 28 + a1;
                }
                if (c1 == 3) {
                    STR2 = "april";
                    if (a1 == 31) {
                        a1 = a1 - 1;
                    }
                    d2 = 31 + 28 + 31 + a1;
                }
                if (c1 == 4) {
                    STR2 = "may";
                    d2 = 31 + 28 + 31 + 30 + a1;
                }
                if (c1 == 5) {
                    STR2 = "june";
                    if (a1 == 31) {
                        a1 = a1 - 1;
                    }
                    d2 = 31 + 28 + 31 + 30 + 31 + a1;
                }
                if (c1 == 6) {
                    STR2 = "july";
                    d2 = 31 + 28 + 31 + 30 + 31 + 30 + a1;
                }
                if (c1 == 7) {
                    STR2 = "aug";
                    d2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + a1;
                }
                if (c1 == 8) {
                    STR2 = "sept";
                    if (a1 == 31) {
                        a1 = a1 - 1;
                    }
                    d2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + a1;
                }
                if (c1 == 9) {
                    STR2 = "oct";
                    d2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + a1;
                }
                if (c1 == 10) {
                    STR2 = "nov";
                    if (a1 == 31) {
                        a1 = a1 - 1;
                    }
                    d2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + a1;
                }
                if (c1 == 11) {
                    STR2 = "dec";
                    d2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + a1;
                }
                int h1 = d2 % 7;
                if (h1 == 0) {
                    str = "SUNDAY";
                }
                if (h1 == 1) {
                    str = "MONDAY";
                }
                if (h1 == 2) {
                    str = "TUESDAY";
                }
                if (h1 == 3) {
                    str = "WEDNESDAY";
                }
                if (h1 == 4) {
                    str = "THURSDAY";
                }
                if (h1 == 5) {
                    str = "FRIDAY";
                }
                if (h1 == 6) {
                    str = "SATURDAY";
                }


                textView = findViewById(R.id.textView);
                textView.setText("date =" + a1 + " " + STR2 + "   ");
                button1 = findViewById(R.id.button1);
                button2 = findViewById(R.id.button2);
                button3 = findViewById(R.id.button3);
                button4 = findViewById(R.id.button4);
                if (r1 == f1 || r1 == t1 || f1 == t1) {
                    r1 = 3;
                    f1 = 6;
                    t1 = 2;
                }
                r=r1;
                f=f1;
                t=t1;


                button1.setText(arr[r]);
                button2.setText(arr[f]);
                button3.setText(arr[t]);
                button4.setText("NONE");


            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        String g = Integer.toString(scr);
        intent.putExtra("key1234", g);
        startActivity(intent);
    }

    public void bob() {
        Toast.makeText(this, "Press Next Question", Toast.LENGTH_SHORT).show();
    }

    public void green() {
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.green);
    }

    public void red() {
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.red);
    }

    public void white() {
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.purple);
    }
    public void text()
    {
      if(count==3)
      {
          openActivity2();
      }
      if(count==2)
      {
        textView1=findViewById(R.id.textView7);
        textView1.setText("LIVES REMAINING:💚");
      }
      if(count==1)
      {
          textView1=findViewById(R.id.textView7);
          textView1.setText("LIVES REMAINING:💚💚");

      }
    }
}









