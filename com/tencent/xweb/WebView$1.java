package com.tencent.xweb;

import android.view.View;
import android.view.View.OnLongClickListener;

class WebView$1 implements OnLongClickListener {
    final /* synthetic */ WebView vAJ;

    WebView$1(WebView webView) {
        this.vAJ = webView;
    }

    public final boolean onLongClick(View view) {
        if (this.vAJ.uGp != null) {
            return this.vAJ.uGp.onLongClick(this.vAJ);
        }
        return false;
    }
}
