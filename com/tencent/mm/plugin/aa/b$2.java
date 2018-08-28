package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.ml;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends c<ml> {
    final /* synthetic */ b ezx;

    b$2(b bVar) {
        this.ezx = bVar;
        this.sFo = ml.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ml mlVar = (ml) bVar;
        x.i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", new Object[]{Long.valueOf(mlVar.bXr.bXs), bi.Xf(mlVar.bXr.bWW)});
        h.f(r0, r2);
        return false;
    }
}
