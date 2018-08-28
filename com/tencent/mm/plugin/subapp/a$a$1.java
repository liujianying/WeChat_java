package com.tencent.mm.plugin.subapp;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$a$1 implements a {
    final /* synthetic */ int oqo;
    final /* synthetic */ a.a oqp;

    a$a$1(a.a aVar, int i) {
        this.oqp = aVar;
        this.oqo = i;
    }

    public final boolean vD() {
        if (!this.oqp.oqf) {
            x.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[]{Integer.valueOf(this.oqo)});
            this.oqp.a(a.a.a.oqt);
        }
        return false;
    }
}
