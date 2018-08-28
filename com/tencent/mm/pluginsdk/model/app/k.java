package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.y.g;

public final class k extends i<g> {
    public static final String[] diD = new String[]{i.a(g.dhO, "AppMessage")};

    public k(e eVar) {
        super(eVar, g.dhO, "AppMessage", null);
    }

    public final g fI(long j) {
        g gVar = new g();
        gVar.field_msgId = j;
        return super.b(gVar, new String[0]) ? gVar : null;
    }
}
