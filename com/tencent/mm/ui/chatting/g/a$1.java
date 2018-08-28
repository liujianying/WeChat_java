package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.plugin.appbrand.q.b.a;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;

class a$1 implements a {
    final /* synthetic */ boolean tXV = true;
    final /* synthetic */ a tXW;

    a$1(a aVar) {
        this.tXW = aVar;
    }

    public final void w(LinkedList<d> linkedList) {
        if (!bi.cX(linkedList)) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                this.tXW.gBc.add(new a.a(this.tXW, dVar.timestamp, dVar.type, dVar.title, dVar.bJC, dVar.username, dVar.nickname, dVar.bgo, dVar.gBq, dVar.dyT, dVar.bXA, dVar.bYu, dVar.desc, dVar.imagePath));
            }
        }
        this.tXW.tYc = this.tXW.gBc;
        if (this.tXW.tXZ != null) {
            this.tXW.tXZ.y(this.tXV, this.tXW.gBc.size());
        }
    }
}
