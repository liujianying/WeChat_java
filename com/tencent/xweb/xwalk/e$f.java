package com.tencent.xweb.xwalk;

import android.webkit.WebView.FindListener;
import org.xwalk.core.XWalkFindListener;

public class e$f extends XWalkFindListener {
    FindListener vDs;

    public e$f(FindListener findListener) {
        this.vDs = findListener;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (this.vDs != null) {
            this.vDs.onFindResultReceived(i, i2, z);
        }
    }
}
