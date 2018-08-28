package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$9 implements e {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$9(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void a(final int i, final int i2, String str, final l lVar) {
        x.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        ah.A(new Runnable() {
            public final void run() {
                g.DF().b(b.CTRL_BYTE, SettingsUI.r(SettingsUI$9.this.mUx));
                SettingsUI.s(SettingsUI$9.this.mUx);
                if (SettingsUI.t(SettingsUI$9.this.mUx) != null) {
                    SettingsUI.t(SettingsUI$9.this.mUx).SO();
                    SettingsUI.u(SettingsUI$9.this.mUx);
                }
                if (SettingsUI.p(SettingsUI$9.this.mUx) != null) {
                    SettingsUI.p(SettingsUI$9.this.mUx).dismiss();
                }
                if (lVar.getType() != b.CTRL_BYTE || ((r) lVar).efX != 2) {
                    return;
                }
                if (i2 == -3 && i == 4) {
                    Intent intent = new Intent(SettingsUI$9.this.mUx.mController.tml, RegByMobileSetPwdUI.class);
                    intent.putExtra("kintent_hint", SettingsUI$9.this.mUx.getString(i.regbymobile_reg_setpwd_tip_when_logout));
                    SettingsUI$9.this.mUx.startActivityForResult(intent, 5);
                    return;
                }
                SettingsUI.v(SettingsUI$9.this.mUx);
            }
        });
    }
}
