package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.ui.EmailVerifyUI.3.1;

class EmailVerifyUI$3$1$1 implements OnCancelListener {
    final /* synthetic */ z ePZ;
    final /* synthetic */ 1 eQa;

    EmailVerifyUI$3$1$1(1 1, z zVar) {
        this.eQa = 1;
        this.ePZ = zVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.ePZ);
    }
}
