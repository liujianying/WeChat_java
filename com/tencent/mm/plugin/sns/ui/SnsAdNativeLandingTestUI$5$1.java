package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.5;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingTestUI$5$1 implements Runnable {
    final /* synthetic */ int gcp;
    final /* synthetic */ 5 nTh;
    final /* synthetic */ int ner;

    SnsAdNativeLandingTestUI$5$1(5 5, int i, int i2) {
        this.nTh = 5;
        this.gcp = i;
        this.ner = i2;
    }

    public final void run() {
        x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + this.gcp + " video time " + this.ner);
        if (this.ner > 0) {
            SnsAdNativeLandingTestUI.a(this.nTh.nTe, this.ner);
            SnsAdNativeLandingTestUI.b(this.nTh.nTe, this.ner);
        }
        if (this.nTh.nTe.nTd.getVideoTotalTime() != this.ner) {
            this.nTh.nTe.nTd.setVideoTotalTime(this.ner);
        }
        this.nTh.nTe.nTd.seek(this.gcp);
    }
}
