package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements e {
    final /* synthetic */ c dZb;

    c$2(c cVar) {
        this.dZb = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        lVar.dJc = true;
    }
}
