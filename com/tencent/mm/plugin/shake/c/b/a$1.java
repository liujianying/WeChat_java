package com.tencent.mm.plugin.shake.c.b;

import com.tencent.mm.g.a.pf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<pf> {
    final /* synthetic */ a mYd;

    a$1(a aVar) {
        this.mYd = aVar;
        this.sFo = pf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        this.mYd.dismiss();
        if (a.a(this.mYd) != null) {
            a.a(this.mYd).buR();
        }
        x.i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
        return false;
    }
}
