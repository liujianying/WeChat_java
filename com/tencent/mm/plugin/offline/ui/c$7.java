package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;

class c$7 implements OnClickListener {
    final /* synthetic */ c lLe;

    c$7(c cVar) {
        this.lLe = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((b) g.l(b.class)).c(this.lLe.mActivity, new Intent());
    }
}
