package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsMsgUI.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;

class SnsMsgUI$a$1 implements d {
    final /* synthetic */ a nYq;

    SnsMsgUI$a$1(a aVar) {
        this.nYq = aVar;
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
