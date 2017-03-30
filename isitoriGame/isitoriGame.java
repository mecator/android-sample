package com.example.tomoko.myoriginalaplication;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//メンバ変数
    EditText editText;
    TextView textView1,textView2;
    Button button;
    int num=0,count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=(TextView) findViewById(R.id.textview1);
        textView2=(TextView) findViewById(R.id.textview2);
       editText=(EditText) findViewById(R.id.edittext);
       button=(Button) findViewById(R.id.button4);
       button.setOnClickListener(buttonListener);
        findViewById(R.id.button1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button3).setOnClickListener(buttonNumberListener);
    }
    View.OnClickListener buttonNumberListener=new View.OnClickListener(){
       @Override
        public void onClick(View view){
            Button button=(Button) view;
            editText.setText(button.getText());
        }
    };
  View.OnClickListener buttonListener=new View.OnClickListener(){
    @Override
      public void onClick(View view) {
        Button goButton = (Button) view;

               int getNum = Integer.parseInt(editText.getText().toString());


               num = num + getNum;
               if (getNum == 1) {

                   textView1.setText(num + "");count = count + 1;
               } else if (getNum == 2) {
                   textView1.setText(num - 1 + "," + num);count = count + 1;
               } else {
                   textView1.setText(num - 2 + "," + (num - 1) + "," + num);count = count + 1;
               }

               if (count % 2 == 0) {
                   textView2.setText("player1");
               } else {
                   textView2.setText("player2");
               }
           if(num>20) {

               if (textView2.getText().equals("player1")) {
                   num=0;
                   count=0;
                   Toast toast=Toast.makeText(MainActivity.this,"player1 win!",Toast.LENGTH_LONG);
                   toast.show();
               } else {
                   num=0;
                   count=0;
                   Toast toast=Toast.makeText(MainActivity.this,"player2 win!",Toast.LENGTH_LONG);
                   toast.show();
               }
           }

    }
  };
}
