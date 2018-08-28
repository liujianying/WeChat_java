package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.ipcall.a.e.f;

class IPCallPackageUI$4 implements OnClickListener {
    final /* synthetic */ IPCallPackageUI kwX;

    IPCallPackageUI$4(IPCallPackageUI iPCallPackageUI) {
        this.kwX = iPCallPackageUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f b = IPCallPackageUI.b(this.kwX);
        b.krX++;
        IPCallPackageUI.b(this.kwX).finish();
        Intent intent = new Intent();
        intent.setClass(this.kwX.mController.tml, IPCallRechargeUI.class);
        this.kwX.startActivity(intent);
        this.kwX.finish();
    }
}
