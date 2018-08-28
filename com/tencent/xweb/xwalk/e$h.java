package com.tencent.xweb.xwalk;

import android.net.Uri;
import com.tencent.xweb.a.a;
import com.tencent.xweb.l;
import java.util.Map;
import org.xwalk.core.XWalkWebResourceRequest;

public class e$h implements l {
    private String method;
    private Map<String, String> qDh;
    private Uri vCP;
    private boolean vCQ;
    private boolean vCR;
    a vCS = new a(this);

    public e$h(XWalkWebResourceRequest xWalkWebResourceRequest) {
        this.vCP = xWalkWebResourceRequest.getUrl();
        this.vCQ = xWalkWebResourceRequest.isForMainFrame();
        this.vCR = xWalkWebResourceRequest.hasGesture();
        this.method = xWalkWebResourceRequest.getMethod();
        this.qDh = xWalkWebResourceRequest.getRequestHeaders();
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
