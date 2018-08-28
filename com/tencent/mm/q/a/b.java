package com.tencent.mm.q.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class b extends a {
    public b(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return 33;
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        return null;
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        return null;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        c cVar = new c(i2);
        cVar.fyJ = lVar;
        cVar.jrx = aVar.jrx;
        cVar.cF(lVar.type, lVar.jru);
        return cVar;
    }
}
