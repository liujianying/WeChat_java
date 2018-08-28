package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.MMGestureGallery.l;

class MMGestureGallery$l$2 implements Runnable {
    final /* synthetic */ MMGestureGallery uAu;
    final /* synthetic */ l uAv;

    MMGestureGallery$l$2(l lVar, MMGestureGallery mMGestureGallery) {
        this.uAv = lVar;
        this.uAu = mMGestureGallery;
    }

    public final void run() {
        MMGestureGallery.T(this.uAu).aMl();
    }
}
