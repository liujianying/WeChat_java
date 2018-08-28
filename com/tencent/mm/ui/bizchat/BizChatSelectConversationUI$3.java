package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q$a;

class BizChatSelectConversationUI$3 implements q$a {
    final /* synthetic */ long dAC;
    final /* synthetic */ String dMs;
    final /* synthetic */ BizChatSelectConversationUI tFv;

    BizChatSelectConversationUI$3(BizChatSelectConversationUI bizChatSelectConversationUI, String str, long j) {
        this.tFv = bizChatSelectConversationUI;
        this.dMs = str;
        this.dAC = j;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("enterprise_biz_name", this.dMs);
            intent.putExtra("key_biz_chat_id", this.dAC);
            intent.putExtra("key_is_biz_chat", true);
            this.tFv.setResult(-1, intent);
            this.tFv.finish();
        }
    }
}
