package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aj$3 implements OnClickListener {
    final /* synthetic */ aj tSJ;
    final /* synthetic */ String tSK;

    aj$3(aj ajVar, String str) {
        this.tSJ = ajVar;
        this.tSK = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tSJ.aar(this.tSK);
    }
}
