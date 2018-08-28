package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$8 implements Runnable {
    final /* synthetic */ String pZP;
    final /* synthetic */ ChattingSendDataToDeviceUI tLG;
    final /* synthetic */ aq tLI;
    final /* synthetic */ c tLJ;
    final /* synthetic */ int tLK;
    final /* synthetic */ int tLL;

    ChattingSendDataToDeviceUI$8(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, int i, aq aqVar, String str, c cVar, int i2) {
        this.tLG = chattingSendDataToDeviceUI;
        this.tLK = i;
        this.tLI = aqVar;
        this.pZP = str;
        this.tLJ = cVar;
        this.tLL = i2;
    }

    public final void run() {
        int i = this.tLK + 1;
        while (true) {
            if (i >= 100) {
                try {
                    this.tLG.runOnUiThread(new 1(this));
                    return;
                } catch (Exception e) {
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[]{e});
                }
            } else {
                this.tLI.tNv.setProgress(i);
                i++;
                Thread.sleep((long) this.tLL);
            }
        }
    }
}
