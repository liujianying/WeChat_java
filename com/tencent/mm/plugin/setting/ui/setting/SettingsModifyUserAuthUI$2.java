package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.h;

class SettingsModifyUserAuthUI$2 implements OnCancelListener {
    final /* synthetic */ SettingsModifyUserAuthUI mSY;
    final /* synthetic */ h mSZ;

    SettingsModifyUserAuthUI$2(SettingsModifyUserAuthUI settingsModifyUserAuthUI, h hVar) {
        this.mSY = settingsModifyUserAuthUI;
        this.mSZ = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mSZ);
    }
}
