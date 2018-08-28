package com.tencent.mm.ui.transmit;

import android.app.Activity;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class MsgRetransmitUI$a$1 implements Runnable {
    final /* synthetic */ a uEc;

    MsgRetransmitUI$a$1(a aVar) {
        this.uEc = aVar;
    }

    public final void run() {
        if (this.uEc.uDY && (this.uEc.context instanceof Activity)) {
            ((Activity) this.uEc.context).finish();
        }
    }
}
