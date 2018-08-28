package com.tencent.mm.insane_statistic;

import com.tencent.mm.modelstat.b;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.h;

public final class a implements com.tencent.mm.modelstat.r.a {
    public final void f(bd bdVar) {
        if (bdVar.aQm()) {
            b.ehL.a(bdVar, h.g(bdVar));
        } else {
            b.ehL.f(bdVar);
        }
    }
}
