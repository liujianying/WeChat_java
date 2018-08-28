package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_ecard.b.b.b;

class b$b$2 implements OnClickListener {
    final /* synthetic */ b pCg;

    b$b$2(b bVar) {
        this.pCg = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pCg.pCf.b(this.pCg.fEY, null);
        this.pCg.fEY.finish();
    }
}
