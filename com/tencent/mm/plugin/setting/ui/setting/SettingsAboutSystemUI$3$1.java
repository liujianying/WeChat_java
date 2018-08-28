package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Process;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.3;

class SettingsAboutSystemUI$3$1 implements Runnable {
    final /* synthetic */ 3 mRp;

    SettingsAboutSystemUI$3$1(3 3) {
        this.mRp = 3;
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
