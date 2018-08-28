package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ac$2 implements OnClickListener {
    final /* synthetic */ ac tRo;

    ac$2(ac acVar) {
        this.tRo = acVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
