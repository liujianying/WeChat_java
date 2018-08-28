package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.soter.c.e;

class c$2 implements e {
    final /* synthetic */ c pGD;
    final /* synthetic */ SharedPreferences pGE;

    c$2(c cVar, SharedPreferences sharedPreferences) {
        this.pGD = cVar;
        this.pGE = sharedPreferences;
    }

    public final void xR(int i) {
        if (!this.pGD.mcv) {
            if (i == 0) {
                c.fg(this.pGE.getString("cpu_id", null), this.pGE.getString("uid", null));
            } else if (this.pGD.pGA != null) {
                this.pGD.pGA.af(2, "init soter failed");
            }
        }
    }
}
