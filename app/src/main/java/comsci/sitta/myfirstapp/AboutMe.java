package comsci.sitta.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }


    public void onFacebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW); // ประกาศค่าตัวแปร
        intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100001920246976"));
        startActivity(intent);
    }// main methot onClickMoreInfo

    public void btnBackAbout(View view){
        finish();
    }
}
