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
import java.util.Map.Entry;

class c$g extends h {
    final /* synthetic */ c jux;

    public c$g(c cVar, i iVar) {
        this.jux = cVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        CA("start");
        jVar.jrx = g.a(this.jsj.bWm, false, this.jux.juw);
        g ax = g.ax(this.jsj.jsp, true);
        HashMap hashMap = new HashMap();
        Cursor a = ((a) ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexStorage(3)).a(ax, this.jsj.talker, c.jql, c.jqp);
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
        Cursor a2 = this.jux.jup.a(jVar.jrx, this.jsj.jso, hashMap.keySet());
        HashMap hashMap2 = new HashMap();
        while (a2.moveToNext()) {
            List list;
            m i = new m().i(a2);
            i.jrx = jVar.jrx;
            if (hashMap2.containsKey(i.talker)) {
                list = (List) hashMap2.get(i.talker);
            } else {
                list = new ArrayList();
            }
            list.add(i);
            hashMap2.put(i.talker, list);
        }
        a2.close();
        jVar.jsx = new ArrayList();
        for (Entry entry : hashMap2.entrySet()) {
            l lVar = (l) hashMap.get(entry.getKey());
            if (lVar != null) {
                Collections.sort((List) entry.getValue(), this.jsj.jsu);
                lVar.userData = entry.getValue();
                lVar.timestamp = ((l) ((List) entry.getValue()).get(0)).timestamp;
                jVar.jsx.add(lVar);
            }
        }
        Collections.sort(jVar.jsx, this.jsj.jsu);
        CA("findHitMessage");
    }

    public final String getName() {
        return "SearchConvTalkerMessageTask";
    }

    public final int getId() {
        return 29;
    }
}
