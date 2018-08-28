package com.tencent.mm.ui;

import com.tencent.mm.g.a.qv;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.ui.MMAppMgr.8;

class MMAppMgr$8$1 implements Runnable {
    final /* synthetic */ 8 tns;

    MMAppMgr$8$1(8 8) {
        this.tns = 8;
    }

    public final void run() {
        m.TK().run();
        o.Tf().run();
        com.tencent.mm.ak.o.Pd().run();
        ao.cca().run();
        if (a.dBu != null) {
            a.dBu.HF();
        }
        com.tencent.mm.sdk.b.a.sFg.m(new qv());
        au.HU();
        c.FQ().b(null);
    }
}
