package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aa.a;

class b$1 implements Runnable {
    final /* synthetic */ String gdc;
    final /* synthetic */ b oCw;

    b$1(b bVar, String str) {
        this.oCw = bVar;
        this.gdc = str;
    }

    public final void run() {
        g.Ei().DT().a(a.tac, this.gdc);
        e.b("/sdcard/test.json", this.gdc.getBytes(), this.gdc.getBytes().length);
    }
}
