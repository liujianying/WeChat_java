package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$b extends a {
    final /* synthetic */ b iXs;
    private long iXx;

    public b$b(b bVar, long j) {
        this.iXs = bVar;
        this.iXx = j;
    }

    public final boolean execute() {
        x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
        this.iXs.iXp.b(c.jqd, this.iXx);
        return true;
    }

    public final String afC() {
        return String.format("{favItemId: %d}", new Object[]{Long.valueOf(this.iXx)});
    }

    public final String getName() {
        return "DeleteFavItemTask";
    }
}
