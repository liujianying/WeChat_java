package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;

class d$2 implements a {
    final /* synthetic */ d kMC;

    d$2(d dVar) {
        this.kMC = dVar;
    }

    public final void c(int i, Intent intent) {
        Intent putExtra = new Intent().putExtra("sendId", this.kMC.kMz.sbb);
        if (i == -1) {
            putExtra.putExtra("result_share_msg", true);
        } else {
            putExtra.putExtra("result_share_msg", false);
        }
        d dVar = this.kMC;
        dVar.kMA = false;
        if (dVar.kMy != null) {
            dVar.kMy.b(-1, putExtra);
        }
    }
}
