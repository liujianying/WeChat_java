package com.tencent.xweb.xwalk.a;

import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

class f$1 extends TimerTask {
    final /* synthetic */ f vFM;

    f$1(f fVar) {
        this.vFM = fVar;
    }

    public final void run() {
        XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + f.a(this.vFM));
        f.a(f.b(this.vFM), f.c(this.vFM), f.a(this.vFM));
        f.d(this.vFM);
    }
}
