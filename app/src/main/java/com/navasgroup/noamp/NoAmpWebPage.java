package com.navasgroup.noamp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class NoAmpWebPage extends Activity {
    private static final String TAG = "NoAMP";
    // regex to match Google AMP URL prefix
    private static final String AMP = "^http(s)?://(www\\.)?google.com/amp/(s/)?";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);  // get URL
        Log.i(TAG, "EXTRA_TEXT: \"" + sharedText + "\"");
        if (sharedText != null) {
            String newText = convertAMP(sharedText);

            // Show a Toast with the converted URL
            Toast.makeText(this, "NoAMP: " + newText, Toast.LENGTH_LONG).show();

            // parse and launch URL
            Log.i(TAG, "non-AMP: \"" + newText + "\"");
            Uri url = Uri.parse(newText);
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.w(TAG, "Failed to start web browser activity!");
                Toast.makeText(this, "Please install a web browser", Toast.LENGTH_LONG).show();
            }
        }
        finish();   // i'm done
    }

    // CONVERT AMP URL INTO NON-AMP URL
    static public String convertAMP(String url) {
        // 1. Handle Google AMP cache URLs
        String fix = url.replaceFirst(AMP, "http://");

        // 2. Remove all '/amp/' segments in the path
        fix = fix.replaceAll("/amp/", "/");

        // 3. Remove trailing '/amp' or '/amp/' at the end of the path
        fix = fix.replaceAll("/amp/?$", "/");

        // 4. Optionally, remove AMP query parameters (e.g., ?amp=1)
        fix = fix.replaceFirst("[?&]amp=1", "");

        // Decode the URL
        String dec = Uri.decode(fix);
        return dec;
    }
}
