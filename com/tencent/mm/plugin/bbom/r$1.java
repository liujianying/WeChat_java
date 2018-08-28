package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.ao;
import java.util.List;

class r$1 implements Runnable {
    final /* synthetic */ ao heG;
    final /* synthetic */ List heH;
    final /* synthetic */ r heI;

    r$1(r rVar, ao aoVar, List list) {
        this.heI = rVar;
        this.heG = aoVar;
        this.heH = list;
    }

    public final void run() {
        this.heG.B(this.heH);
    }
}
