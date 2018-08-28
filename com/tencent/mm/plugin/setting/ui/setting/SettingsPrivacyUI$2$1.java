package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.2;

class SettingsPrivacyUI$2$1 implements Runnable {
    final /* synthetic */ 2 mTw;

    SettingsPrivacyUI$2$1(2 2) {
        this.mTw = 2;
    }

    public final void run() {
        ((Dialog) this.mTw.mRl.getTag()).dismiss();
        SettingsPrivacyUI.h(this.mTw.mTv);
    }
}
