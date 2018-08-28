package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.a.n;
import com.tencent.mm.model.au;

class BizChatroomInfoUI$5 implements OnCancelListener {
    final /* synthetic */ BizChatroomInfoUI tFD;
    final /* synthetic */ n tFw;

    BizChatroomInfoUI$5(BizChatroomInfoUI bizChatroomInfoUI, n nVar) {
        this.tFD = bizChatroomInfoUI;
        this.tFw = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.tFw);
    }
}
