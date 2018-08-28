package com.tencent.mm.sandbox.updater;

import com.tencent.mm.g.a.sk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class h extends c<sk> {
    public h() {
        this.sFo = sk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sk skVar = (sk) bVar;
        if (skVar instanceof sk) {
            Updater c = Updater.c(skVar.cdi.context, null);
            if (c != null) {
                c.ah(skVar.cdi.type, true);
            }
        }
        return false;
    }
}
