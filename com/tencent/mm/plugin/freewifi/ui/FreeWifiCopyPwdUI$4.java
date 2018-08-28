package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.b;
import com.tencent.mm.sdk.platformtools.ag;

class FreeWifiCopyPwdUI$4 extends ag {
    final /* synthetic */ FreeWifiCopyPwdUI jmF;

    FreeWifiCopyPwdUI$4(FreeWifiCopyPwdUI freeWifiCopyPwdUI) {
        this.jmF = freeWifiCopyPwdUI;
    }

    public final void handleMessage(Message message) {
        b bVar = (b) message.obj;
        if (bVar.jmJ == FreeWifiCopyPwdUI.b(this.jmF)) {
            FreeWifiCopyPwdUI.a(this.jmF, bVar.data);
        } else {
            FreeWifiCopyPwdUI.b(this.jmF, bVar.data);
        }
    }
}
