package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class c$i extends h {
    final /* synthetic */ c jux;

    private class a {
        int jru;
        String jrv;
        long jsA;
        long timestamp;
        int type;

        private a() {
        }

        /* synthetic */ a(c$i c_i, byte b) {
            this();
        }
    }

    public c$i(c cVar, i iVar) {
        this.jux = cVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        CA("start");
        jVar.jrx = g.a(this.jsj.bWm, false, this.jux.juw);
        c cVar = this.jux.jup;
        String aQa = jVar.jrx.aQa();
        Cursor rawQuery = cVar.jpT.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[]{cVar.aPU(), cVar.aPV(), cVar.aPU(), cVar.aPV(), cVar.aPV(), aQa}), null);
        List<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        List arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(3);
            if (hashSet.add(string)) {
                a aVar = new a(this, (byte) 0);
                aVar.type = rawQuery.getInt(0);
                aVar.jru = rawQuery.getInt(1);
                aVar.jsA = rawQuery.getLong(2);
                aVar.jrv = rawQuery.getString(3);
                aVar.timestamp = rawQuery.getLong(4);
                arrayList.add(aVar);
                arrayList2.add(string);
            }
            if (arrayList.size() > this.jsj.jss) {
                break;
            }
        }
        rawQuery.close();
        jVar.jsx = new LinkedList();
        CA("findUsername");
        if (arrayList2.size() > 0) {
            Cursor a = this.jux.jup.a(jVar.jrx, arrayList2);
            HashMap hashMap = new HashMap();
            if (a.moveToNext()) {
                String[] split = a.getString(0).split(" ");
                for (int i = 0; i < split.length; i += 2) {
                    hashMap.put(split[i], Integer.valueOf(split[i + 1]));
                }
            }
            a.close();
            for (a aVar2 : arrayList) {
                l lVar = new l();
                lVar.type = aVar2.type;
                lVar.jru = aVar2.jru;
                lVar.jsA = aVar2.jsA;
                lVar.jrv = aVar2.jrv;
                lVar.timestamp = aVar2.timestamp;
                if (hashMap.containsKey(lVar.jrv)) {
                    lVar.userData = hashMap.get(lVar.jrv);
                } else {
                    lVar.userData = Integer.valueOf(1);
                }
                jVar.jsx.add(lVar);
            }
            CA("findCount");
        }
        if (jVar.jrx.jrY.length > 1 && jVar.jsx.size() <= 3) {
            rawQuery = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(3)).a(g.ax(jVar.jrx.jrY[0], true), null, com.tencent.mm.plugin.fts.a.c.jql, com.tencent.mm.plugin.fts.a.c.jqp);
            if (rawQuery.moveToNext()) {
                l lVar2 = new l();
                lVar2.jrv = "create_talker_message​";
                jVar.jsx.add(lVar2);
            }
            rawQuery.close();
            CA("findTalkerConversation");
        }
    }

    public final String getName() {
        return "SearchLimitGroupMessage";
    }

    public final int getId() {
        return 24;
    }
}
