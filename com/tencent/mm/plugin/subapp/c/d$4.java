package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.a.sq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;

class d$4 extends c<sq> {
    final /* synthetic */ d orm;

    d$4(d dVar) {
        this.orm = dVar;
        this.sFo = sq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = ((sq) bVar).cdv.path;
        if (str != null) {
            String aY = h.aY(str, false);
            if (!bi.oW(aY)) {
                d.bGt().jy(aY);
            }
            d.bGt().ol(str);
            new File(str).delete();
        }
        return false;
    }
}
