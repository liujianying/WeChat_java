package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$9 implements OnCancelListener {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$9(a aVar) {
        this.tEC = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tEC.finish();
    }
}
