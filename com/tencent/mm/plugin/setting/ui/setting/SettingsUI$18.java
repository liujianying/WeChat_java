package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class SettingsUI$18 implements OnCancelListener {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$18(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
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
