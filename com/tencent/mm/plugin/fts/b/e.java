package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;

public final class e extends b {
    private m dhW;
    com.tencent.mm.plugin.fts.c.e juO;
    HashSet<String> juP;

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
            this.juP = new HashSet();
            this.juO = (com.tencent.mm.plugin.fts.c.e) ((n) g.n(n.class)).getFTSIndexStorage(1);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.dhW.a(65626, new a(this, (byte) 0));
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        if (this.juP != null) {
            this.juP.clear();
        }
        this.juO = null;
        this.dhW = null;
        return true;
    }

    public final a a(i iVar) {
        return this.dhW.a(-65536, new b(this, iVar));
    }

    public final void CH(String str) {
        if (this.juP.add(str)) {
            com.tencent.mm.plugin.fts.c.e eVar = this.juO;
            eVar.jvo.bindLong(1, 1);
            eVar.jvo.bindString(2, str);
            eVar.jvo.execute();
        }
    }

    public final void d(int[] iArr, String str) {
        this.juO.b(iArr, str);
    }

    public final String getName() {
        return "FTS5SearchTopHitsLogic";
    }

    public final void a(String str, l lVar, int i, HashMap<String, String> hashMap) {
        c cVar = new c(this, (byte) 0);
        c.a(cVar, str);
        c.a(cVar, lVar);
        c.a(cVar, i);
        c.a(cVar, hashMap);
        this.dhW.a(65626, cVar);
    }
}
