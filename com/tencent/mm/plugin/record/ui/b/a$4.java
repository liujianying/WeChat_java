package com.tencent.mm.plugin.record.ui.b;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$4 extends c<mu> {
    final /* synthetic */ a mtv;

    a$4(a aVar) {
        this.mtv = aVar;
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        this.mtv.iYQ.put(muVar.bXK.filePath, muVar);
        if (this.mtv.fUH != null && this.mtv.fUH.ofo.isShowing()) {
            this.mtv.jcS.onLongClick(null);
        }
        return true;
    }
}
