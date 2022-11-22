package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,startAgain;
    ImageView exitBtn;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag =0;
    int count=0;
    int notify =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn1=findViewById(R.id.btn1);
         btn2=findViewById(R.id.btn2);
         btn3=findViewById(R.id.btn3);
         btn4=findViewById(R.id.btn4);
         btn5=findViewById(R.id.btn5);
         btn6=findViewById(R.id.btn6);
         btn7=findViewById(R.id.btn7);
         btn8=findViewById(R.id.btn8);
         btn9=findViewById(R.id.btn9);
         startAgain=findViewById(R.id.startAgain);
         exitBtn=findViewById(R.id.exit_button);

         startAgain.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 refresh();
             }
         });

         exitBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (notify == 0) {
                     Toast.makeText(MainActivity.this, "Please complete the game", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                             .setTitle("Close App")
                             .setIcon(R.drawable.exit_button)
                             .setCancelable(true)
                             .setMessage("Are your sure want to exit?")
                             .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {
                                     ActivityCompat.finishAffinity(MainActivity.this);
                                 }
                             })
                             .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialogInterface, int i) {
                                     Toast.makeText(MainActivity.this, "Great decision!!", Toast.LENGTH_SHORT).show();
                                 }
                             });

                     builder.show();
                 }


             }
         });


    }

    public  void check(View view){
        Button currentBtn = (Button) view;
        if(currentBtn.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                currentBtn.setText("X");
                flag = 1;
            } else {
                currentBtn.setText("O");
                flag = 0;
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();


                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b1, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b4, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b7, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b1, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b2, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b3, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b1, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    disable();
                    Toast.makeText(this, "The winner is : " + b3, Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                } else if(count==9){
                    disable();
                    Toast.makeText(this, "It seems like a draw , play again to settle", Toast.LENGTH_LONG).show();
                    startAgain.setEnabled(true);
                    notify=1;

                }
            }

        }

    }

    public void disable(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);


    }

    public void refresh(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);


    }

}