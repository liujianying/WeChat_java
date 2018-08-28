package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.storage.aa.a;

class IPCallShareCouponUI$13 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$13(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        au.HU();
        if (((Boolean) c.DT().get(a.sRk, Boolean.valueOf(false))).booleanValue()) {
            au.HU();
            i.M(4, -1, ((Integer) c.DT().get(a.sRl, Integer.valueOf(-1))).intValue());
        }
        au.HU();
        c.DT().a(a.sRl, Integer.valueOf(-1));
        au.HU();
        c.DT().a(a.sRk, Boolean.valueOf(false));
        IPCallShareCouponUI.g(this.kyP).setVisibility(8);
        Intent intent = new Intent();
        intent.setClass(this.kyP.mController.tml, IPCallMsgUI.class);
        this.kyP.mController.tml.startActivity(intent);
    }
}
