package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2;

class SettingsAboutMicroMsgUI$2$3 implements OnCancelListener {
    final /* synthetic */ 2 mRc;
    final /* synthetic */ ac mRd;

    SettingsAboutMicroMsgUI$2$3(2 2, ac acVar) {
        this.mRc = 2;
        this.mRd = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mRd);
        g.DF().b(281, 2.a(this.mRc));
        2.b(this.mRc);
        if (2.c(this.mRc) != null) {
            2.c(this.mRc).SO();
            2.d(this.mRc);
        }
        if (SettingsAboutMicroMsgUI.a(this.mRc.mRb) != null) {
            SettingsAboutMicroMsgUI.a(this.mRc.mRb).dismiss();
        }
    }
}
