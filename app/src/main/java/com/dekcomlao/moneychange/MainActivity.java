package com.dekcomlao.moneychange;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText edtLak;
   private TextView tvType, tvResult;
   private RadioGroup rgRate;
   private Button btncal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializes ();
    }

    private void initializes() {
        edtLak = (EditText) findViewById(R.id.editLak);
        tvType = (TextView) findViewById(R.id.tvType);
        tvResult = (TextView) findViewById(R.id.tvResult);
        rgRate = (RadioGroup) findViewById(R.id.rqRate);
        btncal = (Button) findViewById(R.id.btnCal);

      btncal.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.N)
          @Override
          public void onClick(View view) {

              double valEdit = 0;
              double sum = 0;
              String strType = null;
              String strEdit = null;

              strEdit = edtLak.getText().toString();
              try {
                  valEdit = Double.parseDouble(strEdit);
              } catch (NumberFormatException e){

              }

              switch (rgRate.getCheckedRadioButtonId()){
                  case R.id.rdTHB:
                      double THB = 229.621;
                      sum = valEdit / THB;
                      strType = "THB";
                      break;
                  case R.id.rdUSD:
                      double USD = 8250.50;
                      sum = valEdit / USD;
                      strType = "USD";
                      break;
                  case R.id.rdCNY:
                      double CNY = 1186.02;
                      sum = valEdit / CNY;
                      strType = "CNY";
                      break;
                  case R.id.rdJPY:
                      double JPY = 70.1625;
                      sum = valEdit / JPY;
                      strType = "JPY";
                      break;
              }
              DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
              tvResult.setText(decimalFormat.format(sum)  + "");
              tvType.setText(strType);

          }
      });
    }
}
