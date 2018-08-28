package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;

class SettingsUI$16 implements OnCancelListener {
    final /* synthetic */ ac mRd;
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$16(SettingsUI settingsUI, ac acVar) {
        this.mUx = settingsUI;
        this.mRd = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mRd);
        g.DF().b(281, SettingsUI.w(this.mUx));
        g.DF().b(282, SettingsUI.y(this.mUx));
        SettingsUI.x(this.mUx);
        SettingsUI.z(this.mUx);
        if (SettingsUI.t(this.mUx) != null) {
            SettingsUI.t(this.mUx).SO();
            SettingsUI.u(this.mUx);
        }
        if (SettingsUI.p(this.mUx) != null) {
            SettingsUI.p(this.mUx).dismiss();
        }
    }
}
