package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.DownloadListener;

public class a$a implements DownloadListener {
    android.webkit.DownloadListener vDr;

    public a$a(android.webkit.DownloadListener downloadListener) {
        this.vDr = downloadListener;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.vDr != null) {
            this.vDr.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
