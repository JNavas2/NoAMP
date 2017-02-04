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
//    private static final String URBANDICT = "^http(s)?://(www\\.)?urbandictionary.com/(.)+";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);  // get URL
        Log.i(TAG, "EXTRA_TEXT: \"" + sharedText + "\"");
        if (sharedText != null) {
			String newText = convertAMP(sharedText);
            // parse and launch URL
            Log.i(TAG, "non-AMP: \"" + newText + "\"");
            Uri url = Uri.parse(newText);
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

    // CONVERT AMP URL INTO NON-AMP URL (ALWAYS REGRESSION TEST!)
    static public String convertAMP(String url) {
        // convert AMP to non-AMP
		String fix = url.replaceFirst(AMP, "http://");
		// decode then selective encode for websites that don't parse encoded properly
		String dec = Uri.decode(fix);// decode
// workaround for urbandictionary.com
// 		String enc = Uri.encode(dec, ":/?=&");
//		if (enc.matches(URBANDICT)) {
//			enc = enc.replaceFirst("&amp=true$", "");     // strip AMP parameter
//		}
		return dec;
    }
}
