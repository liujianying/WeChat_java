package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.1;

class SettingsManageAuthUI$a$1$1 implements OnCancelListener {
    final /* synthetic */ 1 mSA;
    final /* synthetic */ c mSz;

    SettingsManageAuthUI$a$1$1(1 1, c cVar) {
        this.mSA = 1;
        this.mSz = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mSz);
    }
}
