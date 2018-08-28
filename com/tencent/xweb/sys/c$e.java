package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceRequest;
import com.tencent.xweb.a.a;
import com.tencent.xweb.l;
import java.util.Map;

public class c$e implements l {
    private String method;
    private Map<String, String> qDh;
    private Uri vCP;
    private boolean vCQ;
    private boolean vCR;
    a vCS;

    public c$e(WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.vCP = webResourceRequest.getUrl();
            this.vCQ = webResourceRequest.isForMainFrame();
            this.vCR = webResourceRequest.hasGesture();
            this.method = webResourceRequest.getMethod();
            this.qDh = webResourceRequest.getRequestHeaders();
            this.vCS = new a(this);
        }
    }

    public final Uri getUrl() {
        return this.vCP;
    }

    public final boolean isForMainFrame() {
        return this.vCQ;
    }

    public final boolean hasGesture() {
        return this.vCR;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.qDh;
    }
}
