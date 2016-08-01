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

public class case_three extends AppCompatActivity {
    private static Button getarea;
    private static EditText side1;
    private static EditText side2;
    private static EditText side3;
    private static EditText side4;
    private static EditText diagonal;
    private static EditText result;
    private static RelativeLayout rlayout3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_three);
        getarea();
        hidekeyboard3();

    }
    public void getarea(){
        getarea=(Button)findViewById(R.id.area_button2);

        side1=(EditText)findViewById(R.id.editText8);
        side2=(EditText)findViewById(R.id.editText9);
        side3=(EditText)findViewById(R.id.editText10);
        side4=(EditText)findViewById(R.id.editText11);
        diagonal=(EditText)findViewById(R.id.editText12);
        result= (EditText) findViewById(R.id.result3);

        getarea.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(side1.getText().length()==0||side2.getText().length()==0||side3.getText().length()==0||side4.getText().length()==0||diagonal.getText().length()==0){
                            Toast.makeText(case_three.this, "please enter the details of all sides", Toast.LENGTH_LONG).show();

                        }
                        else {

                            float a = Float.parseFloat(side1.getText().toString());

                            float b = Float.parseFloat(side2.getText().toString());
                            float c = Float.parseFloat(side3.getText().toString());
                            float d = Float.parseFloat(side4.getText().toString());
                            float e = Float.parseFloat(diagonal.getText().toString());
                            float s1 = (a + b + e) / 2;
                            float s2 = (c + d + e) / 2;
                            float f = s1 * (s1 - a) * (s1 - b) * (s1 - e);
                            float g = s2 * (s2 - c) * (s2 - d) * (s2 - e);
                            float area = (float)Math.sqrt(f) + (float)Math.sqrt(g);



                            if (result.getText().toString().equals("NaN")) {
                                Toast.makeText(case_three.this, "you have entered incorrect details", Toast.LENGTH_LONG).show();
                                result.setVisibility(View.INVISIBLE);

                            }
                            else{
                                result.setVisibility(View.VISIBLE);
                                String die=Double.toString(area);

                                result.setText(die);
                                Intent intent =new Intent(case_three.this , result.class);
                                intent.putExtra("myExtra",die);

                                startActivity(intent);

                            }
                        }






                    }
                }
        );




    }
    public void hidekeyboard3() {
        rlayout3 = (RelativeLayout) findViewById(R.id.screen_three);
        rlayout3.setOnClickListener(
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
