package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class al$2 implements OnClickListener {
    final /* synthetic */ al tMK;

    al$2(al alVar) {
        this.tMK = alVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.tMK.activity.finish();
    }
}
