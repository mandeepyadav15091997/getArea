package in.mandy.getthearea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class result extends AppCompatActivity {
    private static Button gotohome;
    private static EditText metersq;
    private static EditText bigah;
    private static EditText acres;
    private static EditText hectare;
    private static EditText inchsq;
    private static EditText feetsq;
    private static EditText yardsq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        metersq=(EditText) findViewById(R.id.editText13);
        bigah=(EditText) findViewById(R.id.editText14);
        acres=(EditText) findViewById(R.id.editText15);
        hectare=(EditText) findViewById(R.id.editText16);
        inchsq=(EditText) findViewById(R.id.editText17);
        feetsq=(EditText) findViewById(R.id.editText18);
        yardsq=(EditText) findViewById(R.id.editText19);







        Intent j=getIntent();
        String res=j.getStringExtra("myExtra");
        Log.d("man",res);
        metersq.setText(res);



       String mtsq=metersq.getText().toString();
        double d1=Double.parseDouble(mtsq);
        double d2=d1/843;
        double d3=d1*0.00024703;
        double d4=d1*0.0001;
        double d5=d1*1550.0031;
        double d6=d1*10.76391042;
        double d7=d1*1.19590046;
        bigah.setText(Double.toString(d2));
        acres.setText(Double.toString(d3));
        hectare.setText(Double.toString(d4));
        inchsq.setText(Double.toString(d5));
        feetsq.setText(Double.toString(d6));
        yardsq.setText(Double.toString(d7));


                gotohomeclick();
    }
    public void gotohomeclick(){
        gotohome=(Button) findViewById(R.id.gootohome_button);
        gotohome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent("in.mandy.getthearea.MainActivity");
                        startActivity(i);
                    }
                }
        );
    }

}
