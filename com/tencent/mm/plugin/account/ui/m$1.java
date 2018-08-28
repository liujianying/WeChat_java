package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;

class m$1 implements OnCancelListener {
    final /* synthetic */ l eTH;
    final /* synthetic */ m eTI;

    m$1(m mVar, l lVar) {
        this.eTI = mVar;
        this.eTH = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTH);
        g.DF().b(145, this.eTI);
        g.DF().b(132, this.eTI);
    }
}
