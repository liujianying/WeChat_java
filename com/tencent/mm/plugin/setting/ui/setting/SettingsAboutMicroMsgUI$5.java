package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;

class SettingsAboutMicroMsgUI$5 implements OnCancelListener {
    final /* synthetic */ SettingsAboutMicroMsgUI mRb;
    final /* synthetic */ r mRf;

    SettingsAboutMicroMsgUI$5(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI, r rVar) {
        this.mRb = settingsAboutMicroMsgUI;
        this.mRf = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.mRf);
        g.DF().b(b.CTRL_BYTE, SettingsAboutMicroMsgUI.c(this.mRb));
        SettingsAboutMicroMsgUI.d(this.mRb);
        if (SettingsAboutMicroMsgUI.e(this.mRb) != null) {
            SettingsAboutMicroMsgUI.e(this.mRb).SO();
            SettingsAboutMicroMsgUI.f(this.mRb);
        }
        if (SettingsAboutMicroMsgUI.a(this.mRb) != null) {
            SettingsAboutMicroMsgUI.a(this.mRb).dismiss();
        }
    }
}
