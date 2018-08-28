package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.sdk.platformtools.x;

class q$2 implements Runnable {
    final /* synthetic */ q ftZ;

    q$2(q qVar) {
        this.ftZ = qVar;
    }

    public final void run() {
        if (q.b(this.ftZ) == null) {
            x.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
        } else if (q.c(this.ftZ)) {
            this.ftZ.setVisibility(0);
            if (q.b(this.ftZ).indexOfChild(this.ftZ) == -1) {
                q.b(this.ftZ).addView(this.ftZ);
            }
            q.b(this.ftZ).bringChildToFront(this.ftZ);
            this.ftZ.setBackgroundColor(this.ftZ.getContext().getResources().getColor(s$d.half_alpha_black));
        } else {
            this.ftZ.setBackgroundColor(this.ftZ.getContext().getResources().getColor(s$d.transparent));
        }
    }
}
