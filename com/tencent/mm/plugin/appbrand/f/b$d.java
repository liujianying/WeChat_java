package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$d extends a {
    final /* synthetic */ b fyH;
    private int fyI;

    b$d(b bVar) {
        this.fyH = bVar;
    }

    public final boolean execute() {
        List<k> afG = i.afG();
        if (afG.isEmpty()) {
            x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
            return true;
        }
        this.fyI = afG.size();
        this.fyH.fyF.beginTransaction();
        this.fyH.fyF.k(c.jqg);
        for (k kVar : afG) {
            String oV = bi.oV(kVar.dfX);
            int hashCode = oV.hashCode();
            long currentTimeMillis = System.currentTimeMillis();
            this.fyH.fyF.a(393216, 1, (long) hashCode, oV, currentTimeMillis, kVar.appName);
            this.fyH.fyF.a(393216, 2, (long) hashCode, oV, currentTimeMillis, d.av(kVar.appName, false));
            this.fyH.fyF.a(393216, 3, (long) hashCode, oV, currentTimeMillis, d.av(kVar.appName, true));
        }
        this.fyH.fyF.commit();
        return true;
    }

    public final String afC() {
        return String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.fyI)});
    }

    public final String getName() {
        return "UpdateWeAppIndexTask";
    }
}
