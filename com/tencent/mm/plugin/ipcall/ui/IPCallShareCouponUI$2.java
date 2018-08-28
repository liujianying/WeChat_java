package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class IPCallShareCouponUI$2 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$2(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.kyP.mController.tml, IPCallPackageUI.class);
        this.kyP.startActivity(intent);
    }
}
