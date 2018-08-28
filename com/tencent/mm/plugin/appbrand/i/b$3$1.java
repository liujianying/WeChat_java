package com.tencent.mm.plugin.appbrand.i;

import android.app.Dialog;
import com.tencent.mm.plugin.appbrand.i.b.3;

class b$3$1 implements Runnable {
    final /* synthetic */ 3 gkw;

    b$3$1(3 3) {
        this.gkw = 3;
    }

    public final void run() {
        if (this.gkw.gku.value != null) {
            ((Dialog) this.gkw.gku.value).dismiss();
        }
    }
}
