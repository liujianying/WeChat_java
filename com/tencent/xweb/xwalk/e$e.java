package com.tencent.xweb.xwalk;

import android.content.Context;
import android.webkit.DownloadListener;
import org.xwalk.core.XWalkDownloadListener;

public class e$e extends XWalkDownloadListener {
    DownloadListener vDr;

    public e$e(Context context, DownloadListener downloadListener) {
        super(context);
        this.vDr = downloadListener;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.vDr != null) {
            this.vDr.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
