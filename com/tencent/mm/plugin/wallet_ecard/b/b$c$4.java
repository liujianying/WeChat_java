package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_ecard.b.b.c;

class b$c$4 implements OnClickListener {
    final /* synthetic */ c pCh;

    b$c$4(c cVar) {
        this.pCh = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pCh.pCf.b(this.pCh.fEY, null);
    }
}
