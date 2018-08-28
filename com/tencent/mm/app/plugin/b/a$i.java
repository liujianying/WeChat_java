package com.tencent.mm.app.plugin.b;

import com.tencent.mm.g.a.fe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class a$i extends c<fe> {
    public a$i() {
        this.sFo = fe.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
        if (ad.getContext() == null) {
            x.w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
            return false;
        }
        com.tencent.mm.platformtools.x.cd(ad.getContext());
        return true;
    }
}
