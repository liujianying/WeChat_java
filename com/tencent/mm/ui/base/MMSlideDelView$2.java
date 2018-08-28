package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class MMSlideDelView$2 implements Runnable {
    final /* synthetic */ MMSlideDelView txt;

    MMSlideDelView$2(MMSlideDelView mMSlideDelView) {
        this.txt = mMSlideDelView;
    }

    public final void run() {
        this.txt.setPressed(false);
        x.v("MicroMsg.MMSlideDelView", "onClick");
        MMSlideDelView.b(this.txt).t(this.txt, MMSlideDelView.a(this.txt));
        this.txt.crL();
    }
}
