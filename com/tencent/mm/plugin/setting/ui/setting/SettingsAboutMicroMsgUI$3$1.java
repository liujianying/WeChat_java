package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.3;

class SettingsAboutMicroMsgUI$3$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ 3 mRe;

    SettingsAboutMicroMsgUI$3$1(3 3, l lVar, int i, int i2) {
        this.mRe = 3;
        this.bFp = lVar;
        this.bFr = i;
        this.bFq = i2;
    }

    public final void run() {
        g.DF().b(255, SettingsAboutMicroMsgUI.c(this.mRe.mRb));
        SettingsAboutMicroMsgUI.d(this.mRe.mRb);
        if (SettingsAboutMicroMsgUI.e(this.mRe.mRb) != null) {
            SettingsAboutMicroMsgUI.e(this.mRe.mRb).SO();
            SettingsAboutMicroMsgUI.f(this.mRe.mRb);
        }
        if (SettingsAboutMicroMsgUI.a(this.mRe.mRb) != null) {
            SettingsAboutMicroMsgUI.a(this.mRe.mRb).dismiss();
        }
        if (this.bFp.getType() != 255 || ((r) this.bFp).efX != 1) {
            return;
        }
        if (this.bFr == -3 && this.bFq == 4) {
            Intent intent = new Intent(this.mRe.mRb.mController.tml, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", this.mRe.mRb.getString(i.regbymobile_reg_setpwd_tip_when_logout));
            this.mRe.mRb.startActivityForResult(intent, 0);
            return;
        }
        SettingsAboutMicroMsgUI.g(this.mRe.mRb);
    }
}
