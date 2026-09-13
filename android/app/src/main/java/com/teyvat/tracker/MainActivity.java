package com.teyvat.tracker;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {
  private WebView web;
  @Override public void onCreate(Bundle b){super.onCreate(b); web=new WebView(this); setContentView(web); setup();}
  private void setup(){
    WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true); s.setAllowContentAccess(true); s.setBuiltInZoomControls(false); s.setDisplayZoomControls(false);
    CookieManager.getInstance().setAcceptCookie(true);
    web.setWebViewClient(new WebViewClient()); web.setWebChromeClient(new WebChromeClient());
    web.setDownloadListener((url,userAgent,contentDisposition,mimeType,contentLength)->{ try{ Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url)); startActivity(i);}catch(Exception ignored){} });
    web.loadUrl("file:///android_asset/public/index.html");
  }
  @Override public void onBackPressed(){ if(web.canGoBack()) web.goBack(); else super.onBackPressed(); }
}
