package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;

class IPCallShareCouponCardUI$3 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponCardUI kyi;

    IPCallShareCouponCardUI$3(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.kyi = iPCallShareCouponCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.b(this.kyi.mController.tml, "account", ".ui.FacebookAuthUI", new Intent());
    }
}
