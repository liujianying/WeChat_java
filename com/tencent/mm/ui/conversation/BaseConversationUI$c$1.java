package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.c;

class BaseConversationUI$c$1 implements Runnable {
    final /* synthetic */ c unv;

    BaseConversationUI$c$1(c cVar) {
        this.unv = cVar;
    }

    public final void run() {
        boolean z = true;
        String str = "MicroMsg.BaseConversationUI";
        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
        Object[] objArr = new Object[1];
        if (this.unv.unn.chattingFragmet != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.unv.unn.chattingFragmet != null) {
            x.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
            this.unv.unn.chattingFragmet.onActivityResult(this.unv.bRZ & 65535, this.unv.bjW, this.unv.bSa);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob_onActivityResult";
    }
}
