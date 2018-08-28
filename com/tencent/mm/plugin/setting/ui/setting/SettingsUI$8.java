package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;

class SettingsUI$8 implements OnCancelListener {
    final /* synthetic */ ac mRd;
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$8(SettingsUI settingsUI, ac acVar) {
        this.mUx = settingsUI;
        this.mRd = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mRd);
        g.DF().b(281, SettingsUI.l(this.mUx));
        SettingsUI.m(this.mUx);
        if (SettingsUI.n(this.mUx) != null) {
            SettingsUI.n(this.mUx).SO();
            SettingsUI.o(this.mUx);
        }
        if (SettingsUI.p(this.mUx) != null) {
            SettingsUI.p(this.mUx).dismiss();
        }
    }
}
