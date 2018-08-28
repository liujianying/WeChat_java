package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.a;

class RegByMobileSendSmsUI$5 implements Runnable {
    final /* synthetic */ String eTD;
    final /* synthetic */ RegByMobileSendSmsUI eVm;
    final /* synthetic */ s eVn;

    RegByMobileSendSmsUI$5(RegByMobileSendSmsUI regByMobileSendSmsUI, s sVar, String str) {
        this.eVm = regByMobileSendSmsUI;
        this.eVn = sVar;
        this.eTD = str;
    }

    public final void run() {
        RegByMobileSendSmsUI.a(this.eVm, this.eVn.Rn());
        at.dBv.T("login_user_name", this.eTD);
        Intent be = a.ezn.be(this.eVm);
        be.addFlags(67108864);
        this.eVm.startActivity(be);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_600,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_600")).append(",4").toString());
        this.eVm.finish();
    }
}
