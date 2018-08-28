package com.tencent.mm.ar;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.br;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.QbSdk;

public final class o extends c<lw> {
    public o() {
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (bi.bG(bi.a((Long) g.Ei().DT().get(66818, null), 0)) * 1000 > 1800000) {
            int a = bi.a((Integer) g.Ei().DT().get(66820, null), QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                br.r(9, String.valueOf(a));
                g.Ei().DT().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            g.Ei().DT().set(66818, Long.valueOf(bi.VE()));
        }
        return false;
    }
}
