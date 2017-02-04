package com.navasgroup.noamp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class NoAmpWebPageTest {

	// REGRESSION TEST OF SAMPLE AMP URLS
	@Test
	public void regressionTest() throws Exception
	{
		// test URLs, AMP followed by noAMP
		String[][] testAMP = {
			{"https://www.google.com/amp/mobile.nytimes.com/2017/01/23/opinion/russia-is-a-terrible-ally-against-terrorism.amp.html?client=ms-android-google",
				"http://mobile.nytimes.com/2017/01/23/opinion/russia-is-a-terrible-ally-against-terrorism.amp.html?client=ms-android-google"},
			{"https://www.google.com/amp/mobile.reuters.com/article/amp/idUSKBN1570VJ?client=ms-android-google",
				"http://mobile.reuters.com/article/amp/idUSKBN1570VJ?client=ms-android-google"},
			{"https://www.google.com/amp/s/amp.theguardian.com/world/2017/jan/22/moscow-trump-inauguration-inspires-russian-new-hopes-era?client=ms-android-google",
				"http://amp.theguardian.com/world/2017/jan/22/moscow-trump-inauguration-inspires-russian-new-hopes-era?client=ms-android-google"},
			{"https://www.google.com/amp/s/www.dailystar.co.uk/news/latest-news/581235/russia-us-syria-coalition-air-strikes-trump-putin-alliance/amp?client=ms-android-google",
				"http://www.dailystar.co.uk/news/latest-news/581235/russia-us-syria-coalition-air-strikes-trump-putin-alliance/amp?client=ms-android-google"},
			{"https://www.google.com/amp/s/www.rt.com/document/5885b335c46188cc078b4572/amp?client=ms-android-google",
				"http://www.rt.com/document/5885b335c46188cc078b4572/amp?client=ms-android-google"},
			{"https://www.google.com/amp/s/www.thestar.com/amp/news/world/2017/01/22/russia-expected-to-move-closer-to-decriminalizing-domestic-violence.html?client=ms-android-google",
				"http://www.thestar.com/amp/news/world/2017/01/22/russia-expected-to-move-closer-to-decriminalizing-domestic-violence.html?client=ms-android-google"},
			{"https://www.google.com/amp/s/www.urbandictionary.com/define.php%3Fterm%3Dwalk%2520it%2520back%26amp%3Dtrue?client=ms-android-google",
				"http://www.urbandictionary.com/define.php?term=walk%20it%20back&amp=true?client=ms-android-google"},
			{"https://www.google.com/amp/s/www.yahoo.com/amphtml/sports/news/curry-leads-warriors-suns-top-044445387.html?client=ms-android-google",
				"http://www.yahoo.com/amphtml/sports/news/curry-leads-warriors-suns-top-044445387.html?client=ms-android-google"},
			{"https://www.google.com/amp/thehill.com/policy/defense/315582-flynns-communications-with-russia-investigated-report%3Famp?client=ms-android-google",
				"http://thehill.com/policy/defense/315582-flynns-communications-with-russia-investigated-report?amp?client=ms-android-google"},
			{"https://www.google.com/amp/www.breitbart.com/video/2017/01/23/warriors-steve-kerr-mocks-spicer-alternative-facts/amp/?client=ms-android-google",
				"http://www.breitbart.com/video/2017/01/23/warriors-steve-kerr-mocks-spicer-alternative-facts/amp/?client=ms-android-google"},
			{"https://www.google.com/amp/www.cbssports.com/nba/news/warriors-vs-heat-how-to-watch-live-stream-tv-matchup-line-odds-picks/amp/?client=ms-android-google",
				"http://www.cbssports.com/nba/news/warriors-vs-heat-how-to-watch-live-stream-tv-matchup-line-odds-picks/amp/?client=ms-android-google"},
			{"https://www.google.com/amp/www.foxnews.com/politics/2017/01/23/counterintelligence-officials-probe-flynns-links-to-russia.amp.html?client=ms-android-google",
				"http://www.foxnews.com/politics/2017/01/23/counterintelligence-officials-probe-flynns-links-to-russia.amp.html?client=ms-android-google"},
			{"https://www.google.com/amp/www.goldenstateofmind.com/platform/amp/2017/1/23/14354394/nba-2017-golden-state-warriors-vs-miami-heat-preview?client=ms-android-google",
				"http://www.goldenstateofmind.com/platform/amp/2017/1/23/14354394/nba-2017-golden-state-warriors-vs-miami-heat-preview?client=ms-android-google"},
			{"https://www.google.com/amp/www.ibtimes.com/russia-trump-ties-senators-introduce-bipartisan-bill-stall-presidents-plan-cancel-2479362%3Famp%3D1?client=ms-android-google",
				"http://www.ibtimes.com/russia-trump-ties-senators-introduce-bipartisan-bill-stall-presidents-plan-cancel-2479362?amp=1?client=ms-android-google"},
			{"https://www.google.com/amp/www.independent.co.uk/news/world/middle-east/russia-military-presence-naval-warships-airbase-lease-tartous-latakia-syria-vladimir-putin-bashar-al-a7541771.html%3Famp?client=ms-android-google",
				"http://www.independent.co.uk/news/world/middle-east/russia-military-presence-naval-warships-airbase-lease-tartous-latakia-syria-vladimir-putin-bashar-al-a7541771.html?amp?client=ms-android-google"},
			{"https://www.google.com/amp/www.mercurynews.com/2017/01/22/steve-kerr-roasts-white-house-press-secretary-sean-spicer-in-postgame-press-conference/amp/?client=ms-android-google",
				"http://www.mercurynews.com/2017/01/22/steve-kerr-roasts-white-house-press-secretary-sean-spicer-in-postgame-press-conference/amp/?client=ms-android-google"},
			{"https://www.google.com/amp/www.sfchronicle.com/bayarea/matier-ross/amp/How-SF-arena-opponents-gave-a-boost-to-10872913.php?client=ms-android-google",
				"http://www.sfchronicle.com/bayarea/matier-ross/amp/How-SF-arena-opponents-gave-a-boost-to-10872913.php?client=ms-android-google"},
		};

		// iterate through all the test cases
		for (String test[] : testAMP) {
			assertEquals("AMP conversion failed!",test[1],NoAmpWebPage.convertAMP(test[0]));
		}
	}

}