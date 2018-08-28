package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class e$7 extends c<bc> {
    final /* synthetic */ e pUl;

    e$7(e eVar) {
        this.pUl = eVar;
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (49 != bcVar.bIB.bIC || 1 != bcVar.bIB.bID) {
            return false;
        }
        if (bcVar.bIB.bIF) {
            x.i("MicroMsg.SubCoreTools", "receive xweb get config  notify!!");
            a.T(ad.getContext(), 5);
            return true;
        }
        x.i("MicroMsg.SubCoreTools", "receive xweb get config  notify!! fileUpdated == false ignore");
        return false;
    }
}
