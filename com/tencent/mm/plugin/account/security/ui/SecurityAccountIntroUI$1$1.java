package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.1;

class SecurityAccountIntroUI$1$1 implements OnCancelListener {
    final /* synthetic */ l ePb;
    final /* synthetic */ 1 ePc;

    SecurityAccountIntroUI$1$1(1 1, l lVar) {
        this.ePc = 1;
        this.ePb = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.ePb);
    }
}
