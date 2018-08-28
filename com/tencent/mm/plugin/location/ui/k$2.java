package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements a {
    final /* synthetic */ k kGI;

    k$2(k kVar) {
        this.kGI = kVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
        k.a(this.kGI);
        return false;
    }
}
