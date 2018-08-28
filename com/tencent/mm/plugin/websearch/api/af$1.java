package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class af$1 implements Runnable {
    final /* synthetic */ af pMC;

    af$1(af afVar) {
        this.pMC = afVar;
    }

    public final void run() {
        a aVar = b.dnp;
        c fJ = a.fJ("100387");
        if (fJ == null) {
            x.i("WebSearchXWeb", "openSearchPreload item is null");
            return;
        }
        af afVar = this.pMC;
        boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("isOpen"));
        af.a(afVar, z);
    }
}
