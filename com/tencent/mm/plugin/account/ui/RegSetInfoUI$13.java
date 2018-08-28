package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage.b;

class RegSetInfoUI$13 extends b {
    final /* synthetic */ l bFp;
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$13(RegSetInfoUI regSetInfoUI, l lVar) {
        this.eWJ = regSetInfoUI;
        this.bFp = lVar;
    }

    public final void Xe() {
        this.eWJ.YC();
        String trim = RegSetInfoUI.a(this.eWJ).getText().toString().trim();
        String trim2 = RegSetInfoUI.b(this.eWJ).getText().toString().trim();
        int e = RegSetInfoUI.e(this.eWJ);
        g.DF().a(126, this.eWJ);
        s sVar = new s("", RegSetInfoUI.y(this.eWJ), trim2, RegSetInfoUI.z(this.eWJ), RegSetInfoUI.A(this.eWJ), RegSetInfoUI.B(this.eWJ), "", "", RegSetInfoUI.g(this.eWJ), e, trim, ((s) this.bFp).Re(), "", RegSetInfoUI.D(this.eWJ), RegSetInfoUI.j(this.eWJ));
        sVar.mX(RegSetInfoUI.E(this.eWJ));
        sVar.im(RegSetInfoUI.F(this.eWJ));
        g.DF().a(sVar, 0);
    }
}
