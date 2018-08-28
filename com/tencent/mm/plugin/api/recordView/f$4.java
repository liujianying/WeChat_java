package com.tencent.mm.plugin.api.recordView;

import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;

class f$4 implements Runnable {
    final /* synthetic */ f fbE;
    final /* synthetic */ e fbG;
    final /* synthetic */ boolean fbH;

    f$4(f fVar, e eVar, boolean z) {
        this.fbE = fVar;
        this.fbG = eVar;
        this.fbH = z;
    }

    public final void run() {
        this.fbE.b(this.fbG, this.fbH);
    }
}
