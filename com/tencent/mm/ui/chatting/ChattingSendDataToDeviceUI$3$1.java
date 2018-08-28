package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.3;

class ChattingSendDataToDeviceUI$3$1 implements Runnable {
    final /* synthetic */ f jLD;
    final /* synthetic */ 3 tLH;

    ChattingSendDataToDeviceUI$3$1(3 3, f fVar) {
        this.tLH = 3;
        this.jLD = fVar;
    }

    public final void run() {
        g.a(this.tLH.tLG.getBaseContext(), this.jLD.field_packageName, this.tLH.tLG.tLD, this.jLD.field_appId, this.jLD.field_openId, 0, null, null);
    }
}
