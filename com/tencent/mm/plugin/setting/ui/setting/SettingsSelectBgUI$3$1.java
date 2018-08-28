package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Message;
import com.tencent.mm.ar.n;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.3;
import com.tencent.mm.sdk.platformtools.ag;

class SettingsSelectBgUI$3$1 extends ag {
    final /* synthetic */ n mTT;
    final /* synthetic */ int mTU;
    final /* synthetic */ 3 mTV;

    SettingsSelectBgUI$3$1(3 3, n nVar, int i) {
        this.mTV = 3;
        this.mTT = nVar;
        this.mTU = i;
    }

    public final void handleMessage(Message message) {
        this.mTT.bm(this.mTU, 1);
    }
}
