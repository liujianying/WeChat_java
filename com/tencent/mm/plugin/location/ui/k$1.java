package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    final /* synthetic */ k kGI;

    k$1(k kVar) {
        this.kGI = kVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        this.kGI.aZJ();
        return false;
    }
}
