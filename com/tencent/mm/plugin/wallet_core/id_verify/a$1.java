package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ Intent dgK;
    final /* synthetic */ Activity ews;
    final /* synthetic */ sz pjW;
    final /* synthetic */ a pjX;

    a$1(a aVar, sz szVar, Intent intent, Activity activity) {
        this.pjX = aVar;
        this.pjW = szVar;
        this.dgK = intent;
        this.ews = activity;
    }

    public final void run() {
        this.pjW.bJX = null;
        a.a(this.pjX);
        tk tkVar;
        if (bi.oW(a.b(this.pjX)) || bi.oW(a.c(this.pjX))) {
            this.pjX.ag(this.ews);
            if (a.d(this.pjX) == -1) {
                tkVar = new tk();
                tkVar.ceX.result = a.d(this.pjX);
                a.sFg.m(tkVar);
                return;
            }
            return;
        }
        x.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.b(this.pjX) + a.c(this.pjX));
        boolean z = this.pjX.jfZ.getBoolean("process_finish_stay_orgpage", true);
        this.dgK.putExtra("key_process_is_end", true);
        this.dgK.putExtra("key_process_is_stay", z);
        a.a(this.pjX, this.ews, a.b(this.pjX), a.c(this.pjX), a.d(this.pjX), this.dgK, z);
        if (a.d(this.pjX) == -1) {
            tkVar = new tk();
            tkVar.ceX.result = a.d(this.pjX);
            a.sFg.m(tkVar);
        }
    }
}
