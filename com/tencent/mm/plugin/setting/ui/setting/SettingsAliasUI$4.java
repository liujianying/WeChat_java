package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class SettingsAliasUI$4 implements OnCancelListener {
    final /* synthetic */ SettingsAliasUI mRV;

    SettingsAliasUI$4(SettingsAliasUI settingsAliasUI) {
        this.mRV = settingsAliasUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (SettingsAliasUI.f(this.mRV) != null) {
            g.DF().c(SettingsAliasUI.f(this.mRV));
        }
    }
}
