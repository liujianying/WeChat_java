package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.bu.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements c<IPCRunCgiRespWrapper> {
    final /* synthetic */ f jIc;

    public f$1(f fVar) {
        this.jIc = fVar;
    }

    public final /* synthetic */ void at(Object obj) {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
        if (this.jIc.jIb != null) {
            x.i("MicroMsg.GameWebViewGetA8KeyHelp", "callback(%d), this(%d)", new Object[]{Integer.valueOf(this.jIc.jIb.hashCode()), Integer.valueOf(hashCode())});
            a.ab(new 1(this, iPCRunCgiRespWrapper));
        }
    }
}
