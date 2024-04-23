package com.example.phonedaitle;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initVIews();
        initListener();


    }

    private void initVIews() {

        textView = findViewById(R.id.info);
        button = findViewById(R.id.button);
    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = getHardwareAndSoftware();
                textView.setText(info);
            }
        });
    }

    private String getHardwareAndSoftware() {
        return "SERIAL : " + " " + Build.SERIAL + "\n" +
                "MODEL : " + " " + Build.MODEL + "\n" +
                "ID : " + " " + Build.ID + "\n" +
                "MANUFACTURE : " + " " + Build.MANUFACTURER + "\n" +
                "BRAND : " + " " + Build.BRAND + "\n" +
                "TYPE : " + " " + Build.TYPE + "\n" +
                "USER :" + " " + Build.USER + "\n" +
                "BASE : " + " " + Build.VERSION_CODES.BASE + "\n" +
                "INCREMENTAL : " + " " + Build.VERSION.INCREMENTAL + "\n" +
                "BOARD : " + " " + Build.BOARD + "\n" +
                "SDK : " + " " + Build.VERSION.SDK + "\n" +
                "HOST :" + " " + Build.HOST + "\n" +
                "FINGERPRINT : " + " " + Build.FINGERPRINT + "\n" +
                "VERSION CODE : " + " " + Build.VERSION.RELEASE;

    }

}