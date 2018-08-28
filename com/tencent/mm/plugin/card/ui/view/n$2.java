package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;

class n$2 implements OnClickListener {
    final /* synthetic */ n hHP;
    final /* synthetic */ pr hHQ;
    final /* synthetic */ b hHR;

    n$2(n nVar, pr prVar, b bVar) {
        this.hHP = nVar;
        this.hHQ = prVar;
        this.hHR = bVar;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.hHQ.rnw) && !bi.oW(this.hHQ.rnv)) {
            int intExtra;
            int intExtra2 = this.hHP.gKS.getIntent() != null ? this.hHP.gKS.getIntent().getIntExtra("key_from_scene", 3) : 3;
            if (this.hHP.gKS.getIntent() != null) {
                intExtra = this.hHP.gKS.getIntent().getIntExtra("key_from_appbrand_type", 0);
            } else {
                intExtra = 0;
            }
            com.tencent.mm.plugin.card.d.b.a(this.hHR.awq(), this.hHQ, intExtra2, intExtra);
            h.mEJ.h(11941, new Object[]{Integer.valueOf(20), this.hHR.awq(), this.hHR.awr(), "", this.hHQ.title});
        } else if (bi.oW(this.hHQ.url)) {
            d.a(this.hHP.gKS, this.hHP.gKS.getString(g.card_wallet_unknown_err), true);
        } else {
            com.tencent.mm.plugin.card.d.b.a(this.hHP.gKS, l.x(this.hHQ.url, this.hHQ.roL), 1);
            h hVar = h.mEJ;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(9);
            objArr[1] = this.hHR.awq();
            objArr[2] = this.hHR.awr();
            objArr[3] = "";
            objArr[4] = this.hHQ.title != null ? this.hHQ.title : "";
            hVar.h(11941, objArr);
        }
    }
}
