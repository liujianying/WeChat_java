package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.io;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$2 extends c<io> {
    final /* synthetic */ e pUl;

    e$2(e eVar) {
        this.pUl = eVar;
        this.sFo = io.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        io ioVar = (io) bVar;
        if (!(ioVar instanceof io)) {
            return false;
        }
        h.bYs().b(ioVar.bRY.bRZ, ioVar.bRY.bjW, ioVar.bRY.bSa);
        return true;
    }
}
