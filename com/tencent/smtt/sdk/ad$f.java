package com.tencent.smtt.sdk;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.utils.q;
import java.util.Map;

class ad$f implements WebResourceRequest {
    android.webkit.WebResourceRequest a;

    ad$f(android.webkit.WebResourceRequest webResourceRequest) {
        this.a = webResourceRequest;
    }

    public String getMethod() {
        return this.a.getMethod();
    }

    public Map<String, String> getRequestHeaders() {
        return this.a.getRequestHeaders();
    }

    public Uri getUrl() {
        return this.a.getUrl();
    }

    public boolean hasGesture() {
        return this.a.hasGesture();
    }

    public boolean isForMainFrame() {
        return this.a.isForMainFrame();
    }

    public boolean isRedirect() {
        if (VERSION.SDK_INT >= 24) {
            Object a = q.a(this.a, "isRedirect");
            if (a instanceof Boolean) {
                return ((Boolean) a).booleanValue();
            }
        }
        return false;
    }
}
