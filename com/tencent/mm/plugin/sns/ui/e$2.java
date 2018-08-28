package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.e.3;
import java.util.List;

class e$2 implements Runnable {
    final /* synthetic */ e nKD;
    final /* synthetic */ List nKE;
    final /* synthetic */ boolean nKF = true;

    e$2(e eVar, List list) {
        this.nKD = eVar;
        this.nKE = list;
    }

    public final void run() {
        this.nKD.cq(this.nKE);
        af.bxY().post(new 3(this.nKD, this.nKF));
    }
}
