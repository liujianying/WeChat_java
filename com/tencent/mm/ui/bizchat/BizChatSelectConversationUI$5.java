package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.a.n;
import com.tencent.mm.model.au;

class BizChatSelectConversationUI$5 implements OnCancelListener {
    final /* synthetic */ BizChatSelectConversationUI tFv;
    final /* synthetic */ n tFw;

    BizChatSelectConversationUI$5(BizChatSelectConversationUI bizChatSelectConversationUI, n nVar) {
        this.tFv = bizChatSelectConversationUI;
        this.tFw = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.tFw);
    }
}
