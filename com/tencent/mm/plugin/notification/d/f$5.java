package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.cg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$5 extends c<cg> {
    final /* synthetic */ f lIj;

    f$5(f fVar) {
        this.lIj = fVar;
        this.sFo = cg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        f.a(this.lIj).bkk().dismiss();
        f.b(this.lIj).bkk().dismiss();
        x.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
        return false;
    }
}
