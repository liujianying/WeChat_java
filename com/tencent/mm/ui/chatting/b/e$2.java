package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.jy;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;

class e$2 implements Runnable {
    final /* synthetic */ e tOC;

    e$2(e eVar) {
        this.tOC = eVar;
    }

    public final void run() {
        if (this.tOC.bAG == null) {
            x.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            return;
        }
        au.HU();
        u ih = c.Ga().ih(this.tOC.bAG.getTalkerUserName());
        if (ih != null && ih.ckL()) {
            x.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            jy jyVar = new jy();
            jyVar.bUc.chatroomName = this.tOC.bAG.getTalkerUserName();
            jyVar.bUc.bUd = ih.ckK();
            a.sFg.m(jyVar);
        }
    }
}
