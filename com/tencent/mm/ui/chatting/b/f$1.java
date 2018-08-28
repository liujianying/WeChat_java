package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    final /* synthetic */ f tOK;

    f$1(f fVar) {
        this.tOK = fVar;
    }

    public final void a(String str, l lVar) {
        x.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[]{str});
        if (str == null) {
            return;
        }
        if (str.equals(this.tOK.bAG.getTalkerUserName()) || str.equals("*")) {
            this.tOK.bVP();
        }
    }
}
