package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.gb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

final class l$a extends c<gb> {
    private l$a() {
        this.sFo = gb.class.getName().hashCode();
    }

    /* synthetic */ l$a(byte b) {
        this();
        this.sFo = gb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gb gbVar = (gb) bVar;
        if (!(gbVar instanceof gb)) {
            return false;
        }
        l.R(gbVar.bPi.bGS);
        return true;
    }
}
