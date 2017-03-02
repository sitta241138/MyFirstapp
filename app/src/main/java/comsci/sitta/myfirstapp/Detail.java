package comsci.sitta.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initial View ผูกหน้า UI กับ JAVA
        TextView titailTextView = (TextView) findViewById(R.id.txtTitleDetail);
        TextView detailTextView = (TextView) findViewById(R.id.txtDetailScroll);
        ImageView imageView = (ImageView) findViewById(R.id.imvImageDetail);
        Button button = (Button) findViewById(R.id.btnBack);

        //Show Data from MainActivty มาแสดงผลใน Detail
        titailTextView.setText(getIntent().getStringExtra("Titel"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));
        imageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.traffic_01));
    } // End Methot onCreate onCreate is all layout in activity_detail.xml

    public void clickback(View view){
        finish();
    }// End methot cliackback

}// End class
