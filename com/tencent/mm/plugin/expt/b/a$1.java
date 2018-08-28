package com.tencent.mm.plugin.expt.b;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<lw> {
    final /* synthetic */ a iHY;

    a$1(a aVar) {
        this.iHY = aVar;
        super(0);
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        a.a(this.iHY);
        x.d("MicroMsg.ExptService", "got post sync event [%d]", new Object[]{Integer.valueOf(a.b(this.iHY))});
        a.c(this.iHY);
        return false;
    }
}
