package in.mandy.getthearea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class case_one extends AppCompatActivity {
    private static Button getarea;
    private static EditText side1;
    private static EditText side2;
    private static EditText side3;
    private static EditText result;
    private static RelativeLayout rlayout1;
    float s;
    float area;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_one);
       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetArea();
        hidekeyboard();
    }
    public void GetArea(){
        getarea=(Button)findViewById(R.id.button_area1);

        side1=(EditText)findViewById(R.id.editText);
        side2=(EditText)findViewById(R.id.editText2);
        side3=(EditText)findViewById(R.id.editText3);
        result=(EditText)findViewById(R.id.result);

        getarea.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(side1.getText().length()==0||side2.getText().length()==0||side3.getText().length()==0){
                            Toast.makeText(case_one.this, "please enter the details of all sides", Toast.LENGTH_LONG).show();

                        }
                        else {
                        float a=Float.valueOf(side1.getText().toString());
                        float b=Float.valueOf(side2.getText().toString());
                        float c=Float.valueOf(side3.getText().toString());

                        s=(a+b+c)/2;
                        float d=(s*(s-a)*(s-b)*(s-c));
                         area= (float) Math.sqrt( d);
                            String die=Float.toString(area);

                            result.setText(die);



                            if (result.getText().toString().equals("NaN")) {
                                Toast.makeText(case_one.this, "you have entered incorrect details", Toast.LENGTH_LONG).show();


                            }
                            else{

                                Intent intent =new Intent(case_one.this , result.class);
                                intent.putExtra("myExtra",die);

                                startActivity(intent);

                            }

                    }


                    }
                }
        );



    }
    public void hidekeyboard() {
         rlayout1 = (RelativeLayout) findViewById(R.id.screen_one);
        rlayout1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
        );

    }
}
