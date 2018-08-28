package com.tencent.smtt.sdk;

import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;

public class WebView$HitTestResult {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private HitTestResult a;
    private WebView.HitTestResult b;

    public WebView$HitTestResult() {
        this.b = null;
        this.a = null;
        this.b = null;
    }

    public WebView$HitTestResult(WebView.HitTestResult hitTestResult) {
        this.b = null;
        this.a = null;
        this.b = hitTestResult;
    }

    public WebView$HitTestResult(HitTestResult hitTestResult) {
        this.b = null;
        this.a = hitTestResult;
        this.b = null;
    }

    public String getExtra() {
        return this.a != null ? this.a.getExtra() : this.b != null ? this.b.getExtra() : "";
    }

    public int getType() {
        return this.a != null ? this.a.getType() : this.b != null ? this.b.getType() : 0;
    }
}
