package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h$4 implements OnClickListener {
    final /* synthetic */ h pCY;

    h$4(h hVar) {
        this.pCY = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.pCY.pCU.bJX != null) {
            this.pCY.pCU.bVT.ret = 1;
            this.pCY.pCU.bJX.run();
        }
    }
}
