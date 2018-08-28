package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class CollectMainUI$11 implements OnClickListener {
    final /* synthetic */ CollectMainUI hYN;
    final /* synthetic */ atm hYR;

    CollectMainUI$11(CollectMainUI collectMainUI, atm atm) {
        this.hYN = collectMainUI;
        this.hYR = atm;
    }

    public final void onClick(View view) {
        Intent intent;
        if (this.hYR.type == 1) {
            if (this.hYR.url.equals("wxpay://f2f/f2fdetail")) {
                intent = new Intent(this.hYN.mController.tml, CollectBillUI.class);
                intent.putExtra("key_from_scene", 0);
                this.hYN.startActivityForResult(intent, 4097);
                h.mEJ.h(13944, new Object[]{Integer.valueOf(1)});
                h.mEJ.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(1), this.hYR.bSc, "", "", "", Integer.valueOf(2)});
                if (this.hYR.rWT == 1) {
                    h.mEJ.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(1), this.hYR.bSc, "", "", "", Integer.valueOf(2)});
                }
            }
        } else if (this.hYR.type == 2) {
            if (bi.oW(this.hYR.url)) {
                x.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
                return;
            }
            e.l(this.hYN.mController.tml, this.hYR.url, false);
            h.mEJ.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(2), this.hYR.bSc, "", "", this.hYR.url, Integer.valueOf(2)});
            if (this.hYR.rWT == 1) {
                h.mEJ.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(2), this.hYR.bSc, "", "", this.hYR.url, Integer.valueOf(2)});
            }
        } else if (this.hYR.type == 3) {
            qu quVar = new qu();
            quVar.cbq.userName = this.hYR.rWQ;
            quVar.cbq.cbs = bi.aG(this.hYR.rWR, "");
            quVar.cbq.scene = 1072;
            quVar.cbq.cbt = 0;
            a.sFg.m(quVar);
            h.mEJ.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(3), this.hYR.bSc, this.hYR.rWQ, this.hYR.rWR, "", Integer.valueOf(2)});
            if (this.hYR.rWT == 1) {
                h.mEJ.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(3), this.hYR.bSc, this.hYR.rWQ, this.hYR.rWR, "", Integer.valueOf(2)});
            }
        } else {
            intent = new Intent(this.hYN.mController.tml, CollectBillUI.class);
            intent.putExtra("key_from_scene", 0);
            this.hYN.startActivityForResult(intent, 4097);
            h.mEJ.h(13944, new Object[]{Integer.valueOf(1)});
        }
        this.hYN.hYC.setVisibility(4);
        this.hYN.hYD.setVisibility(8);
    }
}
