package com.sm.shahriaz.smartmenu;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button btnCategory = (Button)findViewById(R.id.categoryCall);
            Intent intent = new Intent(this, FoodCategoryActivity.class);
            startActivity(intent);
            btnCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), FoodCategoryActivity.class);
                    v.getContext().startActivity(intent);

                }
            });

            Button vSearch = (Button)findViewById(R.id.voiceCall);
            Intent intent1 = new Intent(this, VoiceSearch.class);
            startActivity(intent1);




    }

}
