package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.WebView;

class j$a extends WebView {
    final /* synthetic */ j vDW;

    public j$a(j jVar, Context context) {
        this.vDW = jVar;
        super(context);
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.vDW.vCX != null) {
            this.vDW.vCX.onWebViewScrollChanged(i, i2, i3, i4);
        }
    }
}
