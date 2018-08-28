package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;

class h$1 implements d {
    final /* synthetic */ ArrayList eIj;
    final /* synthetic */ h eNl;

    h$1(h hVar, ArrayList arrayList) {
        this.eNl = hVar;
        this.eIj = arrayList;
    }

    public final void bx(int i, int i2) {
        if (i2 != -1) {
            this.eNl.pD(((n) this.eIj.get(i2)).field_googlegmail);
        }
    }
}
