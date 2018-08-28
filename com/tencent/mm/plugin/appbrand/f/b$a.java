package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$a extends a {
    final /* synthetic */ b fyH;
    private String id;

    public b$a(b bVar, String str) {
        this.fyH = bVar;
        this.id = str;
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[]{this.id});
        this.fyH.fyF.b(c.jqg, this.id);
        return true;
    }

    public final String getName() {
        return "DeleteWeAppTask";
    }

    public final String afC() {
        return String.format("{id: %s}", new Object[]{this.id});
    }
}
