package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMSlideDelView.d;

class MMSlideDelView$1 implements d {
    MMSlideDelView$1() {
    }

    public final void a(MMSlideDelView mMSlideDelView, boolean z) {
        if (z) {
            kwC.add(mMSlideDelView);
        } else {
            kwC.remove(mMSlideDelView);
        }
    }

    public final boolean aYk() {
        return kwC.size() > 0;
    }

    public final void aYl() {
        for (MMSlideDelView mMSlideDelView : kwC) {
            if (mMSlideDelView != null) {
                mMSlideDelView.crM();
            }
        }
        kwC.clear();
    }

    public final void aYm() {
        for (MMSlideDelView mMSlideDelView : kwC) {
            if (mMSlideDelView != null) {
                mMSlideDelView.crL();
            }
        }
        kwC.clear();
    }
}
