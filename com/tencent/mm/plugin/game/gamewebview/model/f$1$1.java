package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.plugin.game.gamewebview.model.f.1;
import com.tencent.mm.plugin.game.gamewebview.model.f.c;

class f$1$1 implements Runnable {
    final /* synthetic */ IPCRunCgiRespWrapper jId;
    final /* synthetic */ 1 jIe;

    f$1$1(1 1, IPCRunCgiRespWrapper iPCRunCgiRespWrapper) {
        this.jIe = 1;
        this.jId = iPCRunCgiRespWrapper;
    }

    public final void run() {
        c cVar = this.jIe.jIc.jIb;
        int i = this.jId.errType;
        int i2 = this.jId.errCode;
        String str = this.jId.Yy;
        cVar.a(i, i2, this.jId.diG);
    }
}
