package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$4 implements a {
    final /* synthetic */ e tOC;

    e$4(e eVar) {
        this.tOC = eVar;
    }

    public final void a(String str, l lVar) {
        x.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify " + str);
        if (this.tOC.tOv) {
            m.c(this.tOC.bAG.getTalkerUserName(), this.tOC.tOw);
        } else {
            this.tOC.tOw.clear();
        }
        if (!bi.oW(str)) {
            this.tOC.bAG.avj();
        }
    }
}
