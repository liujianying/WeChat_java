package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

class IPCallPackageUI$2 implements OnCancelListener {
    final /* synthetic */ IPCallPackageUI kwX;

    IPCallPackageUI$2(IPCallPackageUI iPCallPackageUI) {
        this.kwX = iPCallPackageUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            if (IPCallPackageUI.a(this.kwX) != null) {
                au.DF().c(IPCallPackageUI.a(this.kwX));
            }
            this.kwX.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[]{e.getMessage()});
        }
    }
}
