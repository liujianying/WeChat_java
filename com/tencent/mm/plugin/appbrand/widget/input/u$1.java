package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import com.tencent.mm.sdk.platformtools.x;

class u$1 implements Runnable {
    final /* synthetic */ u gIs;

    u$1(u uVar) {
        this.gIs = uVar;
    }

    public final void run() {
        if (u.a(this.gIs) != null && z.ak(u.a(this.gIs))) {
            if (u.a(this.gIs).apE()) {
                x.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
                this.gIs.post(this);
                return;
            }
            u.b(this.gIs);
        }
    }
}
