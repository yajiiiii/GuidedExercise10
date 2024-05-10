package com.example.guidedexercise10;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    AutoCompleteTextView suggestedURL;
    ArrayAdapter<String> adapter;
    Button submit;
    String[] urls = {"google.com", "yahoo.com", "facebook.com", "youtube.com", "roblox.com",
            "nba.com", "amazon.com", "reddit.com", "wikipedia.org", "twitter.com",
            "linkedin.com", "netflix.com", "instagram.com", "pinterest.com", "ebay.com",
            "cnn.com", "bbc.com", "nytimes.com", "forbes.com", "bloomberg.com",
            "webmd.com", "nih.gov", "mayoclinic.org", "cnet.com", "techcrunch.com",
            "engadget.com", "wsj.com", "espn.com", "weather.com", "tripadvisor.com",
            "booking.com", "airbnb.com", "stackoverflow.com", "github.com", "khanacademy.org",
            "coursera.org", "udemy.com", "medium.com", "quora.com", "zoom.us",
            "salesforce.com", "oracle.com", "microsoft.com", "apple.com", "adobe.com",
            "buzzfeed.com", "foxnews.com", "guardian.co.uk", "hulu.com", "imdb.com",
            "twitch.tv", "vimeo.com", "wikileaks.org", "yelp.com", "zillow.com",
            "etsy.com", "ikea.com", "mcdonalds.com", "nike.com", "lego.com",
            "disney.com", "pixar.com", "warnerbros.com", "sony.com", "universalstudios.com",
            "vogue.com", "time.com", "sciencemag.org", "nature.com", "nejm.org",
            "spotify.com", "deezer.com", "soundcloud.com", "bandcamp.com", "reverbnation.com",
            "discover.com", "chase.com", "wellsfargo.com", "bankofamerica.com", "citigroup.com",
            "uscourts.gov", "europa.eu", "un.org", "nato.int", "who.int",
            "tesla.com", "spacex.com", "blueorigin.com", "virgingalactic.com", "boeing.com",
            "asos.com", "hm.com", "zara.com", "gap.com", "uniqlo.com",
            "wayfair.com", "overstock.com", "newegg.com", "bestbuy.com", "gamestop.com",
            "autotrader.com", "cars.com", "carvana.com", "edmunds.com", "kbb.com","miniclip.com", "addictinggames.com", "kongregate.com", "pogo.com", "y8.com",
            "armorgames.com", "crazygames.com", "agame.com", "bored.com", "nitrome.com",
            "ioGames.space", "newgrounds.com", "bigfishgames.com", "gamehouse.com", "primarygames.com",
            "friv.com", "zapak.com", "shockwave.com", "fog.com", "arkadium.com",
            "mousebreaker.com", "coolmathgames.com", "king.com", "papergames.io", "playretrogames.com",
            "plarium.com", "tankionline.com", "skribbl.io", "diep.io", "agar.io",
            "slither.io", "krunker.io", "hole.io", "surviv.io", "zombsroyale.io"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = findViewById(R.id.webView);
        suggestedURL = findViewById(R.id.actvURLGE10);
        submit = findViewById(R.id.btnOpenURLGE10);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, urls); // Specify generic type for ArrayAdapter
        suggestedURL.setThreshold(2);
        suggestedURL.setAdapter(adapter);

        initializeWebView();
        loadWebURL();
    }

    public void initializeWebView() {
        browser.getSettings().setLoadsImagesAutomatically(true);
        // enabled java script
        browser.getSettings().setJavaScriptEnabled(true);
        // Android webview launches browser when calling loadurl
        browser.setWebViewClient(new WebViewClient());
        // enabled Scrollbar
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); // Use View class constant
    }

    public void loadWebURL() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = suggestedURL.getText().toString();

                if (!url.startsWith("www.") && !url.startsWith("https://")) {
                    url = "www." + url;
                }
                if (!url.startsWith("https://")) {
                    url = "https://" + url;
                }
                browser.loadUrl(url);
            }
        });
    }
}
