package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.plugin.freewifi.ui.a.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class a$2$1 implements Runnable {
    final /* synthetic */ View jmm;
    final /* synthetic */ 2 jmn;

    a$2$1(2 2, View view) {
        this.jmn = 2;
        this.jmm = view;
    }

    public final void run() {
        bh bhVar = new bh();
        long currentTimeMillis = System.currentTimeMillis();
        a.sFg.m(bhVar);
        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "summeranrt CheckWechatFreeWifiEvent take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ah.A(new 1(this, bhVar));
    }
}
