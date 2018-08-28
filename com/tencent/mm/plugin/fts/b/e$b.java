package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.a;
import com.tencent.mm.plugin.fts.c.b;
import com.tencent.mm.plugin.fts.c.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class e$b extends h {
    final /* synthetic */ e juS;

    public e$b(e eVar, i iVar) {
        this.juS = eVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        m k;
        jVar.jrx = g.ax(this.jsj.bWm, true);
        x.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[]{jVar.jrx.aQa().replaceAll("​", ",")});
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.jsj.jst);
        jVar.jsx = new ArrayList();
        HashSet hashSet2 = new HashSet();
        e eVar = this.juS.juO;
        g gVar = jVar.jrx;
        int[] iArr = this.jsj.jsq;
        int i = this.jsj.scene;
        int size = this.jsj.jss + this.jsj.jst.size();
        String str = gVar.jrV + '%';
        String aQa = gVar.aQa();
        String str2 = "query LIKE ?";
        aQa = String.format("AND %s MATCH '%s'", new Object[]{eVar.aPV(), aQa});
        String str3 = "AND type IN " + d.l(iArr);
        String str4 = "AND status >= 0 AND score >= 3";
        String str5 = size > 0 ? "LIMIT " + size : "";
        long size2 = (long) gVar.jrZ.size();
        Cursor rawQuery = eVar.jpT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[]{eVar.aPU(), eVar.aPV(), Long.valueOf(size2), eVar.aPV(), eVar.aPU(), str2, aQa, str3, "AND scene=?", str4, eVar.aPU(), eVar.aPV(), str5}), new String[]{str, String.valueOf(i)});
        while (rawQuery.moveToNext()) {
            try {
                k = new m().k(rawQuery);
                if (hashSet.add(k.jrv)) {
                    k.aQc();
                    k.userData = "";
                    if (k.type == 262144) {
                        k.userData = ((b) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(17)).qi((int) k.jsA);
                        if (k.userData == null) {
                            continue;
                        }
                    } else if (k.type == 131072 && e.CL(k.jrv)) {
                        hashSet2.add(k.jrv);
                    }
                    jVar.jsx.add(k);
                    if (jVar.jsx.size() >= this.jsj.jss) {
                        break;
                    }
                }
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
        rawQuery.close();
        x.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[]{Integer.valueOf(jVar.jsx.size())});
        if (jVar.jrx.jrX.length > 1) {
            if (jVar.jsx.size() > 2) {
                jVar.jsx = jVar.jsx.subList(0, 2);
            }
            hashSet.clear();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jVar.jsx.size()) {
                    break;
                }
                hashSet.add(((l) jVar.jsx.get(i3)).jrv);
                i2 = i3 + 1;
            }
            HashSet hashSet3 = new HashSet();
            e eVar2 = this.juS.juO;
            gVar = jVar.jrx;
            int[] iArr2 = this.jsj.jsq;
            size = this.jsj.scene;
            int size3 = this.jsj.jss + this.jsj.jst.size();
            String aQa2 = gVar.aQa();
            Cursor rawQuery2 = eVar2.jpT.rawQuery(String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + size + (" AND type IN " + d.l(iArr2)) + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[]{eVar2.aPV(), aQa2}) + " ORDER BY score desc limit " + size3 + ";", new Object[]{eVar2.aPU(), eVar2.aPV(), eVar2.aPU(), eVar2.aPV(), eVar2.aPU(), eVar2.aPV()}), new String[]{"​chatroom_tophits"});
            while (rawQuery2.moveToNext()) {
                aQa2 = rawQuery2.getString(0);
                if (!hashSet.contains(aQa2)) {
                    hashSet3.add(aQa2);
                }
            }
            rawQuery2.close();
            a aVar = (a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(3);
            Iterator it = hashSet3.iterator();
            while (it.hasNext()) {
                String str6 = (String) it.next();
                gVar = jVar.jrx;
                String aQa3 = gVar.aQa();
                long size4 = (long) gVar.jrZ.size();
                rawQuery = aVar.jpT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[]{aVar.aPU(), aVar.aPV(), Long.valueOf(size4), aVar.aPU(), aVar.aPV(), aVar.aPU(), aVar.aPV(), aVar.aPV(), aQa3}), new String[]{str6});
                if (rawQuery.moveToNext()) {
                    k = new m().k(rawQuery);
                    k.userData = "​chatroom_tophits";
                    k.aQc();
                    jVar.jsx.add(k);
                    if (jVar.jsx.size() >= this.jsj.jss) {
                        break;
                    }
                }
                rawQuery.close();
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            this.juS.CH((String) it2.next());
        }
    }

    public final String getName() {
        return "SearchTopHitsTask";
    }

    public final int getId() {
        return 8;
    }
}
