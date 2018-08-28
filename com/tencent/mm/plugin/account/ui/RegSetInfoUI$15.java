package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.ui.base.h;

class RegSetInfoUI$15 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$15(RegSetInfoUI regSetInfoUI, l lVar) {
        this.eWJ = regSetInfoUI;
        this.bFp = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = RegSetInfoUI.b(this.eWJ).getText().toString().trim();
        String trim2 = RegSetInfoUI.a(this.eWJ).getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.i(this.eWJ, a$j.verify_account_null_tip, a$j.regbymobile_reg_setpwd_alert_title);
            return;
        }
        this.eWJ.YC();
        int e = RegSetInfoUI.e(this.eWJ);
        String f = RegSetInfoUI.f(this.eWJ);
        g.DF().a(429, this.eWJ);
        ad adVar = new ad(f, RegSetInfoUI.g(this.eWJ), e, trim, trim2, ((ad) this.bFp).Re(), RegSetInfoUI.C(this.eWJ).getSecImgCode());
        g.DF().a(adVar, 0);
        RegSetInfoUI regSetInfoUI = this.eWJ;
        Context context = this.eWJ;
        this.eWJ.getString(a$j.app_tip);
        RegSetInfoUI.a(regSetInfoUI, h.a(context, this.eWJ.getString(a$j.regbyqq_reg_waiting), true, new 1(this, adVar)));
    }
}
