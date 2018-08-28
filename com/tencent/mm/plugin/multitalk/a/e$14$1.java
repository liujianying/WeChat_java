package com.tencent.mm.plugin.multitalk.a;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a.e.14;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ad;

class e$14$1 implements a {
    final /* synthetic */ 14 ltP;

    e$14$1(14 14) {
        this.ltP = 14;
    }

    public final boolean aWU() {
        if (this.ltP.ltL.bgm() || this.ltP.ltL.bgn()) {
            return true;
        }
        return false;
    }

    public final void a(Intent intent, h hVar) {
        if (this.ltP.ltL.bgn()) {
            int i = this.ltP.ltL.ltw;
            hVar.OI(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
            return;
        }
        hVar.OI(ad.getContext().getString(R.l.multitalk_waiting_wording));
    }
}
