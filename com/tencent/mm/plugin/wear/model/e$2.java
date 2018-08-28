package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;

class e$2 implements a {
    final /* synthetic */ e pJo;

    e$2(e eVar) {
        this.pJo = eVar;
    }

    public final void a(f fVar, c cVar) {
        if (cVar != null && cVar.lcA > 0 && a.bSl().pIM.pJe.pJU.equals(cVar.talker)) {
            a.bSl().pIS.a(new 1(this));
        }
    }
}
