package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class SettingsAliasUI$5 implements e {
    final /* synthetic */ SettingsAliasUI mRV;

    SettingsAliasUI$5(SettingsAliasUI settingsAliasUI) {
        this.mRV = settingsAliasUI;
    }

    public final void a(final int i, final int i2, String str, final l lVar) {
        x.d("MicroMsg.SettingsAliasUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        g.DF().b(255, SettingsAliasUI.g(this.mRV));
        ah.A(new Runnable() {
            public final void run() {
                if (SettingsAliasUI.h(SettingsAliasUI$5.this.mRV) != null) {
                    SettingsAliasUI.h(SettingsAliasUI$5.this.mRV).dismiss();
                    SettingsAliasUI.i(SettingsAliasUI$5.this.mRV);
                }
                SettingsAliasUI.j(SettingsAliasUI$5.this.mRV);
                if (lVar.getType() == 255) {
                    boolean z = (i2 == -3 && i == 4) ? false : true;
                    Intent intent = new Intent(SettingsAliasUI$5.this.mRV, SettingsAliasResultUI.class);
                    intent.putExtra("has_pwd", z);
                    SettingsAliasUI$5.this.mRV.startActivity(intent);
                    SettingsAliasUI$5.this.mRV.finish();
                }
            }
        });
    }
}
