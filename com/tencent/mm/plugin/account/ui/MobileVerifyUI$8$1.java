package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.al.b;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.8;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class MobileVerifyUI$8$1 implements c {
    final /* synthetic */ 8 eUt;

    MobileVerifyUI$8$1(8 8) {
        this.eUt = 8;
    }

    public final void a(l lVar) {
        lVar.e(0, this.eUt.eUo.getString(j.mobileverify_resend));
        if (b.mj(this.eUt.eUo.bTi)) {
            lVar.e(1, this.eUt.eUo.getString(j.bind_mcontact_voice_verify_entrance));
        }
        if (MobileVerifyUI.f(this.eUt.eUo) == 2 && this.eUt.eUo.eUk) {
            lVar.e(2, this.eUt.eUo.getString(j.regbymobile_reg_qq_reg));
        }
    }
}
