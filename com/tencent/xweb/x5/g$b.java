package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.l;
import java.util.Map;

public class g$b implements l {
    private String method;
    private Map<String, String> qDh;
    private Uri vCP;
    private boolean vCQ;
    private boolean vCR;

    public g$b(WebResourceRequest webResourceRequest) {
        this.vCP = webResourceRequest.getUrl();
        this.vCQ = webResourceRequest.isForMainFrame();
        this.vCR = webResourceRequest.hasGesture();
        this.method = webResourceRequest.getMethod();
        this.qDh = webResourceRequest.getRequestHeaders();
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
