package in.mandy.getthearea;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private static Button ok;
    private static RadioButton radioButton;
    private static RadioButton radioButton1;
    private static RadioButton radioButton2;
    private static RadioButton radioButton3;
    private static RadioGroup radioGroup;
    int backButtonCount=1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okclick();
        onBackPressed();

    }
    public void okclick(){
        ok=(Button)findViewById(R.id.oksides);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButton1=(RadioButton) findViewById(R.id.side3);
        radioButton2=(RadioButton) findViewById(R.id.side4);
        radioButton3=(RadioButton) findViewById(R.id.side3wiith1);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (radioButton1.isChecked()){
                    //Toast.makeText(MainActivity.this,"1",Toast.LENGTH_LONG).show();
                    Intent i=new Intent("in.mandy.getthearea.case_one");
                    startActivity(i);

                }
                if (radioButton2.isChecked()){
                    //Toast.makeText(MainActivity.this,"2",Toast.LENGTH_LONG).show();
                    Intent i=new Intent("in.mandy.getthearea.case_two");
                    startActivity(i);

                }
                if (radioButton3.isChecked()){
                    //Toast.makeText(MainActivity.this,"3",Toast.LENGTH_LONG).show();
                    Intent i=new Intent("in.mandy.getthearea.case_three");
                    startActivity(i);

                }


            }
        });
    }
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            backButtonCount--;
        }
        else
        {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No", null).show();
        }
    }



}
