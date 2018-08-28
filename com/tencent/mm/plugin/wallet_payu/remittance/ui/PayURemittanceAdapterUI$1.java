package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PayURemittanceAdapterUI$1 implements a {
    final /* synthetic */ long hWz;
    final /* synthetic */ Intent myN;
    final /* synthetic */ e pFX;
    final /* synthetic */ PayURemittanceAdapterUI pFY;

    PayURemittanceAdapterUI$1(PayURemittanceAdapterUI payURemittanceAdapterUI, long j, e eVar, Intent intent) {
        this.pFY = payURemittanceAdapterUI;
        this.hWz = j;
        this.pFX = eVar;
        this.myN = intent;
    }

    public final void x(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
            c.J(str, 3);
            q.KJ().jO(str);
        } else {
            x.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
        }
        this.pFY.c(PayURemittanceAdapterUI.a(this.pFY), this.pFX.scene, this.myN);
    }
}
