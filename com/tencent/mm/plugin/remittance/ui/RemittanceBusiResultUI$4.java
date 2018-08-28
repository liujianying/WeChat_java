package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBusiResultUI$4 implements OnClickListener {
    final /* synthetic */ RemittanceBusiResultUI mAr;
    final /* synthetic */ kd mAt;

    RemittanceBusiResultUI$4(RemittanceBusiResultUI remittanceBusiResultUI, kd kdVar) {
        this.mAr = remittanceBusiResultUI;
        this.mAt = kdVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[]{Integer.valueOf(this.mAt.type)});
        if (this.mAt.type == 1) {
            RemittanceBusiResultUI.a(this.mAr);
            qu quVar = new qu();
            quVar.cbq.userName = this.mAt.rlM;
            quVar.cbq.cbs = bi.aG(this.mAt.rlN, "");
            quVar.cbq.scene = 1034;
            quVar.cbq.cbt = 0;
            a.sFg.m(quVar);
        } else if (this.mAt.type == 2) {
            RemittanceBusiResultUI.a(this.mAr);
            e.l(this.mAr.mController.tml, this.mAt.url, true);
        } else {
            int i = this.mAt.type;
        }
    }
}
