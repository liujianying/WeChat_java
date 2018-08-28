package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.it;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;

class w$3 extends c<it> {
    final /* synthetic */ w tQO;

    w$3(w wVar) {
        this.tQO = wVar;
        this.sFo = it.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        it itVar = (it) bVar;
        if ((itVar instanceof it) && this.tQO.qLA && (itVar.bSl.bSm == null || itVar.bSl.bSm.equals(this.tQO.bSm))) {
            if (itVar.bSl.type == 1) {
                ah.A(w.a(this.tQO));
            } else if (itVar.bSl.type == 2) {
                w.b(this.tQO);
                ah.A(w.c(this.tQO));
            }
        }
        return false;
    }
}
