package com.tencent.mm.ui.tools;

import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.ui.tools.ShowImageUI.a;

class ShowImageUI$a$1 implements h {
    final /* synthetic */ MMAnimateView uCf;
    final /* synthetic */ a uCg;

    ShowImageUI$a$1(a aVar, MMAnimateView mMAnimateView) {
        this.uCg = aVar;
        this.uCf = mMAnimateView;
    }

    public final void invalidate() {
        this.uCf.invalidate();
    }
}
