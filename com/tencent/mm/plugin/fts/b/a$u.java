package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

class a$u extends a {
    final /* synthetic */ a jtJ;
    private int juf;
    private int jug;
    private int juh;

    private a$u(a aVar) {
        this.jtJ = aVar;
        this.juf = 0;
        this.jug = 0;
        this.juh = 0;
    }

    /* synthetic */ a$u(a aVar, byte b) {
        this(aVar);
    }

    public final boolean execute() {
        String str;
        int i;
        CA("start");
        Iterator it = a.b(this.jtJ).entrySet().iterator();
        int i2 = 50;
        while (it.hasNext()) {
            if (Thread.interrupted()) {
                a.a(this.jtJ).commit();
                throw new InterruptedException();
            }
            int i3;
            if (i2 >= 50) {
                a.a(this.jtJ).commit();
                a.a(this.jtJ).beginTransaction();
                i3 = 0;
            } else {
                i3 = i2;
            }
            Entry entry = (Entry) it.next();
            for (Long longValue : (List) entry.getValue()) {
                a.a(this.jtJ).g(Long.valueOf(longValue.longValue()));
                i3++;
            }
            str = (String) entry.getKey();
            ab Co = a.d(this.jtJ).Co(str);
            if (Co != null && Co.field_username.length() > 0 && this.jtJ.E(Co)) {
                i3 += this.jtJ.F(Co);
            }
            i = i3;
            it.remove();
            a.c(this.jtJ).remove(str);
            this.juf++;
            i2 = i;
        }
        CA("dirtyContact");
        Iterator it2 = a.c(this.jtJ).iterator();
        while (it2.hasNext()) {
            if (Thread.interrupted()) {
                a.a(this.jtJ).commit();
                throw new InterruptedException();
            }
            if (i2 >= 50) {
                a.a(this.jtJ).commit();
                a.a(this.jtJ).beginTransaction();
                i = 0;
            } else {
                i = i2;
            }
            str = (String) it2.next();
            long Cq = a.d(this.jtJ).Cq(str);
            ab Co2 = a.d(this.jtJ).Co(str);
            if (Co2 == null || Co2.field_username.length() <= 0 || !this.jtJ.E(Co2)) {
                i2 = i;
            } else {
                a.a(this.jtJ).D(str, Cq);
                i2 = i + 1;
            }
            it2.remove();
            this.jug++;
        }
        a.a(this.jtJ).commit();
        CA("timestampContact");
        e topHitsLogic = ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic();
        topHitsLogic.juP.clear();
        this.juh = topHitsLogic.juO.aQv();
        CA("topHits");
        return true;
    }

    public final String afC() {
        return String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[]{Integer.valueOf(this.juf), Integer.valueOf(this.jug), Integer.valueOf(this.juh)});
    }

    public final String getName() {
        return "UpdateDirtyAndTimestampContactTask";
    }

    public final int getId() {
        return 16;
    }
}
