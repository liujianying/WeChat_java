package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;

class WelcomeSelectView$4 implements Runnable {
    final /* synthetic */ WelcomeSelectView eXw;

    WelcomeSelectView$4(WelcomeSelectView welcomeSelectView) {
        this.eXw = welcomeSelectView;
    }

    public final void run() {
        g.DF().a(new bg(new a() {
            public final void a(e eVar) {
            }
        }, "launch normal"), 0);
    }
}
