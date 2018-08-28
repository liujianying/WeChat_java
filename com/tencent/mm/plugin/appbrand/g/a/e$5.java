package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.mm.plugin.appbrand.g.a.e.a;
import java.util.TimerTask;

class e$5 extends TimerTask {
    final /* synthetic */ f gdY;
    final /* synthetic */ e gec;
    final /* synthetic */ a ged;

    e$5(e eVar, f fVar, a aVar) {
        this.gec = eVar;
        this.gdY = fVar;
        this.ged = aVar;
    }

    public final void run() {
        this.gdY.gem.r(new Runnable() {
            public final void run() {
                e$5.this.ged.cX(true);
            }
        });
    }
}
