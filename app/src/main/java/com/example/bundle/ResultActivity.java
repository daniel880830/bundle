package com.example.bundle;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout);
        tvResult = (TextView)findViewById(R.id.tvResult);
        showResults();
    }

    private void showResults(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int data = bundle.getInt("data");
        int algorithm = bundle.getInt("algorithm");
        int sum = programming + data + algorithm;
        double average = sum/3.0;
        String text = "programming = "+ programming +
                "\ndatastructure = " + data +
                "\nalgorithm = "+ algorithm +
                "\nsum = " + sum +
                "\naverage = " + nf.format(average);
        tvResult.setText(text);
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic =0;

        if(average ==100){
            message ="100";
            title="Pass";
            pic = R.drawable.pass;
        }else if(average>=80){
            message="Congratulation!";
            title="Pass";
            pic = R.drawable.pass;
        }else if(average>=60){
            message="so close";
            title="Pass";
            pic = R.drawable.pass;
        }else if(average<60){
            message="bad";
            title="no Pass";
            pic = R.drawable.nopass;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
    }

    public void onBackClick(View view){
        finish();
    }
}
