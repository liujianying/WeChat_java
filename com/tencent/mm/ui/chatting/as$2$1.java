package com.tencent.mm.ui.chatting;

import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.pluginsdk.model.app.g.a;
import com.tencent.mm.ui.chatting.as.2;

class as$2$1 implements a {
    final /* synthetic */ Req qzI;
    final /* synthetic */ 2 tND;

    as$2$1(2 2, Req req) {
        this.tND = 2;
        this.qzI = req;
    }

    public final void cI(boolean z) {
        if (z) {
            as.b(this.tND.tNC).put(this.qzI.transaction, this.qzI);
        }
    }
}
