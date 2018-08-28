package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.chatting.c.1;

class c$1$1 implements OnCancelListener {
    final /* synthetic */ 1 tGZ;

    c$1$1(1 1) {
        this.tGZ = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().b(1030, this.tGZ.tGY);
    }
}
