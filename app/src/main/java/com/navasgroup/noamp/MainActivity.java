package com.navasgroup.noamp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String README_URL = "https://github.com/JNavas2/NoAMP#readme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Close button: closes the activity ---
        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> finish());

        // --- Help button: opens the README in browser ---
        Button helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(README_URL));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "No browser found to open Help.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
