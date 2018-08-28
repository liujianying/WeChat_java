package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;

class SettingsUI$11 implements OnCancelListener {
    final /* synthetic */ r mRf;
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$11(SettingsUI settingsUI, r rVar) {
        this.mUx = settingsUI;
        this.mRf = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mRf);
        g.DF().b(255, SettingsUI.r(this.mUx));
        SettingsUI.s(this.mUx);
        if (SettingsUI.t(this.mUx) != null) {
            SettingsUI.t(this.mUx).SO();
            SettingsUI.u(this.mUx);
        }
        if (SettingsUI.p(this.mUx) != null) {
            SettingsUI.p(this.mUx).dismiss();
        }
    }
}
