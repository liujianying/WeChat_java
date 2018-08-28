package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.rx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class i$5 extends c<rx> {
    final /* synthetic */ i uqR;

    i$5(i iVar) {
        this.uqR = iVar;
        this.sFo = rx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (i.a(this.uqR) == null) {
            x.i("MicroMsg.InitHelper", "inithelper hasn't initialized");
        } else {
            i.b(this.uqR);
            i.c(this.uqR);
        }
        return false;
    }
}
