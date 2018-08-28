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
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class a$n extends h {
    final /* synthetic */ a jtJ;

    public a$n(a aVar, i iVar) {
        this.jtJ = aVar;
        super(iVar);
    }

    protected final void a(j jVar) {
        l lVar;
        jVar.jrx = g.ax(this.jsj.bWm, true);
        Cursor a = a.a(this.jtJ).a(jVar.jrx, new int[]{131075}, null, true, true);
        HashMap hashMap = new HashMap();
        while (a.moveToNext()) {
            m k = new m().k(a);
            if (!this.jsj.jst.contains(k.jrv)) {
                lVar = (l) hashMap.get(k.jrv);
                if (lVar == null || d.c(c.jqv, k.jru, lVar.jru) < 0) {
                    hashMap.put(k.jrv, k);
                }
                if (Thread.interrupted()) {
                    a.close();
                    throw new InterruptedException();
                }
            }
        }
        a.close();
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (m mVar : hashMap.values()) {
            mVar.aQc();
            mVar.a(jVar.jrx);
            arrayList.add(mVar);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
        if (this.jsj.jsu != null) {
            Collections.sort(arrayList, this.jsj.jsu);
        }
        jVar.jsx = new ArrayList(hashMap.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            lVar = (l) arrayList.get(i);
            stringBuffer.append(lVar.jrT);
            stringBuffer.append("|");
            stringBuffer.append(lVar.timestamp);
            stringBuffer.append(" ");
            jVar.jsx.add(lVar);
            if (i >= this.jsj.jss) {
                break;
            }
        }
        if (jVar.jrx.jrZ.size() > 1 && a.a(this.jtJ).b(jVar.jrx)) {
            lVar = new l();
            lVar.jrv = "create_chatroom​";
            jVar.jsx.add(0, lVar);
            stringBuffer.append(" needCreateChatroom");
        }
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[]{stringBuffer.toString()});
    }

    public final String getName() {
        return "SearchChatroomTask";
    }

    public final int getId() {
        return 19;
    }
}
