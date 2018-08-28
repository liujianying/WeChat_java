package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

class BindMContactVerifyUI$2 implements OnClickListener {
    final /* synthetic */ BindMContactVerifyUI eGG;

    BindMContactVerifyUI$2(BindMContactVerifyUI bindMContactVerifyUI) {
        this.eGG = bindMContactVerifyUI;
    }

    public final void onClick(View view) {
        String trim = BindMContactVerifyUI.a(this.eGG).getText().toString().trim();
        if (trim.equals("")) {
            h.i(this.eGG, j.bind_mcontact_verifynull, j.app_tip);
            return;
        }
        this.eGG.YC();
        hp hpVar = new hp();
        hpVar.bQV.context = this.eGG;
        a.sFg.m(hpVar);
        String str = hpVar.bQW.bQX;
        hq hqVar = new hq();
        a.sFg.m(hqVar);
        String str2 = hqVar.bQY.bQZ;
        int i = 2;
        if (BindMContactVerifyUI.b(this.eGG)) {
            i = 19;
        }
        x xVar = new x(BindMContactVerifyUI.c(this.eGG), i, trim, "", str, str2);
        g.DF().a(xVar, 0);
        BindMContactVerifyUI bindMContactVerifyUI = this.eGG;
        BindMContactVerifyUI bindMContactVerifyUI2 = this.eGG;
        this.eGG.getString(j.app_tip);
        BindMContactVerifyUI.a(bindMContactVerifyUI, h.a(bindMContactVerifyUI2, this.eGG.getString(j.bind_mcontact_verifing), true, new 1(this, xVar)));
    }
}
