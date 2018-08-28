package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class a$j extends h {
    final /* synthetic */ a jtJ;

    public a$j(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        jVar.jrx = g.ax(this.jsj.bWm, true);
        Cursor a = a.a(this.jtJ).a(jVar.jrx, this.jsj.jsq, this.jsj.jsr, true, true);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        while (a.moveToNext()) {
            m k = new m().k(a);
            if (!this.jsj.jst.contains(k.jrv)) {
                l lVar;
                if (d.f(c.jqk, k.type)) {
                    lVar = (l) hashMap.get(k.jrv);
                    if (lVar == null || d.c(c.jqv, k.jru, lVar.jru) < 0) {
                        hashMap.put(k.jrv, k);
                    }
                } else if (d.f(c.jqm, k.type)) {
                    lVar = (l) hashMap2.get(Long.valueOf(k.jsA));
                    if (lVar == null || d.c(c.jqv, k.jru, lVar.jru) < 0) {
                        hashMap2.put(Long.valueOf(k.jsA), k);
                    }
                }
                if (Thread.interrupted()) {
                    a.close();
                    throw new InterruptedException();
                }
            }
        }
        a.close();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        jVar.jsx = new ArrayList(hashMap.size());
        for (m mVar : hashMap.values()) {
            mVar.aQc();
            mVar.a(jVar.jrx);
            jVar.jsx.add(mVar);
        }
        jVar.jsx.addAll(hashMap2.values());
        if (Thread.interrupted()) {
            throw new InterruptedException();
        } else if (this.jsj.jsu != null) {
            Collections.sort(jVar.jsx, this.jsj.jsu);
        }
    }

    public final String getName() {
        return "SearchContactLogic.SearchTask";
    }

    public final int getId() {
        return 11;
    }
}
