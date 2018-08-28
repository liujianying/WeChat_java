package com.tencent.xweb.x5;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.n.a;

public final class k extends n {
    WebView vDX;

    public k(WebView webView) {
        this.vDX = webView;
    }

    public final void setSupportZoom(boolean z) {
        this.vDX.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        this.vDX.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.vDX.getSettings().setBuiltInZoomControls(z);
    }

    public final void cIo() {
        this.vDX.getSettings().setDisplayZoomControls(false);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.vDX.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cIp() {
        this.vDX.getSettings().setSaveFormData(false);
    }

    public final void cIq() {
        this.vDX.getSettings().setJavaScriptEnabled(false);
    }

    public final void setTextZoom(int i) {
        this.vDX.getSettings().setTextZoom(i);
    }

    public final synchronized void a(a aVar) {
        this.vDX.getSettings().setTextSize(TextSize.valueOf(aVar.name()));
    }

    public final void setUseWideViewPort(boolean z) {
        this.vDX.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.vDX.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
    }

    public final void cIr() {
        this.vDX.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.vDX.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.vDX.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
        this.vDX.getSettings().setPluginsEnabled(z);
    }

    public final void setDatabasePath(String str) {
        this.vDX.getSettings().setDatabasePath(str);
    }

    public final void cIs() {
        this.vDX.getSettings().setJavaScriptEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.vDX.getSettings().setAppCachePath(str);
    }

    public final void cIt() {
        this.vDX.getSettings().setAppCacheMaxSize(10485760);
    }

    public final void cIu() {
        this.vDX.getSettings().setDatabaseEnabled(true);
    }

    public final void cIv() {
        this.vDX.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.vDX.getSettings().setJavaScriptEnabled(z);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.vDX.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
        this.vDX.getSettings().setDefaultTextEncodingName(str);
    }

    public final void setUserAgentString(String str) {
        this.vDX.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        return this.vDX.getSettings().getUserAgentString();
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        this.vDX.getSettings().setRenderPriority(WebSettings.RenderPriority.values()[renderPriority.ordinal()]);
    }

    public final void cIw() {
        this.vDX.getSettings().setCacheMode(-1);
    }

    public final void cIx() {
        this.vDX.getSettings().setMixedContentMode(0);
    }
}
