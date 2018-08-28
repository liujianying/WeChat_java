package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.d.a.a.t;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;

class h$2 implements OnClickListener {
    final /* synthetic */ b hHD;
    final /* synthetic */ h hHE;

    h$2(h hVar, b bVar) {
        this.hHE = hVar;
        this.hHD = bVar;
    }

    public final void onClick(View view) {
        if (this.hHD.awf()) {
            j.b bVar = new j.b();
            com.tencent.mm.plugin.card.d.b.a(this.hHE.hHC.gKS, bVar.huK, bVar.huL, false, this.hHD);
        } else {
            pr prVar = this.hHD.awm().rok;
            if (prVar != null && !bi.oW(prVar.rnw) && !bi.oW(prVar.rnv)) {
                int intExtra;
                int intExtra2;
                if (this.hHE.gKS.getIntent() != null) {
                    intExtra = this.hHE.gKS.getIntent().getIntExtra("key_from_scene", 3);
                } else {
                    intExtra = 3;
                }
                if (this.hHE.gKS.getIntent() != null) {
                    intExtra2 = this.hHE.gKS.getIntent().getIntExtra("key_from_appbrand_type", 0);
                } else {
                    intExtra2 = 0;
                }
                com.tencent.mm.plugin.card.d.b.a(this.hHD.awq(), prVar, intExtra, intExtra2);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(20), this.hHD.awq(), this.hHD.awr(), "", prVar.title});
            } else if (!(prVar == null || TextUtils.isEmpty(prVar.url))) {
                com.tencent.mm.plugin.card.d.b.a(this.hHE.hHC.gKS, l.x(prVar.url, prVar.roL), 1);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(9), this.hHD.awq(), this.hHD.awr(), "", prVar.title});
                if (l.a(prVar, this.hHD.awq())) {
                    String awq = this.hHD.awq();
                    String str = prVar.title;
                    l.yb(awq);
                    com.tencent.mm.plugin.card.d.b.a(this.hHE.hHC.gKS, this.hHD.awm().hwh);
                }
            }
        }
        t.finish();
    }
}
