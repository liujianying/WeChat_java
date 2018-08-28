package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.a.x;
import com.tencent.mm.model.au;

class BizChatroomInfoUI$6 implements OnCancelListener {
    final /* synthetic */ BizChatroomInfoUI tFD;
    final /* synthetic */ x tFE;

    BizChatroomInfoUI$6(BizChatroomInfoUI bizChatroomInfoUI, x xVar) {
        this.tFD = bizChatroomInfoUI;
        this.tFE = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.tFE);
    }
}
