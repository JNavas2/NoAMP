package com.navasgroup.noamp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class NoAmpWebPage extends Activity {
    private static final String TAG = "NoAMP";
    // regex to match Google AMP URL prefix
    private static final String AMP = "^http(s)?://(www\\.)?google.com/amp/(s/)?";
    private static final String URBANDICT = "^http(s)?://(www\\.)?urbandictionary.com/(.)+";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);  // get URL
        Log.i(TAG, "EXTRA_TEXT: \"" + sharedText + "\"");
        if (sharedText != null) {
            // convert AMP to non-AMP
            sharedText = sharedText.replaceFirst(AMP, "http://");
            // decode then selective encode for websites that don't parse encoded properly
            sharedText = Uri.decode(sharedText);// decode
            sharedText = Uri.encode(sharedText, "://?=&");
            // workaround for urbandictionary.com
            if (sharedText.matches(URBANDICT)) {
                sharedText = sharedText.replaceFirst("&amp=true$", "");     // strip AMP parameter
            }
            // parse and launch URL
            Log.i(TAG, "non-AMP: \"" + sharedText + "\"");
            Uri url = Uri.parse(sharedText);
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.w(TAG, "Failed to start web browser activity!");
                Toast.makeText(this, "Please install a web browser",  Toast.LENGTH_LONG).show();
            }
        }
        finish();   // i'm done
    }
}
