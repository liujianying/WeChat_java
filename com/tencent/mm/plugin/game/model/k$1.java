package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class k$1 implements Runnable {
    final /* synthetic */ LinkedList jLR;

    k$1(LinkedList linkedList) {
        this.jLR = linkedList;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.jLR.iterator();
        while (it.hasNext()) {
            Iterator it2 = j.m(((k) it.next()).optJSONArray("items")).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (!bi.oW(dVar.field_appId)) {
                    linkedList.add(dVar.field_appId);
                }
            }
        }
        it = c.aVi().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!linkedList.contains(fVar.field_appId)) {
                a.bmf().b(fVar, new String[0]);
                x.i("MicroMsg.GameDataSearchGameList", "delete appid : " + fVar.field_appId);
            }
        }
    }
}
