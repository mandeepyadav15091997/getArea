package in.mandy.getthearea;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class case_two extends AppCompatActivity {
    private static Button getarea;
    private static EditText side1;
    private static EditText side2;
    private static EditText side3;
    private static EditText side4;
    private static EditText result;
    private static RelativeLayout rlayout2;
    float d,a,b,c;
    float area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_two);
        getarea();
        hidekeyboard();
    }
    public void getarea(){
        getarea=(Button)findViewById(R.id.area_button2);

        side1=(EditText)findViewById(R.id.editText4);
        side2=(EditText)findViewById(R.id.editText5);
        side3=(EditText)findViewById(R.id.editText6);
        side4=(EditText)findViewById(R.id.editText7);
        result=(EditText)findViewById(R.id.result2);

        getarea.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(side1.getText().length()==0||side2.getText().length()==0||side3.getText().length()==0||side4.getText().length()==0){
                            Toast.makeText(case_two.this, "please enter the details of all sides", Toast.LENGTH_LONG).show();

                        }
                        else {

                         a=Float.valueOf(side1.getText().toString());
                         b=Float.valueOf(side2.getText().toString());
                        c=Float.valueOf(side3.getText().toString());
                        d=Float.valueOf(side4.getText().toString());


                        area=((a+c)/2*(b+d)/2);
                            String die=Float.toString(area);

                            result.setText(die);
                            Intent intent =new Intent(case_two.this , result.class);
                            intent.putExtra("myExtra",die);

                            startActivity(intent);
                        }

                    }
                }
        );




    }
    public void hidekeyboard() {
        rlayout2 = (RelativeLayout) findViewById(R.id.screen_two);
        rlayout2.setOnClickListener(
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
