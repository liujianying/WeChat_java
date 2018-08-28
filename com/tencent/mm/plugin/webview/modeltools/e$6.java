package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$6 extends c<bx> {
    final /* synthetic */ e pUl;

    e$6(e eVar) {
        this.pUl = eVar;
        this.sFo = bx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bx bxVar = (bx) bVar;
        if (bxVar instanceof bx) {
            Intent intent = new Intent();
            if (bxVar.bJo == null || bxVar.bJo.bjW != -1) {
                h.bYs().b(29, 0, intent);
            } else {
                h.bYs().b(29, -1, intent);
            }
        }
        return false;
    }
}
