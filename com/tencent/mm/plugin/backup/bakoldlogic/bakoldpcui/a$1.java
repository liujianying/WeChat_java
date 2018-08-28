package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.g.a.lm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$1 extends c<lm> {
    final /* synthetic */ a haA;

    a$1(a aVar) {
        this.haA = aVar;
        this.sFo = lm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        this.haA.getView().post(new 1(this));
        return false;
    }
}
