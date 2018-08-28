package com.tencent.mm.ui.chatting;

import android.os.Message;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.chatting.t.e;

class t$e$1 extends ag {
    final /* synthetic */ e tKF;

    t$e$1(e eVar) {
        this.tKF = eVar;
    }

    public final void handleMessage(Message message) {
        View view = (View) message.obj;
        if (this.tKF.pVr != view.getScrollY()) {
            this.tKF.our = true;
            this.tKF.handler.sendMessageDelayed(this.tKF.handler.obtainMessage(0, view), 5);
            this.tKF.pVr = view.getScrollY();
            return;
        }
        this.tKF.our = false;
    }
}
