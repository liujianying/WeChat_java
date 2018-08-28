package com.tencent.mm.plugin.gwallet.a;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.3;

class b$3$1 implements Runnable {
    final /* synthetic */ c kjc;
    final /* synthetic */ Intent kjd;
    final /* synthetic */ 3 kje;

    b$3$1(3 3, c cVar, Intent intent) {
        this.kje = 3;
        this.kjc = cVar;
        this.kjd = intent;
    }

    public final void run() {
        this.kje.kjb.b(this.kjc, this.kjd);
    }
}
