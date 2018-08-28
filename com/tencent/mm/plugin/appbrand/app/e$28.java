package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.id;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$28 extends c<id> {
    final /* synthetic */ e ffn;

    e$28(e eVar) {
        this.ffn = eVar;
        this.sFo = id.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        id idVar = (id) bVar;
        HCEEventLogic.b(idVar.bRE.appId, idVar.bRE.type, idVar.bRE.extras);
        return false;
    }
}
