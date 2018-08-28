package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkView.OverScrolledListener;

class h$4 implements OverScrolledListener {
    final /* synthetic */ h vFd;

    h$4(h hVar) {
        this.vFd = hVar;
    }

    public final void onOverScrolled(boolean z) {
        if (z) {
            this.vFd.vFb = true;
        } else {
            this.vFd.vFb = false;
        }
    }
}
