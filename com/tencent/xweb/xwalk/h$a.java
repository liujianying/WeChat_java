package com.tencent.xweb.xwalk;

import android.content.Context;
import org.xwalk.core.XWalkView;

class h$a extends XWalkView {
    final /* synthetic */ h vFd;

    public h$a(h hVar, Context context) {
        this.vFd = hVar;
        super(context);
    }

    public final void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
        super.onScrollChangedDelegate(i, i2, i3, i4);
        if (this.vFd.vCX != null) {
            this.vFd.vCX.onWebViewScrollChanged(i, i2, i3, i4);
        }
    }
}
