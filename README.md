# NoAMP

**AMP**™ (Accelerated Mobile Pages) is a Google™ web component framework that alters Web content for mobile devices. 
The problem is that AMP can sometimes make Web pages less usable.   
   
**NoAMP** is an Android app that lets you open the original, non-AMP version of a web page, 
bypassing the AMP framework for a standard browsing experience, in many (but not all) cases.   

## Features

- **Bypass AMP:** Open the original, non-AMP version of a web page when viewing AMP links.
- **Easy to Use:** Share an AMP page from your browser to NoAMP, which automatically opens the non-AMP version in your default browser.
- **Works with Most AMP Links:** Especially effective for AMP pages that Google has converted on the fly from non-AMP hosts (e.g., `mobile.nytimes.com`, `www.foxnews.com`).
- **No Data Collection:** NoAMP does not collect or share any user data.
- **Open Source:** View the source code [here](https://github.com/JNavas2/NoAMP).

## How It Works

1. Install from **[Google Play](https://play.google.com/store/apps/details?id=com.navasgroup.noamp&hl=en_US)**.
2. **View an AMP page** in your browser (e.g., Chrome).
3. Tap the **Share** button and select **NoAMP**.
4. NoAMP converts the AMP URL to its non-AMP equivalent and opens it in your default browser, showing a toast notification with the converted URL.

## Example

- **AMP URL:** `https://www.aljazeera.com/amp/news/2025/7/2/can-trump-strip-musk-and-mamdani-of-their-us-citizenship`   
- **Converted URL** `https://www.aljazeera.com/news/2025/7/2/can-trump-strip-musk-and-mamdani-of-their-us-citizenship`   
NoAMP removes the `/amp/` segment from the URL, allowing you to easily view the original, full-featured web page.

## Limitations

- Only works with AMP pages that have a non-AMP equivalent.
- Hosted AMP pages (e.g., `amp.example.com`) are not supported.
- Requires a web browser installed on your device.
- Android 5.0 (Lollipop) or higher

## Feedback & Support

For support, bug reports, or feature requests, please open an **[Issue](https://github.com/JNavas2/NoAMP/issues)**.

## License

This project is licensed under the **[MIT License](https://github.com/JNavas2/NoAMP/blob/main/LICENSE.md)**.

## Trademarks

- **Google** and **AMP** are trademarks of Google LLC.  
- NoAMP is not affiliated with or endorsed by Google or the AMP project.
