package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$a extends a {
    final /* synthetic */ b fAD;
    private int fAE;
    private List<String> idList;

    public b$a(b bVar, List list) {
        this.fAD = bVar;
        this.idList = list;
    }

    public final boolean execute() {
        if (bi.cX(this.idList)) {
            return false;
        }
        this.fAE = this.idList.size();
        x.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "delete MiniGame info id listSize:%d", new Object[]{Integer.valueOf(this.fAE)});
        for (String b : this.idList) {
            this.fAD.fAB.b(c.jqh, b);
        }
        return true;
    }

    public final String getName() {
        return "DeleteMiniGameTask";
    }

    public final String afC() {
        return String.format("{deleteSize: %d}", new Object[]{Integer.valueOf(this.fAE)});
    }
}
