package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ac$3 implements OnClickListener {
    final /* synthetic */ ac tRo;

    ac$3(ac acVar) {
        this.tRo = acVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ac.a(this.tRo) != null) {
            ac.a(this.tRo).dismiss();
        }
    }
}
