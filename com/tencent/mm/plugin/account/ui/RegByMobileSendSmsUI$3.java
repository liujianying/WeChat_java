package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage$b;

class RegByMobileSendSmsUI$3 extends SecurityImage$b {
    final /* synthetic */ RegByMobileSendSmsUI eVm;
    final /* synthetic */ s eVn;

    RegByMobileSendSmsUI$3(RegByMobileSendSmsUI regByMobileSendSmsUI, s sVar) {
        this.eVm = regByMobileSendSmsUI;
        this.eVn = sVar;
    }

    public final void Xe() {
        this.eVm.YC();
        s sVar = new s("", RegByMobileSendSmsUI.e(this.eVm), RegByMobileSendSmsUI.f(this.eVm), 0, "", RegByMobileSendSmsUI.g(this.eVm), "", "", RegByMobileSendSmsUI.h(this.eVm), 1, "", this.eVn.Re(), RegByMobileSendSmsUI.i(this.eVm).getSecImgCode(), true, RegByMobileSendSmsUI.j(this.eVm));
        sVar.mX(RegByMobileSendSmsUI.k(this.eVm));
        sVar.im(1);
        g.DF().a(sVar, 0);
    }
}
