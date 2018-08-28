package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.ui.base.h;
import java.util.List;

class SettingsAboutSystemUI$5 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;

    SettingsAboutSystemUI$5(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.mRk = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        SettingsAboutSystemUI.a(this.mRk, false);
        SettingsAboutSystemUI settingsAboutSystemUI = this.mRk;
        SettingsAboutSystemUI settingsAboutSystemUI2 = this.mRk;
        this.mRk.getString(i.app_tip);
        SettingsAboutSystemUI.a(settingsAboutSystemUI, h.a(settingsAboutSystemUI2, this.mRk.getString(i.app_waiting), true, new 1(this)));
        List clE = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().clE();
        if (clE.size() > 0) {
            List E = l.E(clE);
            if (E != null) {
                while (i2 < E.size()) {
                    if (((Boolean) E.get(i2)).booleanValue()) {
                        b.ezo.cV((String) clE.get(i2));
                    }
                    i2++;
                }
            }
        }
        bd.a(new a() {
            public final boolean Ip() {
                return SettingsAboutSystemUI.b(SettingsAboutSystemUI$5.this.mRk);
            }

            public final void Io() {
                if (SettingsAboutSystemUI.c(SettingsAboutSystemUI$5.this.mRk) != null) {
                    SettingsAboutSystemUI.c(SettingsAboutSystemUI$5.this.mRk).dismiss();
                    SettingsAboutSystemUI.a(SettingsAboutSystemUI$5.this.mRk, null);
                }
            }
        });
    }
}
