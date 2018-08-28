package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ c uEH;

    c$2(c cVar) {
        this.uEH = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cVar = this.uEH;
        if (cVar.eIW != null) {
            cVar.eIW.dismiss();
            cVar.eIW = null;
        }
        cVar.uEG.cAd();
    }
}
