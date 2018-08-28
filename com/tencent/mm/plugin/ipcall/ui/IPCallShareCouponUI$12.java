package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class IPCallShareCouponUI$12 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$12(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(13340, new Object[]{Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
        Intent intent = new Intent();
        intent.setClass(this.kyP.mController.tml, IPCallShareCouponCardUI.class);
        this.kyP.mController.tml.startActivity(intent);
    }
}
