package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import java.util.Map;

class ad$e implements WebResourceRequest {
    final /* synthetic */ ad a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;
    private Map<String, String> g;

    public ad$e(ad adVar, String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
        this.a = adVar;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = str2;
        this.g = map;
    }

    public String getMethod() {
        return this.f;
    }

    public Map<String, String> getRequestHeaders() {
        return this.g;
    }

    public Uri getUrl() {
        return Uri.parse(this.b);
    }

    public boolean hasGesture() {
        return this.e;
    }

    public boolean isForMainFrame() {
        return this.c;
    }

    public boolean isRedirect() {
        return this.d;
    }
}
