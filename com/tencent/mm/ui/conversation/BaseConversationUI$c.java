package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class BaseConversationUI$c implements Runnable {
    int bRZ;
    Intent bSa;
    int bjW;
    int tpz;
    final /* synthetic */ BaseConversationUI unn;

    private BaseConversationUI$c(BaseConversationUI baseConversationUI) {
        this.unn = baseConversationUI;
        this.tpz = 0;
    }

    /* synthetic */ BaseConversationUI$c(BaseConversationUI baseConversationUI, byte b) {
        this(baseConversationUI);
    }

    public final void run() {
        if (au.HX()) {
            x.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", new Object[]{Integer.valueOf(this.tpz)});
            this.unn.startChatting(BaseConversationUI.access$1500(this.unn));
            ah.A(new 1(this));
        } else if (this.tpz >= 3) {
            x.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
        } else {
            x.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", new Object[]{Integer.valueOf(this.tpz)});
            this.tpz++;
            ah.i(this, 300);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob";
    }
}
