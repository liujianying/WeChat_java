package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.util.d;

public final class f extends n {
    WebView vDm;
    String vDn = "";

    public f(WebView webView) {
        this.vDm = webView;
        getUserAgentString();
    }

    public final void setSupportZoom(boolean z) {
        this.vDm.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (VERSION.SDK_INT >= 17) {
            this.vDm.getSettings().setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.vDm.getSettings().setBuiltInZoomControls(z);
    }

    public final void cIo() {
        this.vDm.getSettings().setDisplayZoomControls(false);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.vDm.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cIp() {
        this.vDm.getSettings().setSaveFormData(false);
    }

    public final void cIq() {
        this.vDm.getSettings().setJavaScriptEnabled(false);
    }

    public final void setTextZoom(int i) {
        this.vDm.getSettings().setTextZoom(i);
    }

    public final void setUseWideViewPort(boolean z) {
        this.vDm.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.vDm.getSettings().setLayoutAlgorithm(layoutAlgorithm);
    }

    public final void cIr() {
        this.vDm.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.vDm.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.vDm.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
        d.c(this.vDm.getSettings(), "setPluginsEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public final void setDatabasePath(String str) {
        this.vDm.getSettings().setDatabasePath(str);
    }

    public final void cIs() {
        this.vDm.getSettings().setJavaScriptEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.vDm.getSettings().setAppCachePath(str);
    }

    public final void cIt() {
        this.vDm.getSettings().setAppCacheMaxSize(10485760);
    }

    public final void cIu() {
        this.vDm.getSettings().setDatabaseEnabled(true);
    }

    public final void cIv() {
        this.vDm.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.vDm.getSettings().setJavaScriptEnabled(z);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.vDm.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
        this.vDm.getSettings().setDefaultTextEncodingName(str);
    }

    public final void setUserAgentString(String str) {
        this.vDn = str;
        this.vDm.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        if (this.vDn == null || this.vDn.isEmpty()) {
            try {
                this.vDn = this.vDm.getSettings().getUserAgentString();
            } catch (Exception e) {
            }
        }
        return this.vDn;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        this.vDm.getSettings().setRenderPriority(renderPriority);
    }

    public final void cIw() {
        this.vDm.getSettings().setCacheMode(-1);
    }

    public final void cIx() {
        if (VERSION.SDK_INT >= 21) {
            this.vDm.getSettings().setMixedContentMode(0);
        }
    }
}
