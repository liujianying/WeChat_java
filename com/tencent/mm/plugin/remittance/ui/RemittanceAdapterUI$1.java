package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceAdapterUI$1 implements a {
    final /* synthetic */ long hWz;
    final /* synthetic */ w myM;
    final /* synthetic */ Intent myN;
    final /* synthetic */ RemittanceAdapterUI myO;

    RemittanceAdapterUI$1(RemittanceAdapterUI remittanceAdapterUI, long j, w wVar, Intent intent) {
        this.myO = remittanceAdapterUI;
        this.hWz = j;
        this.myM = wVar;
        this.myN = intent;
    }

    public final void x(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
            c.J(str, 3);
            q.KJ().jO(str);
        } else {
            x.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
        }
        this.myO.c(this.myO.cYO, this.myM.scene, this.myN);
    }
}
