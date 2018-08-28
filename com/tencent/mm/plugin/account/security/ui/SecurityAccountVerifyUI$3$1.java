package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.3;

class SecurityAccountVerifyUI$3$1 implements OnCancelListener {
    final /* synthetic */ l ePb;
    final /* synthetic */ 3 ePj;

    SecurityAccountVerifyUI$3$1(3 3, l lVar) {
        this.ePj = 3;
        this.ePb = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.ePb);
    }
}
