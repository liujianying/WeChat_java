package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.2;

class SettingsMoreSafeUI$2$1 implements OnCancelListener {
    final /* synthetic */ d mSU;
    final /* synthetic */ 2 mTd;

    SettingsMoreSafeUI$2$1(2 2, d dVar) {
        this.mTd = 2;
        this.mSU = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mSU);
    }
}
