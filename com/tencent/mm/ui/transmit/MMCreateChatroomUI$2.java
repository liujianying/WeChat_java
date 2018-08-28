package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.b.a;

class MMCreateChatroomUI$2 implements OnCancelListener {
    final /* synthetic */ MMCreateChatroomUI uDk;

    MMCreateChatroomUI$2(MMCreateChatroomUI mMCreateChatroomUI) {
        this.uDk = mMCreateChatroomUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        MMCreateChatroomUI.a(this.uDk, false);
        if (MMCreateChatroomUI.e(this.uDk) != null) {
            MMCreateChatroomUI.e(this.uDk).bTO.bTN = true;
            a.sFg.m(MMCreateChatroomUI.e(this.uDk));
        }
    }
}
