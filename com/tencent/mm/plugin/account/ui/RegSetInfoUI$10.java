package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class RegSetInfoUI$10 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$10(RegSetInfoUI regSetInfoUI, l lVar) {
        this.eWJ = regSetInfoUI;
        this.bFp = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = RegSetInfoUI.a(this.eWJ).getText().toString().trim();
        String trim2 = RegSetInfoUI.b(this.eWJ).getText().toString().trim();
        if (trim2 == null || trim2.length() <= 0) {
            h.i(this.eWJ, j.verify_account_null_tip, j.regbymobile_reg_setpwd_alert_title);
            return;
        }
        int e = RegSetInfoUI.e(this.eWJ);
        g.DF().a(126, this.eWJ);
        s sVar = new s("", RegSetInfoUI.y(this.eWJ), trim2, RegSetInfoUI.z(this.eWJ), RegSetInfoUI.A(this.eWJ), RegSetInfoUI.B(this.eWJ), "", "", RegSetInfoUI.g(this.eWJ), e, trim, ((s) this.bFp).Re(), RegSetInfoUI.C(this.eWJ).getSecImgCode(), RegSetInfoUI.D(this.eWJ), RegSetInfoUI.j(this.eWJ));
        sVar.mX(RegSetInfoUI.E(this.eWJ));
        sVar.im(RegSetInfoUI.F(this.eWJ));
        g.DF().a(sVar, 0);
        RegSetInfoUI regSetInfoUI = this.eWJ;
        RegSetInfoUI regSetInfoUI2 = this.eWJ;
        this.eWJ.getString(j.app_tip);
        RegSetInfoUI.a(regSetInfoUI, h.a(regSetInfoUI2, this.eWJ.getString(j.regbyqq_reg_waiting), true, new 1(this, sVar)));
    }
}
