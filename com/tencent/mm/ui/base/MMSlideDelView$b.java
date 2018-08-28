package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class MMSlideDelView$b implements Runnable {
    final /* synthetic */ MMSlideDelView txt;

    MMSlideDelView$b(MMSlideDelView mMSlideDelView) {
        this.txt = mMSlideDelView;
    }

    public final void run() {
        x.v("MicroMsg.MMSlideDelView", "checkfortap");
        this.txt.setPressed(true);
    }
}
