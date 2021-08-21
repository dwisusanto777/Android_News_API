package com.example.course2androidnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DetailBerita extends AppCompatActivity {

    String title, image, content, url;
    TextView titles;
    ImageView imageView;
    WebView webView;
    ImageLoaderConfiguration configuration;
    ImageLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        titles = findViewById(R.id.titleName);
        imageView = findViewById(R.id.imageContent);
        webView = findViewById(R.id.webku);
        loader = ImageLoader.getInstance();

        // di buat hilang untuk menampilkan full link
        titles.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);

        title = getIntent().getStringExtra("title");
        image = getIntent().getStringExtra("urlToImage");
        content = getIntent().getStringExtra("content");
        url = getIntent().getStringExtra("url");
        configuration = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        loader.init(configuration);
        loader.displayImage(image, imageView);

        // di remark karna menampilkan full URL
//        webView.loadData(content, "text/html", "utf-8");
//        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());


    }
}