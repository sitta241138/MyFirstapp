package comsci.sitta.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01,R.drawable.traffic_02,
            R.drawable.traffic_03,R.drawable.traffic_04,R.drawable.traffic_05,
            R.drawable.traffic_06,R.drawable.traffic_07,R.drawable.traffic_08,
            R.drawable.traffic_09,R.drawable.traffic_10,R.drawable.traffic_11,
            R.drawable.traffic_12,R.drawable.traffic_13,R.drawable.traffic_14,
            R.drawable.traffic_15,R.drawable.traffic_16,R.drawable.traffic_17,
            R.drawable.traffic_18,R.drawable.traffic_19,R.drawable.traffic_20};

    private String[] titelStrings,deitailStrings, shortStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intital View ผูกตัวแปรกับไอดีของ view
        listView = (ListView) findViewById(R.id.livTraffic);

        // get value .xml File by My_content.xml to display
        titelStrings = getResources().getStringArray(R.array.titel);
        deitailStrings = getResources().getStringArray(R.array.detail);

        // subString data เพื่อตัดข้อความ ให้สั้นตามที่ต้องการ

        shortStrings = new String[deitailStrings.length];
        for(int i=0;i<deitailStrings.length;i++){
            shortStrings[i] = deitailStrings[i].substring(0,29)+"..."; // start cut array String 0 to 30 char
        } // end for

        //create Listview
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,ints,titelStrings,shortStrings);
        listView.setAdapter(myAdapter);

        //active when click List View ลิ้งไปหน้า detail เมื่อเลือก item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // เมื่อมีการคลิกข้อมูลที่ตำแหน่งใด จะเก็บข้อมูลจากการคลิก
                Intent intent = new Intent(MainActivity.this,Detail.class); // สร้างค่าตัวแปรและส่งไปให้ class MainActivity
                intent.putExtra("Titel",titelStrings[position]);
                intent.putExtra("Detail",deitailStrings[position]);
                intent.putExtra("Image",ints[position]);
                startActivity(intent);
            }
        });

    }// main methot onCreate



    public void onClickMoreInfo(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW); // ประกาศค่าตัวแปร
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);
    }// main methot onClickMoreInfo

    public void onClickAboutme(View view){
        Intent intent = new Intent(MainActivity.this,AboutMe.class);
        startActivity(intent);
    }
}// main class


