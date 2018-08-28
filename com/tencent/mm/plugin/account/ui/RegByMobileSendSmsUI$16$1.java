package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.16;

class RegByMobileSendSmsUI$16$1 implements OnCancelListener {
    final /* synthetic */ s eTB;
    final /* synthetic */ 16 eVp;

    RegByMobileSendSmsUI$16$1(16 16, s sVar) {
        this.eVp = 16;
        this.eTB = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eTB);
    }
}
