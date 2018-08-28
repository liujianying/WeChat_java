package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class SelectConversationUI$15 implements a {
    final /* synthetic */ SelectConversationUI uEC;
    final /* synthetic */ Intent val$intent;

    SelectConversationUI$15(SelectConversationUI selectConversationUI, Intent intent) {
        this.uEC = selectConversationUI;
        this.val$intent = intent;
    }

    public final void a(boolean z, String str, int i) {
        this.uEC.YC();
        if (z) {
            this.val$intent.putExtra("custom_send_text", str);
            SelectConversationUI.a(this.uEC, this.val$intent);
            this.uEC.finish();
        }
    }
}
