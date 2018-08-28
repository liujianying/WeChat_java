package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BaseConversationUI$3 implements IdleHandler {
    final /* synthetic */ BaseConversationUI unn;

    BaseConversationUI$3(BaseConversationUI baseConversationUI) {
        this.unn = baseConversationUI;
    }

    public final boolean queueIdle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (BaseConversationUI.access$200(this.unn) == null) {
            String GF;
            if (this.unn.conversationFm == null || bi.oW(this.unn.conversationFm.getUserName())) {
                GF = q.GF();
            } else {
                GF = this.unn.conversationFm.getUserName();
            }
            BaseConversationUI.access$300(this.unn, new Intent().putExtra("Chat_User", GF), true);
            BaseConversationUI.access$200(this.unn).setVisibility(8);
            this.unn.resumeMainFragment();
        }
        x.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return false;
    }
}
