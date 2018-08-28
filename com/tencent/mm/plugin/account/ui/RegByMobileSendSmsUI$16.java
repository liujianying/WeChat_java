package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.ui.base.h;

class RegByMobileSendSmsUI$16 implements OnClickListener {
    final /* synthetic */ RegByMobileSendSmsUI eVm;
    final /* synthetic */ s eVn;

    RegByMobileSendSmsUI$16(RegByMobileSendSmsUI regByMobileSendSmsUI, s sVar) {
        this.eVm = regByMobileSendSmsUI;
        this.eVn = sVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        s sVar = new s("", RegByMobileSendSmsUI.e(this.eVm), RegByMobileSendSmsUI.f(this.eVm), 0, "", RegByMobileSendSmsUI.g(this.eVm), "", "", RegByMobileSendSmsUI.h(this.eVm), 1, "", this.eVn.Re(), RegByMobileSendSmsUI.i(this.eVm).getSecImgCode(), true, RegByMobileSendSmsUI.j(this.eVm));
        sVar.mX(RegByMobileSendSmsUI.k(this.eVm));
        sVar.im(1);
        g.DF().a(sVar, 0);
        RegByMobileSendSmsUI regByMobileSendSmsUI = this.eVm;
        Context context = this.eVm.mController.tml;
        this.eVm.getString(a$j.app_tip);
        RegByMobileSendSmsUI.a(regByMobileSendSmsUI, h.a(context, this.eVm.getString(a$j.regbyqq_reg_waiting), true, new 1(this, sVar)));
    }
}
