package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.ui.applet.SecurityImage$b;

class RegSetInfoUI$17 extends SecurityImage$b {
    final /* synthetic */ l bFp;
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$17(RegSetInfoUI regSetInfoUI, l lVar) {
        this.eWJ = regSetInfoUI;
        this.bFp = lVar;
    }

    public final void Xe() {
        this.eWJ.YC();
        int e = RegSetInfoUI.e(this.eWJ);
        String f = RegSetInfoUI.f(this.eWJ);
        g.DF().a(429, this.eWJ);
        g.DF().a(new ad(f, RegSetInfoUI.g(this.eWJ), e, "", "", ((ad) this.bFp).Re(), ""), 0);
    }
}
