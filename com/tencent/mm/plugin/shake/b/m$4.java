package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

class m$4 implements a {
    final /* synthetic */ m mXg;

    m$4(m mVar) {
        this.mXg = mVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
        } else {
            m.a(this.mXg).post(new 1(this, a, aVar));
        }
    }
}
