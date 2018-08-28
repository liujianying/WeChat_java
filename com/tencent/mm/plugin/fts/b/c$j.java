package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class c$j extends h {
    final /* synthetic */ c jux;

    public c$j(c cVar, i iVar) {
        this.jux = cVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        l lVar;
        CA("start");
        jVar.jrx = g.a(this.jsj.bWm, false, this.jux.juw);
        g ax = g.ax(this.jsj.jsp, true);
        HashMap hashMap = new HashMap();
        Cursor a = ((a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(3)).a(ax, null, c.jql, c.jqp);
        while (a.moveToNext()) {
            m mVar = new m();
            mVar.jrv = a.getString(0);
            mVar.type = a.getInt(1);
            mVar.jru = a.getInt(2);
            mVar.jrx = ax;
            if (!hashMap.containsKey(mVar.jrv)) {
                hashMap.put(mVar.jrv, mVar);
            }
            if (hashMap.size() > 100) {
                break;
            }
        }
        a.close();
        CA("findHitContact");
        Cursor a2 = this.jux.jup.a(jVar.jrx, null, hashMap.keySet());
        HashMap hashMap2 = new HashMap();
        while (a2.moveToNext()) {
            HashMap hashMap3;
            m i = new m().i(a2);
            i.jrx = jVar.jrx;
            i.userData = Integer.valueOf(1);
            if (hashMap2.containsKey(i.talker)) {
                hashMap3 = (HashMap) hashMap2.get(i.talker);
            } else {
                hashMap3 = new HashMap();
            }
            if (hashMap3.containsKey(i.jrv)) {
                lVar = (l) hashMap3.get(i.jrv);
                int intValue = ((Integer) lVar.userData).intValue() + 1;
                if (lVar.timestamp < i.timestamp) {
                    i.userData = Integer.valueOf(intValue);
                    hashMap3.put(i.jrv, i);
                } else {
                    lVar.userData = Integer.valueOf(intValue);
                    hashMap3.put(lVar.jrv, lVar);
                }
            } else {
                hashMap3.put(i.jrv, i);
            }
            hashMap2.put(i.talker, hashMap3);
        }
        a2.close();
        jVar.jsx = new ArrayList();
        for (l lVar2 : hashMap.values()) {
            if (hashMap2.containsKey(lVar2.jrv)) {
                List arrayList = new ArrayList();
                arrayList.addAll(((HashMap) hashMap2.get(lVar2.jrv)).values());
                Collections.sort(arrayList, this.jsj.jsu);
                lVar2.userData = arrayList;
                lVar2.timestamp = ((l) arrayList.get(0)).timestamp;
                jVar.jsx.add(lVar2);
            }
        }
        Collections.sort(jVar.jsx, this.jsj.jsu);
        CA("findHitMessage");
    }

    public final String getName() {
        return "SearchTalkerMessageTask";
    }

    public final int getId() {
        return 28;
    }
}
