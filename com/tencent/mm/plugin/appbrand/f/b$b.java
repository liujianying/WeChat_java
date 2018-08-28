package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$b extends a {
    final /* synthetic */ b fyH;
    private String id;
    private String name;

    public b$b(b bVar, String str) {
        this.fyH = bVar;
        this.id = str;
    }

    public final boolean execute() {
        this.fyH.fyF.beginTransaction();
        this.fyH.fyF.b(c.jqg, this.id);
        k sK = i.sK(this.id);
        if (sK != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String oV = bi.oV(sK.dfX);
            int hashCode = oV.hashCode();
            this.fyH.fyF.a(393216, 1, (long) hashCode, oV, currentTimeMillis, sK.appName);
            this.fyH.fyF.a(393216, 2, (long) hashCode, oV, currentTimeMillis, d.av(sK.appName, false));
            this.fyH.fyF.a(393216, 3, (long) hashCode, oV, currentTimeMillis, d.av(sK.appName, true));
            this.name = sK.appName;
            x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[]{oV});
        }
        this.fyH.fyF.commit();
        return true;
    }

    public final String getName() {
        return "InsertWeAppTask";
    }

    public final String afC() {
        return String.format("{name: %s id: %s}", new Object[]{this.name, this.id});
    }
}
