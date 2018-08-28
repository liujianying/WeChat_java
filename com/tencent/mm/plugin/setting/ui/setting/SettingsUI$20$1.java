package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.setting.SettingsUI.20;

class SettingsUI$20$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ 20 mUC;

    SettingsUI$20$1(20 20, l lVar, int i, int i2) {
        this.mUC = 20;
        this.bFp = lVar;
        this.bFr = i;
        this.bFq = i2;
    }

    public final void run() {
        g.DF().b(255, SettingsUI.r(this.mUC.mUx));
        SettingsUI.s(this.mUC.mUx);
        if (SettingsUI.t(this.mUC.mUx) != null) {
            SettingsUI.t(this.mUC.mUx).SO();
            SettingsUI.u(this.mUC.mUx);
        }
        if (SettingsUI.p(this.mUC.mUx) != null) {
            SettingsUI.p(this.mUC.mUx).dismiss();
        }
        if (this.bFp.getType() != 255 || ((r) this.bFp).efX != 1) {
            return;
        }
        if (this.bFr == -3 && this.bFq == 4) {
            Intent intent = new Intent(this.mUC.mUx.mController.tml, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", this.mUC.mUx.getString(i.regbymobile_reg_setpwd_tip_when_logout));
            this.mUC.mUx.startActivityForResult(intent, 0);
            return;
        }
        SettingsUI.C(this.mUC.mUx);
    }
}
