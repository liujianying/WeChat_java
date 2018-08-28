package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.xweb.n;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class i extends n {
    XWalkView vFg;

    public i(XWalkView xWalkView) {
        this.vFg = xWalkView;
    }

    public final void setSupportZoom(boolean z) {
        this.vFg.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        this.vFg.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.vFg.getSettings().setBuiltInZoomControls(z);
    }

    public final void cIo() {
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.vFg.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cIp() {
        this.vFg.getSettings().setSaveFormData(false);
    }

    public final void cIq() {
    }

    public final void setTextZoom(int i) {
        this.vFg.getSettings().setTextZoom(i);
    }

    public final void setUseWideViewPort(boolean z) {
        this.vFg.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.vFg.getSettings().setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
    }

    public final void cIr() {
        this.vFg.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.vFg.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.vFg.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
    }

    public final void setDatabasePath(String str) {
    }

    public final void cIs() {
        this.vFg.getSettings().setAppCacheEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.vFg.getSettings().setAppCachePath(str);
    }

    public final void cIt() {
    }

    public final void cIu() {
        this.vFg.getSettings().setDatabaseEnabled(true);
    }

    public final void cIv() {
        this.vFg.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.vFg.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
    }

    public final void setUserAgentString(String str) {
        this.vFg.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        return this.vFg.getUserAgentString();
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
    }

    public final void cIw() {
        this.vFg.getSettings().setCacheMode(-1);
    }

    public final void cIx() {
    }
}
