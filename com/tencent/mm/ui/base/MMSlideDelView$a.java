package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.h;

class MMSlideDelView$a extends h implements Runnable {
    final /* synthetic */ MMSlideDelView txt;

    private MMSlideDelView$a(MMSlideDelView mMSlideDelView) {
        this.txt = mMSlideDelView;
        super(mMSlideDelView, (byte) 0);
    }

    /* synthetic */ MMSlideDelView$a(MMSlideDelView mMSlideDelView, byte b) {
        this(mMSlideDelView);
    }

    public final void run() {
        Object obj = (this.txt.hasWindowFocus() && MMSlideDelView.c(this.txt) == this.txu) ? 1 : null;
        if (obj != null && !MMSlideDelView.d(this.txt)) {
            x.i("MicroMsg.MMSlideDelView", "is long press");
            if (this.txt.getParent() != null) {
                MMSlideDelView.e(this.txt);
                this.txt.performLongClick();
            }
        }
    }
}
