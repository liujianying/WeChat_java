package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.jsapi.o.c;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.f;
import com.tencent.mm.sdk.platformtools.x;

class ac$2 implements Runnable {
    final /* synthetic */ ac gJf;

    ac$2(ac acVar) {
        this.gJf = acVar;
    }

    public final void run() {
        if (this.gJf.gJc) {
            f bL = c.bL(this.gJf.gIY);
            if (this.gJf.gJa == null || Math.abs(this.gJf.gJa.x - bL.x) > 1.0f || Math.abs(this.gJf.gJa.y - bL.y) > 1.0f) {
                x.v(this.gJf.TAG, "check long press timeout, but view has moved.");
            } else if (this.gJf.gJb != null) {
                this.gJf.gJc = false;
                this.gJf.gIY.removeCallbacks(this.gJf.gJd);
            }
        }
    }
}
