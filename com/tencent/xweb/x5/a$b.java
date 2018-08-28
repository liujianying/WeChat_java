package com.tencent.xweb.x5;

import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;

public class a$b implements FindListener {
    WebView.FindListener vDs;

    public a$b(WebView.FindListener findListener) {
        this.vDs = findListener;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (this.vDs != null) {
            this.vDs.onFindResultReceived(i, i2, z);
        }
    }
}
