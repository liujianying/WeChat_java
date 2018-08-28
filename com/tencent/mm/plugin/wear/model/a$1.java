package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;

class a$1 extends c {
    final /* synthetic */ a pIV;

    a$1(a aVar) {
        this.pIV = aVar;
    }

    protected final void send() {
        r.b(20001, null, false);
        r.b(20008, null, false);
    }

    public final String getName() {
        return "PhoneStartTask";
    }
}
