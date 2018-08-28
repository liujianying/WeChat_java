package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;

class e$15 implements a {
    final /* synthetic */ e pUl;

    e$15(e eVar) {
        this.pUl = eVar;
    }

    public final void a(d.a aVar) {
        new Thread(new 1(this, ab.a(aVar.dIN.rcl), e.bUY())).start();
    }
}
