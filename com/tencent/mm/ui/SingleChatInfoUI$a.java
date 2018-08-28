package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class SingleChatInfoUI$a implements OnCancelListener {
    private SingleChatInfoUI$a() {
    }

    /* synthetic */ SingleChatInfoUI$a(byte b) {
        this();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SingleChatInfoUI.dv(true);
    }
}
