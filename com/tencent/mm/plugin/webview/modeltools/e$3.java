package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.k;
import com.tencent.mm.plugin.webview.ui.tools.bag.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$3 extends c<k> {
    final /* synthetic */ e pUl;

    e$3(e eVar) {
        this.pUl = eVar;
        this.sFo = k.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        k kVar = (k) bVar;
        if (kVar.bGu == null) {
            return false;
        }
        x.i("MicroMsg.SubCoreTools", "appActiveListener isActive:%b", new Object[]{Boolean.valueOf(kVar.bGu.bGv)});
        if (kVar.bGu.bGv) {
            j.qcm.nc(true);
        } else {
            j.qcm.bWV();
        }
        return true;
    }
}
