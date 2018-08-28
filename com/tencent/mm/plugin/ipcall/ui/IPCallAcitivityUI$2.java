package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class IPCallAcitivityUI$2 implements OnClickListener {
    final /* synthetic */ IPCallAcitivityUI ktx;

    IPCallAcitivityUI$2(IPCallAcitivityUI iPCallAcitivityUI) {
        this.ktx = iPCallAcitivityUI;
    }

    public final void onClick(View view) {
        if (IPCallAcitivityUI.a(this.ktx).hcE == 1) {
            x.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
            Intent intent = new Intent();
            intent.setClass(this.ktx.mController.tml, IPCallShareCouponUI.class);
            this.ktx.startActivity(intent);
            intent = new Intent();
            intent.setClass(this.ktx.mController.tml, IPCallPackageUI.class);
            this.ktx.startActivity(intent);
        }
        IPCallAcitivityUI.b(this.ktx);
        this.ktx.finish();
    }
}
