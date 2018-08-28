package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.2;

class ModSafeDeviceNameUI$2$1 implements OnCancelListener {
    final /* synthetic */ c eOC;
    final /* synthetic */ 2 eOD;

    ModSafeDeviceNameUI$2$1(2 2, c cVar) {
        this.eOD = 2;
        this.eOC = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eOC);
    }
}
