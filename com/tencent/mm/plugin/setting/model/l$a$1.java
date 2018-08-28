package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.plugin.setting.model.l.a;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;

class l$a$1 implements Runnable {
    final /* synthetic */ a mPk;

    l$a$1(a aVar) {
        this.mPk = aVar;
    }

    public final void run() {
        this.mPk.mPi.a(e.mVo);
    }
}
