package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.i;

class SettingsSearchAuthUI$8 implements OnCancelListener {
    final /* synthetic */ SettingsSearchAuthUI mTJ;
    final /* synthetic */ i mTK;

    SettingsSearchAuthUI$8(SettingsSearchAuthUI settingsSearchAuthUI, i iVar) {
        this.mTJ = settingsSearchAuthUI;
        this.mTK = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mTK);
    }
}
