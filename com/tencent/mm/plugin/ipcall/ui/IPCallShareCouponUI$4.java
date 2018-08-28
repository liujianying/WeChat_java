package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class IPCallShareCouponUI$4 implements OnCancelListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$4(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            this.kyP.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[]{e.getMessage()});
        }
    }
}
