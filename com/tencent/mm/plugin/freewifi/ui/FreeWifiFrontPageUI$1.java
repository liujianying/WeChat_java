package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.8;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.c;
import com.tencent.mm.sdk.platformtools.ag;

class FreeWifiFrontPageUI$1 extends ag {
    final /* synthetic */ FreeWifiFrontPageUI jnd;

    FreeWifiFrontPageUI$1(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.jnd = freeWifiFrontPageUI;
    }

    public final void handleMessage(Message message) {
        c cVar = (c) message.obj;
        switch (8.jne[cVar.jnc.ordinal()]) {
            case 1:
                this.jnd.aPA();
                return;
            case 2:
                this.jnd.aPB();
                return;
            case 3:
                this.jnd.by(cVar.data);
                return;
            case 4:
                this.jnd.bz(cVar.data);
                return;
            default:
                return;
        }
    }
}
