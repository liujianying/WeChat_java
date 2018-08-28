package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;

class EmailVerifyUI$7 implements OnCancelListener {
    final /* synthetic */ EmailVerifyUI ePX;
    final /* synthetic */ z ePZ;

    EmailVerifyUI$7(EmailVerifyUI emailVerifyUI, z zVar) {
        this.ePX = emailVerifyUI;
        this.ePZ = zVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.ePZ);
    }
}
