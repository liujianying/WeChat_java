package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class b$c extends h {
    final /* synthetic */ b jum;

    /* synthetic */ b$c(b bVar, i iVar, byte b) {
        this(bVar, iVar);
    }

    private b$c(b bVar, i iVar) {
        this.jum = bVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        jVar.jrx = g.ax(this.jsj.bWm, true);
        jVar.jsx = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor a = this.jum.juk.a(jVar.jrx, c.jqe, this.jsj.jsr, true, true);
        while (a.moveToNext()) {
            m mVar = new m();
            mVar.k(a);
            if (!(hashSet.contains(Long.valueOf(mVar.jsA)) || this.jsj.jst.contains(mVar.jrv))) {
                mVar.aQc();
                jVar.jsx.add(mVar);
                hashSet.add(Long.valueOf(mVar.jsA));
            }
        }
        if (a != null) {
            a.close();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.jsj.jsu != null) {
            Collections.sort(jVar.jsx, this.jsj.jsu);
        }
        for (l lVar : jVar.jsx) {
            lVar.userData = this.jum.juk.qi((int) lVar.jsA);
        }
    }

    public final String getName() {
        return "SearchFeatureTask";
    }

    public final int getId() {
        return 12;
    }
}
