package com.tencent.mm.app;

import com.tencent.mm.R;
import com.tencent.mm.ak.n;
import com.tencent.mm.app.WorkerProfile.30;

class WorkerProfile$30$1 implements Runnable {
    final /* synthetic */ int bAb;
    final /* synthetic */ String bAc;
    final /* synthetic */ String bAd;
    final /* synthetic */ boolean bAe;
    final /* synthetic */ 30 bAf;

    WorkerProfile$30$1(30 30, int i, String str, String str2, boolean z) {
        this.bAf = 30;
        this.bAb = i;
        this.bAc = str;
        this.bAd = str2;
        this.bAe = z;
    }

    public final void run() {
        n.OW().a(0, this.bAb, this.bAc, this.bAd, this.bAe, R.g.chat_img_template);
    }
}
