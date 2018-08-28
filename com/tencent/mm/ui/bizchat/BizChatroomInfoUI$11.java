package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class BizChatroomInfoUI$11 implements OnCancelListener {
    final /* synthetic */ BizChatroomInfoUI tFD;

    BizChatroomInfoUI$11(BizChatroomInfoUI bizChatroomInfoUI) {
        this.tFD = bizChatroomInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        BizChatroomInfoUI.e(this.tFD);
    }
}
