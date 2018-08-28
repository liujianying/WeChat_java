package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import com.tencent.mm.g.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;

class e$5 extends c<b> {
    final /* synthetic */ e pUl;

    e$5(e eVar) {
        this.pUl = eVar;
        this.sFo = b.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        b bVar2 = (b) bVar;
        if (bVar2 instanceof b) {
            Intent intent = new Intent();
            if (bVar2.bFZ != null) {
                intent.putExtra("card_list", bVar2.bFZ.bGa);
                intent.putExtra("result_code", bVar2.bFZ.bjW);
            }
            if (bVar2.bFZ == null || bVar2.bFZ.bjW != -1) {
                h.bYs().b(16, 0, intent);
            } else {
                h.bYs().b(16, -1, intent);
            }
        }
        return false;
    }
}
