package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkView.ScrollChangedListener;

class h$3 implements ScrollChangedListener {
    final /* synthetic */ h vFd;

    h$3(h hVar) {
        this.vFd = hVar;
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        this.vFd.vEX.scrollTo(i, i2);
        if (this.vFd.gcI != null) {
            this.vFd.gcI.onScrollChanged(i, i2, i3, i4, this.vFd.vES);
        }
    }
}
