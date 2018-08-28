package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m dhW;
    a fAB;
    private a fAC = new 1(this);

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private int fAF;
        private List<String> idList;

        public b(List list) {
            this.idList = list;
        }

        public final boolean execute() {
            if (bi.cX(this.idList)) {
                return false;
            }
            this.fAF = this.idList.size();
            x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id listSize:%d", new Object[]{Integer.valueOf(this.fAF)});
            b.this.fAB.beginTransaction();
            for (String str : this.idList) {
                b.this.fAB.b(c.jqh, str);
                com.tencent.mm.plugin.appbrand.game.a.a.b sO = i.sO(str);
                if (sO == null || bi.oW(sO.field_AppName)) {
                    x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted miniGame info is null. id:%s", new Object[]{str});
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    String oV = bi.oV(sO.field_RecordId);
                    int hashCode = oV.hashCode();
                    b.this.fAB.a(458752, 1, (long) hashCode, oV, currentTimeMillis, sO.field_AppName);
                    b.this.fAB.a(458752, 2, (long) hashCode, oV, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.av(sO.field_AppName, false));
                    b.this.fAB.a(458752, 3, (long) hashCode, oV, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.av(sO.field_AppName, true));
                    x.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id = %s, name = %s", new Object[]{oV, sO.field_AppName});
                }
            }
            b.this.fAB.commit();
            return true;
        }

        public final String getName() {
            return "InsertMiniGameTask";
        }

        public final String afC() {
            return String.format("{insertSize: %d}", new Object[]{Integer.valueOf(this.fAF)});
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int fyI;

        d() {
        }

        public final boolean execute() {
            List<com.tencent.mm.plugin.appbrand.game.a.a.b> agp = i.agp();
            if (agp == null || agp.isEmpty()) {
                x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame search list is nil.");
                return true;
            }
            this.fyI = agp.size();
            b.this.fAB.beginTransaction();
            b.this.fAB.k(c.jqh);
            for (com.tencent.mm.plugin.appbrand.game.a.a.b bVar : agp) {
                if (bVar == null || bi.oW(bVar.field_AppName)) {
                    x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "UpdateMiniGameIndexTask appname is null");
                    this.fyI--;
                } else {
                    String oV = bi.oV(bVar.field_RecordId);
                    int hashCode = oV.hashCode();
                    long currentTimeMillis = System.currentTimeMillis();
                    b.this.fAB.a(458752, 1, (long) hashCode, oV, currentTimeMillis, bVar.field_AppName);
                    b.this.fAB.a(458752, 2, (long) hashCode, oV, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.av(bVar.field_AppName, false));
                    b.this.fAB.a(458752, 3, (long) hashCode, oV, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.av(bVar.field_AppName, true));
                }
            }
            b.this.fAB.commit();
            x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "update MiniGame info id listSize:%d", new Object[]{Integer.valueOf(this.fyI)});
            return true;
        }

        public final String afC() {
            return String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.fyI)});
        }

        public final String getName() {
            return "UpdateMiniGameIndexTask";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        return this.dhW.a(-65536, new c(this, iVar));
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Success!");
            this.fAB = (a) ((n) g.n(n.class)).getFTSIndexStorage(8);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.dhW.a(65601, new d());
            i.onCreate();
            i.e(this.fAC);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        i.onDestroy();
        i.f(this.fAC);
        this.fAB = null;
        this.dhW = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchMiniGameLogic";
    }
}
