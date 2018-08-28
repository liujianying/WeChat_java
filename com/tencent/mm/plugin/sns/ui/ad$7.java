package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.ui.base.s;

class ad$7 implements Runnable {
    final /* synthetic */ ad nPa;

    ad$7(ad adVar) {
        this.nPa = adVar;
    }

    public final void run() {
        s.makeText(this.nPa.bGc, i$j.sendrequest_send_fail, 0).show();
    }
}
