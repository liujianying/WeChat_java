package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$a$1 implements Runnable {
    final /* synthetic */ aq tLI;
    final /* synthetic */ c tLJ;
    final /* synthetic */ int tLK;
    final /* synthetic */ int tLL;
    final /* synthetic */ a tLP;

    ChattingSendDataToDeviceUI$a$1(a aVar, int i, c cVar, aq aqVar, int i2) {
        this.tLP = aVar;
        this.tLK = i;
        this.tLJ = cVar;
        this.tLI = aqVar;
        this.tLL = i2;
    }

    public final void run() {
        int i = this.tLK + 1;
        while (this.tLP.tLG.tLw) {
            if (i >= 100) {
                try {
                    if (this.tLJ.bLZ.equals("send_data_sucess")) {
                        this.tLP.tLG.runOnUiThread(new 1(this));
                        return;
                    } else if (this.tLJ.bLZ.equals("send_data_failed")) {
                        this.tLP.tLG.runOnUiThread(new 2(this));
                        return;
                    }
                } catch (Exception e) {
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[]{e});
                }
            } else {
                this.tLI.tNv.setProgress(i);
                this.tLJ.progress = i;
                i++;
                Thread.sleep((long) this.tLL);
            }
        }
    }
}
