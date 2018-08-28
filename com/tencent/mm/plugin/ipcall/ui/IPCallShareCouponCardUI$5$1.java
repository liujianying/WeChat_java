package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.5;

class IPCallShareCouponCardUI$5$1 implements OnCancelListener {
    final /* synthetic */ h kyl;
    final /* synthetic */ 5 kym;

    IPCallShareCouponCardUI$5$1(5 5, h hVar) {
        this.kym = 5;
        this.kyl = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.kyl);
    }
}
