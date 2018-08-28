package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

class a$d extends a {
    private String cYO;
    final /* synthetic */ a jtJ;
    private int jtX = 0;

    public a$d(a aVar, String str) {
        this.jtJ = aVar;
        this.cYO = str;
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[]{this.cYO});
        a.a(this.jtJ).b(c.jqk, this.cYO);
        ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic().d(c.jqk, this.cYO);
        Cursor CJ = a.a(this.jtJ).CJ(this.cYO);
        HashSet hashSet = new HashSet();
        while (CJ.moveToNext()) {
            hashSet.add(CJ.getString(0));
        }
        CJ.close();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!a.b(this.jtJ).containsKey(str)) {
                a.b(this.jtJ).put(str, a.a(this.jtJ).c(c.jqk, str));
                ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic().CH(str);
                this.jtX++;
            }
        }
        return true;
    }

    public final String afC() {
        return String.format("{username: %s mDirtyCount: %d}", new Object[]{this.cYO, Integer.valueOf(this.jtX)});
    }

    public final String getName() {
        return "DeleteContactTask";
    }
}
