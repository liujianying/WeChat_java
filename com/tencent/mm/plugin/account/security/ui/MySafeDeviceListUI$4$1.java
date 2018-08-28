package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.4;

class MySafeDeviceListUI$4$1 implements OnCancelListener {
    final /* synthetic */ c eOC;
    final /* synthetic */ 4 eON;

    MySafeDeviceListUI$4$1(4 4, c cVar) {
        this.eON = 4;
        this.eOC = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eOC);
    }
}
