package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.c.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class b$a extends a {
    final /* synthetic */ b jum;
    private int jun;
    private int juo;

    private b$a(b bVar) {
        this.jum = bVar;
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
        b bVar = this.jum.juk;
        List arrayList = new ArrayList();
        Cursor rawQuery = bVar.jpT.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
        while (rawQuery.moveToNext()) {
            c cVar = new c();
            cVar.d(rawQuery);
            arrayList.add(cVar);
        }
        rawQuery.close();
        if (arrayList.size() == 0) {
            try {
                arrayList = b.CF(b.aQl().getAbsolutePath());
                this.jum.juk.bl(arrayList);
            } catch (Exception e) {
            }
        }
        List<com.tencent.mm.plugin.fts.c.b$a> aQu = this.jum.juk.aQu();
        HashMap hashMap = new HashMap();
        for (c cVar2 : arrayList) {
            hashMap.put(Integer.valueOf(cVar2.field_featureId), cVar2);
        }
        if (this.jum.juk.jpT.inTransaction()) {
            this.jum.juk.commit();
        }
        this.jum.juk.beginTransaction();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (com.tencent.mm.plugin.fts.c.b$a b_a : aQu) {
            c cVar3 = (c) hashMap.remove(Integer.valueOf(b_a.jvi));
            if (cVar3 == null) {
                hashSet.add(Integer.valueOf(b_a.jvi));
            } else if (b_a.timestamp != cVar3.field_timestamp) {
                hashSet2.add(cVar3);
                this.jum.juk.b(com.tencent.mm.plugin.fts.a.c.jqe, Long.valueOf((long) cVar3.field_featureId).longValue());
                ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.jqe, String.valueOf(cVar3.field_featureId));
            }
        }
        hashSet2.addAll(hashMap.values());
        this.jum.juk.commit();
        this.jum.juk.beginTransaction();
        this.jun = hashSet.size();
        this.juo = hashSet2.size();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            c cVar4 = (c) it.next();
            b bVar2 = this.jum;
            bVar2.juk.a(262144, 1, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_title);
            String av = d.av(cVar4.field_title, false);
            if (!bi.oW(av)) {
                bVar2.juk.a(262144, 2, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, av);
            }
            av = d.av(cVar4.field_title, true);
            if (!bi.oW(av)) {
                bVar2.juk.a(262144, 3, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, av);
            }
            bVar2.juk.a(262144, 4, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_tag);
            ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic().CH(String.valueOf(cVar4.field_featureId));
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.jum.juk.b(com.tencent.mm.plugin.fts.a.c.jqe, Long.valueOf((long) ((Integer) it2.next()).intValue()).longValue());
        }
        this.jum.juk.commit();
        return true;
    }

    public final String afC() {
        return String.format("{remove: %d add: %d}", new Object[]{Integer.valueOf(this.jun), Integer.valueOf(this.juo)});
    }

    public final String getName() {
        return "BuildFeatureIndexTask";
    }

    public final int getId() {
        return 5;
    }
}
