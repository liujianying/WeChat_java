package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class s$4 implements a {
    final /* synthetic */ s tQv;

    s$4(s sVar) {
        this.tQv = sVar;
    }

    public final void a(String str, l lVar) {
        x.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify " + str);
        if (this.tQv.bAG.cwr() && !bi.oW(str)) {
            this.tQv.cvn();
            this.tQv.cvp();
        }
    }
}
