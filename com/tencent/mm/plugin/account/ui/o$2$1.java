package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.ui.o.2;

class o$2$1 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ 2 eTP;

    o$2$1(2 2, s sVar) {
        this.eTP = 2;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
        g.DF().b(126, this.eTP.eTO);
    }
}
