package com.tencent.xweb.xwalk;

import android.webkit.WebChromeClient.CustomViewCallback;

public class e$a implements CustomViewCallback {
    org.xwalk.core.CustomViewCallback vEM;

    e$a(org.xwalk.core.CustomViewCallback customViewCallback) {
        this.vEM = customViewCallback;
    }

    public final void onCustomViewHidden() {
        this.vEM.onCustomViewHidden();
    }
}
