package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h$5 implements OnClickListener {
    final /* synthetic */ h pCY;

    h$5(h hVar) {
        this.pCY = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.pCY.pCT.bJX != null) {
            this.pCY.pCT.bQe.ret = 1;
            this.pCY.pCT.bJX.run();
        }
    }
}
